package com.fantasy.xxblog.dao.impl;

import com.fantasy.xxbase.dao.BaseDaoImpl;
import com.fantasy.xxblog.dao.BlogAuthorityDao;
import com.fantasy.xxblog.entity.BlogAuthorityEntity;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.path.PathBuilder;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author li.fang
 * @since 2017/6/3
 */
@Repository
public class BlogAuthorityDaoImpl extends BaseDaoImpl<BlogAuthorityEntity> implements BlogAuthorityDao {

    @Override
    public List<BlogAuthorityEntity> findByAccountId(String accountId) {
        PathBuilder<BlogAuthorityEntity> pathBuilder = new PathBuilder<>(clazz, "o");
        JPAQuery jpaQuery = new JPAQuery(entityManager);
        return jpaQuery.from(pathBuilder).where(pathBuilder.getString("accountId").eq(accountId)).list(pathBuilder);
    }

}