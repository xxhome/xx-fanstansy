package com.fantasy.xxblog.service;

import com.fantasy.xxbase.dao.BaseDao;
import com.fantasy.xxbase.service.BaseServiceImpl;
import com.fantasy.xxblog.entity.BlogEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author li.fang
 * @sine 17/03/13
 */
@Service
public class BlogServiceImpl extends BaseServiceImpl<BlogEntity, String> implements BlogService {

    @Autowired
    public void setBaseDao(BaseDao<BlogEntity, String> baseDao) {
        super.setBaseDao(baseDao);
    }
}
