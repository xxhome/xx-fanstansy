package com.fantasy.xxblog.service;

import com.fantasy.xxbase.dao.BaseDao;
import com.fantasy.xxbase.service.BaseServiceImpl;
import com.fantasy.xxblog.entity.BlogRoleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author li.fang
 * @since 2017/6/3
 */
@Service
public class BlogRoleServiceImpl  extends BaseServiceImpl<BlogRoleEntity> implements BlogRoleService {

    @Autowired
    public void setBaseDao(BaseDao<BlogRoleEntity> baseDao) {
        super.setBaseDao(baseDao);
    }

}
