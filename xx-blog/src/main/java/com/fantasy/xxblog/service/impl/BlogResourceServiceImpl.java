package com.fantasy.xxblog.service.impl;

import com.fantasy.xxbase.dao.BaseDao;
import com.fantasy.xxbase.service.BaseServiceImpl;
import com.fantasy.xxblog.entity.BlogResourceEntity;
import com.fantasy.xxblog.service.BlogResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author li.fang
 * @since 2017/6/3
 */
@Service
public class BlogResourceServiceImpl extends BaseServiceImpl<BlogResourceEntity> implements BlogResourceService {

    @Autowired
    public void setBaseDao(BaseDao<BlogResourceEntity> baseDao) {
        super.setBaseDao(baseDao);
    }
}
