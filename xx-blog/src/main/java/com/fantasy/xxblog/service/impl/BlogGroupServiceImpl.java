package com.fantasy.xxblog.service.impl;

import com.fantasy.xxbase.dao.BaseDao;
import com.fantasy.xxbase.service.impl.BaseServiceImpl;
import com.fantasy.xxblog.entity.BlogGroupEntity;
import com.fantasy.xxblog.service.BlogGroupService;
import com.fantasy.xxcore.datasource.XXDynamicDataSource;
import com.fantasy.xxcore.datasource.XXDynamicDataSourceHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author li.fang
 * @since 2017/6/5
 */
@Service
@XXDynamicDataSource(XXDynamicDataSourceHolder.DATASOURCE_BLOG)
public class BlogGroupServiceImpl  extends BaseServiceImpl<BlogGroupEntity> implements BlogGroupService {

    @Autowired
    public void setBaseDao(BaseDao<BlogGroupEntity> baseDao) {
        super.setBaseDao(baseDao);
    }

}
