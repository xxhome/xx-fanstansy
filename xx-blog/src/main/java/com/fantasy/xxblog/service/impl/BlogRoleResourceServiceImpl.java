package com.fantasy.xxblog.service.impl;

import com.fantasy.xxbase.dao.BaseDao;
import com.fantasy.xxbase.service.impl.BaseServiceImpl;
import com.fantasy.xxblog.entity.BlogRoleResourceEntity;
import com.fantasy.xxblog.service.BlogRoleResourceService;
import com.fantasy.xxcore.datasource.XXDynamicDataSource;
import com.fantasy.xxcore.datasource.XXDynamicDataSourceHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author li.fang
 * @since 2017/6/3
 */
@Service
@XXDynamicDataSource(XXDynamicDataSourceHolder.DATASOURCE_BLOG)
public class BlogRoleResourceServiceImpl extends BaseServiceImpl<BlogRoleResourceEntity> implements BlogRoleResourceService {

    @Autowired
    public void setBaseDao(BaseDao<BlogRoleResourceEntity> baseDao) {
        super.setBaseDao(baseDao);
    }
}
