package com.xxblog.service;

import com.xxbase.dao.BaseDao;
import com.xxbase.service.BaseServiceImpl;
import com.xxblog.entity.TagEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author li.fang
 * @sine 17/03/13
 */
@Service
public class TagServiceImpl extends BaseServiceImpl<TagEntity, Long> implements TagService {

    @Autowired
    public void setBaseDao(BaseDao<TagEntity, Long> baseDao) {
        super.setBaseDao(baseDao);
    }
}
