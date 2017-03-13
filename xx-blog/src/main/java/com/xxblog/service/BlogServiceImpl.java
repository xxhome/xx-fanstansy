package com.xxblog.service;

import com.xxbase.dao.BaseDao;
import com.xxbase.service.BaseServiceImpl;
import com.xxblog.entity.BlogEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author li.fang
 * @sine 17/03/13
 */
@Service
public class BlogServiceImpl extends BaseServiceImpl<BlogEntity, Long> implements BlogService {

    @Autowired
    public void setBaseDao(BaseDao<BlogEntity, Long> baseDao) {
        super.setBaseDao(baseDao);
    }
}
