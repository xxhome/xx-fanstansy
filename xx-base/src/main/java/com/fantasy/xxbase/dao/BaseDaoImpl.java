package com.fantasy.xxbase.dao;

import com.fantasy.xxbase.entity.XXBaseEntity;
import com.fantasy.xxbase.entity.XXSimpleEntity;
import com.fantasy.xxbase.vo.Page;
import com.fantasy.xxbase.vo.Pageable;
import com.fantasy.xxbase.vo.QueryParam;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.support.Expressions;
import com.mysema.query.types.Ops;
import com.mysema.query.types.expr.BooleanExpression;
import com.mysema.query.types.path.PathBuilder;
import com.fantasy.xxbase.exception.EntityNoExistNameException;
import com.fantasy.xxutil.util.XXClassUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.validation.constraints.NotNull;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;

/**
 * @author li.fang
 * @since 2017/02/17
 */
public abstract class BaseDaoImpl<T extends XXBaseEntity> implements BaseDao<T> {

    private Logger logger = LoggerFactory.getLogger(BaseDaoImpl.class);

    @PersistenceContext
    protected EntityManager entityManager;

    protected Class<T> clazz = null;

    protected List<Field> classDeclaredFields = new ArrayList<>();

    protected final static Map<Class, List<Field>> classDeclaredFieldMap = new HashMap<>();

    public BaseDaoImpl() {
        Type type = getClass().getGenericSuperclass();

        Type[] arrayType = ((ParameterizedType) type).getActualTypeArguments();

        clazz = (Class) arrayType[0];

        if(classDeclaredFieldMap.containsKey(clazz)){
            classDeclaredFields = classDeclaredFieldMap.getOrDefault(clazz, new ArrayList<>());
        }else {
            classDeclaredFields.addAll(XXClassUtils.getClassDeclaredFields(clazz));
            classDeclaredFieldMap.put(clazz, classDeclaredFields);
        }
    }

    @Override
    public T findById(@NotNull String id) {
        return entityManager.find(clazz, id);
    }

    @Override
    public Page<T> find(List<QueryParam> queryParams) {
        PathBuilder<T> pathBuilder = new PathBuilder<T>(clazz, "o");

        JPAQuery jpaQuery = new JPAQuery(entityManager);

        if (CollectionUtils.isEmpty(queryParams)) {
            return findAll();
        }

        List<T> result = jpaQuery.from(pathBuilder).where(buildExpressionFromQueryable(pathBuilder, queryParams)).list(pathBuilder);

        return new Page<T>(result.size(), result);
    }

    @Override
    public Page<T> find(List<QueryParam> queryParams, Pageable pageable) {
        PathBuilder<T> pathBuilder = new PathBuilder<T>(clazz, "o");

        JPAQuery jpaQuery = new JPAQuery(entityManager);

        BooleanExpression booleanExpression = buildExpressionFromQueryable(pathBuilder, queryParams);

        long total = jpaQuery.from(pathBuilder).where().count();

        if (pageable == null || !pageable.isPage()) {
            //不需要分页查询

            List<T> result = jpaQuery.from(pathBuilder).where(booleanExpression).list(pathBuilder);

            return new Page<T>(total, result);

        } else {
            long offset = Math.max(0, pageable.getPageNo() - 1);
            long pageSize = pageable.getPageSize();

            List<T> result = jpaQuery.from(pathBuilder).where(booleanExpression).offset(offset).limit(pageSize).list(pathBuilder);

            return new Page<T>(pageable.getPageNo(), pageable.getPageSize(), total, result);
        }
    }

    private BooleanExpression buildExpressionFromQueryable(PathBuilder<T> pathBuilder, List<QueryParam> queryParams) {
        BooleanExpression booleanExpression = Expressions.predicate(Ops.EQ, Expressions.constant(1), Expressions.constant(1));

        for (QueryParam queryParam : queryParams) {

            String field = queryParam.getField();
            String value = queryParam.getValue();

            if (StringUtils.isAnyBlank(field, value)) continue;

            Field fieldObj = classDeclaredFields.stream()
                    .filter(f -> StringUtils.equals(f.getName(), field))
                    .findFirst()
                    .orElse(null);

            if(fieldObj == null) {
                logger.error("{}不存在名称为{}的属性", clazz.getName(), field);
                continue;
            }

            Class fieldType = fieldObj.getType();

            switch (queryParam.getOps()) {
                case EQ:
                    booleanExpression = booleanExpression.and(pathBuilder.get(field, fieldType).eq(queryParam.getValue()));
                    break;
                case LIKE:
                    booleanExpression = booleanExpression.and(pathBuilder.getString(field).like("%" + value + "%"));
                    break;
            }
        }

        return booleanExpression;
    }


    @Override
    public T findOneByName(String name) throws EntityNoExistNameException {
        PathBuilder<T> pathBuilder = new PathBuilder<T>(clazz, "o");
        JPAQuery jpaQuery = new JPAQuery(entityManager);
        if (XXSimpleEntity.class.isAssignableFrom(clazz)) {
            return jpaQuery.from(pathBuilder).where(pathBuilder.getString("name").eq(name)).singleResult(pathBuilder);
        }
        throw new EntityNoExistNameException("%s不存在名称为name的属性", clazz.getName());
    }

    @Override
    public Page<T> findAll() {
        PathBuilder<T> pathBuilder = new PathBuilder<>(clazz, "o");

        JPAQuery jpaQuery = new JPAQuery(entityManager);

        List<T> result = jpaQuery.from(pathBuilder).list(pathBuilder);

        return new Page<>(result.size(), result);
    }

    @Override
    public Page<T> page(int pageNo, int pageSize) {
        JPAQuery jpaQuery = new JPAQuery(entityManager);

        PathBuilder<T> pathBuilder1 = new PathBuilder<>(clazz, "o1");
        int offset = Math.max(0, pageNo - 1) * pageSize;
        List<T> result = jpaQuery.from(pathBuilder1).offset(offset).limit(pageSize).list(pathBuilder1);

        PathBuilder<T> pathBuilder2 = new PathBuilder<>(clazz, "o2");
        long total = jpaQuery.from(pathBuilder2).count();

        return new Page<>(total, result);
    }

    @Override
    public Page<T> findByName(String name) throws EntityNoExistNameException {
        PathBuilder<T> pathBuilder = new PathBuilder<T>(clazz, "o");
        JPAQuery jpaQuery = new JPAQuery(entityManager);
        if (XXSimpleEntity.class.isAssignableFrom(clazz)) {
            List<T> result = jpaQuery.from(pathBuilder).where(pathBuilder.getString("name").eq(name)).list(pathBuilder);
            return new Page<>(result.size(), result);
        }
        throw new EntityNoExistNameException("%s不存在名称为name的属性", clazz.getName());
    }

    @Override
    public void persist(@NotNull T t) {
        entityManager.persist(t);
    }

    @Override
    public T merge(@NotNull T t) {
        entityManager.merge(t);
        return t;
    }

    @Override
    public void remove(@NotNull T t) {
        entityManager.remove(t);
    }

    @Override
    public long clean() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = builder.createQuery(clazz);
        criteriaQuery.from(clazz);
        List<T> list = entityManager.createQuery(criteriaQuery).getResultList();
        list.stream().forEach(this::remove);
        return list.size();
    }

    @Override
    public long count() {
        PathBuilder<T> pathBuilder = new PathBuilder<>(clazz, "o");
        JPAQuery jpaQuery = new JPAQuery(entityManager);
        return jpaQuery.from(pathBuilder).count();
    }
}
