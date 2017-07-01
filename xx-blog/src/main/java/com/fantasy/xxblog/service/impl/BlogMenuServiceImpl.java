package com.fantasy.xxblog.service.impl;

import com.fantasy.xxbase.dao.BaseDao;
import com.fantasy.xxbase.service.BaseServiceImpl;
import com.fantasy.xxblog.entity.BlogMenuEntity;
import com.fantasy.xxblog.service.BlogMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author li.fang
 * @since 2017/6/29
 */
@Service
public class BlogMenuServiceImpl extends BaseServiceImpl<BlogMenuEntity> implements BlogMenuService{

    @Autowired
    public void setBaseDao(BaseDao<BlogMenuEntity> baseDao) {
        super.setBaseDao(baseDao);
    }
}
