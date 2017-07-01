package com.fantasy.xxblog.service.impl;

import com.fantasy.xxbase.dao.BaseDao;
import com.fantasy.xxbase.service.BaseServiceImpl;
import com.fantasy.xxblog.entity.BlogContentEntity;
import com.fantasy.xxblog.service.BlogContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author li.fang
 * @sine 17/03/13
 */
@Service
public class BlogContentContentServiceImpl extends BaseServiceImpl<BlogContentEntity> implements BlogContentService {

    @Autowired
    public void setBaseDao(BaseDao<BlogContentEntity> baseDao) {
        super.setBaseDao(baseDao);
    }
}
