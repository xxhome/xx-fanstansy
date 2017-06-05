package com.fantasy.xxblog.dao;

import com.fantasy.xxbase.dao.BaseDao;
import com.fantasy.xxblog.entity.BlogAuthorityEntity;

import java.util.List;

/**
 * @author li.fang
 * @since 2017/6/3
 */
public interface BlogAuthorityDao extends BaseDao<BlogAuthorityEntity> {

    List<BlogAuthorityEntity> findByAccountId(String accountId);

}
