package com.fantasy.xxblog.service;

import com.fantasy.xxbase.dao.BaseDao;
import com.fantasy.xxbase.service.BaseServiceImpl;
import com.fantasy.xxblog.entity.BlogTagEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author li.fang
 * @sine 17/03/13
 */
@Service
public class TagServiceImpl extends BaseServiceImpl<BlogTagEntity, Long> implements TagService {

    @Autowired
    public void setBaseDao(BaseDao<BlogTagEntity, Long> baseDao) {
        super.setBaseDao(baseDao);
    }
}
