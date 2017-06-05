package com.fantasy.xxblog.service;

import com.fantasy.xxbase.dao.BaseDao;
import com.fantasy.xxbase.service.BaseServiceImpl;
import com.fantasy.xxblog.entity.BlogAccountEntity;
import com.fantasy.xxblog.entity.BlogResourceEntity;
import com.fantasy.xxblog.entity.BlogRoleResourceEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author li.fang
 * @since 2017/6/3
 */
@Service
public class BlogRoleResourceServiceImpl extends BaseServiceImpl<BlogRoleResourceEntity> implements BlogRoleResourceService {

    @Autowired
    public void setBaseDao(BaseDao<BlogRoleResourceEntity> baseDao) {
        super.setBaseDao(baseDao);
    }
}
