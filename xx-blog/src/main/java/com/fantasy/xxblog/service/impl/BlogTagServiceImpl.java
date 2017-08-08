package com.fantasy.xxblog.service.impl;

import com.fantasy.xxbase.dao.BaseDao;
import com.fantasy.xxbase.service.impl.BaseServiceImpl;
import com.fantasy.xxblog.entity.BlogTagEntity;
import com.fantasy.xxblog.service.BlogTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author li.fang
 * @sine 17/03/13
 */
@Service
public class BlogTagServiceImpl extends BaseServiceImpl<BlogTagEntity> implements BlogTagService {

    @Autowired
    public void setBaseDao(BaseDao<BlogTagEntity> baseDao) {
        super.setBaseDao(baseDao);
    }
}
