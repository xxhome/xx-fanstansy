package com.xxbase.dao;

import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.path.PathBuilder;
import com.xxbase.entity.AbstractBaseEntity;
import com.xxbase.entity.AbstractSimpleEntity;
import com.xxbase.exception.EntityNoExistNameException;
import com.xxbase.method.Page;
import com.xxbase.method.Queryable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.constraints.NotNull;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;

/**
 * @author li.fang
 * @since 2017/02/17
 */
public abstract class BaseDaoImpl<T extends AbstractBaseEntity, ID extends Long> implements BaseDao<T, ID> {

    @PersistenceContext
    public EntityManager entityManager;

    private Class<T> clazz = null;

    public Map<String, Boolean> fieldNames = new HashMap<String, Boolean>();

    public BaseDaoImpl() {
        Type type = getClass().getGenericSuperclass();
        Type[] arrayType = ((ParameterizedType) type).getActualTypeArguments();
        clazz = (Class) arrayType[0];
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            fieldNames.put(field.getName(), true);
        }
    }

    @Override
    public T findById(@NotNull ID id) {
        return entityManager.find(clazz, id);
    }

    @Override
    public Page<T> find(List<Queryable> queryables) {
        PathBuilder<T> pathBuilder = new PathBuilder<T>(clazz, "o");

        JPAQuery jpaQuery = new JPAQuery(entityManager);

        return null;
    }

    @Override
    public T findOneByName(String name) throws EntityNoExistNameException {
        PathBuilder<T> pathBuilder = new PathBuilder<T>(clazz, "o");
        JPAQuery jpaQuery = new JPAQuery(entityManager);
        if (AbstractSimpleEntity.class.isAssignableFrom(clazz)) {
            return jpaQuery.from(pathBuilder).where(pathBuilder.getString("name").eq(name)).singleResult(pathBuilder);
        }
        return null;
    }

    @Override
    public Page<T> findAll() {
        PathBuilder<T> pathBuilder = new PathBuilder<>(clazz, "o");

        JPAQuery jpaQuery = new JPAQuery(entityManager);

        List<T> result = jpaQuery.from(pathBuilder).list(pathBuilder);

        return new Page<>(result.size(), result);
    }

    @Override
    public Page<T> findPages(int pageNo, int pageSize) {
        PathBuilder<T> pathBuilder = new PathBuilder<>(clazz, "o");

        JPAQuery jpaQuery = new JPAQuery(entityManager);

        int offset = Math.max(0, pageNo -1) * pageSize;
        List<T> result = jpaQuery.from(pathBuilder).offset(offset).limit(pageSize).list(pathBuilder);

        return new Page<>(result.size(), result);
    }

    @Override
    public Page<T> findByName(String name) throws EntityNoExistNameException {
        PathBuilder<T> pathBuilder = new PathBuilder<T>(clazz, "o");
        JPAQuery jpaQuery = new JPAQuery(entityManager);
        if (AbstractSimpleEntity.class.isAssignableFrom(clazz)) {
            List<T> result = jpaQuery.from(pathBuilder).where(pathBuilder.getString("name").eq(name)).list(pathBuilder);
            return new Page<T>(result.size(), result);
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
    public long count() {
        PathBuilder<T> pathBuilder = new PathBuilder<>(clazz, "o");
        JPAQuery jpaQuery = new JPAQuery(entityManager);
        return jpaQuery.from(pathBuilder).count();
    }

    @Override
    public long count(String name) throws EntityNoExistNameException {
        PathBuilder<T> pathBuilder = new PathBuilder<>(clazz, "o");
        JPAQuery jpaQuery = new JPAQuery(entityManager);

        if(AbstractSimpleEntity.class.isAssignableFrom(clazz)) {
            return jpaQuery.from(pathBuilder).where(pathBuilder.getString("name").eq(name)).count();
        }
        throw new EntityNoExistNameException("%s不存在名称为name的属性", clazz.getName());
    }
}
