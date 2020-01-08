package com.fantasy.xxblog.service.impl;

import com.fantasy.xxbase.dao.BaseDao;
import com.fantasy.xxbase.service.impl.BaseServiceImpl;
import com.fantasy.xxblog.entity.BlogResourceEntity;
import com.fantasy.xxblog.service.BlogResourceService;
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
public class BlogResourceServiceImpl extends BaseServiceImpl<BlogResourceEntity> implements BlogResourceService {

    @Autowired
    public void setBaseDao(BaseDao<BlogResourceEntity> baseDao) {
        super.setBaseDao(baseDao);
    }
}
