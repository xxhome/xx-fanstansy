package com.fantasy.xxblog.service.impl;

import com.fantasy.xxbase.cache.XXCacheable;
import com.fantasy.xxbase.dao.BaseDao;
import com.fantasy.xxbase.service.impl.BaseServiceImpl;
import com.fantasy.xxbase.vo.Page;
import com.fantasy.xxblog.entity.BlogMenuEntity;
import com.fantasy.xxblog.service.BlogMenuService;
import com.fantasy.xxcore.datasource.XXDynamicDataSource;
import com.fantasy.xxcore.datasource.XXDynamicDataSourceHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author li.fang
 * @since 2017/6/29
 */
@Service
@XXDynamicDataSource(XXDynamicDataSourceHolder.DATASOURCE_BLOG)
public class BlogMenuServiceImpl extends BaseServiceImpl<BlogMenuEntity> implements BlogMenuService{

    @Autowired
    public void setBaseDao(BaseDao<BlogMenuEntity> baseDao) {
        super.setBaseDao(baseDao);
    }

    @Override
    @XXCacheable(key = "BlogMenuEntities")
    public Page<BlogMenuEntity> findAll() {
        return super.findAll();
    }
}
