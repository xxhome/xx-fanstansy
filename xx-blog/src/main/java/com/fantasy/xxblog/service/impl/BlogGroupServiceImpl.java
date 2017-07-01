package com.fantasy.xxblog.service.impl;

import com.fantasy.xxbase.dao.BaseDao;
import com.fantasy.xxbase.service.BaseServiceImpl;
import com.fantasy.xxblog.entity.BlogGroupEntity;
import com.fantasy.xxblog.service.BlogGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author li.fang
 * @since 2017/6/5
 */
@Service
public class BlogGroupServiceImpl  extends BaseServiceImpl<BlogGroupEntity> implements BlogGroupService {

    @Autowired
    public void setBaseDao(BaseDao<BlogGroupEntity> baseDao) {
        super.setBaseDao(baseDao);
    }

}
