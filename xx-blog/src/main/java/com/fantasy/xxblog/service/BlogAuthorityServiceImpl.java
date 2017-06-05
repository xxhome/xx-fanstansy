package com.fantasy.xxblog.service;

import com.fantasy.xxbase.dao.BaseDao;
import com.fantasy.xxbase.service.BaseServiceImpl;
import com.fantasy.xxblog.dao.BlogAuthorityDao;
import com.fantasy.xxblog.entity.BlogAuthorityEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author li.fang
 * @since 2017/6/3
 */
@Service
public class BlogAuthorityServiceImpl extends BaseServiceImpl<BlogAuthorityEntity> implements BlogAuthorityService {

    @Autowired
    private BlogAuthorityDao blogAuthorityDao;

    @Autowired
    public void setBaseDao(BaseDao<BlogAuthorityEntity> baseDao) {
        super.setBaseDao(baseDao);
    }

    @Override
    public List<BlogAuthorityEntity> findByAccountId(String accountId) {
        return blogAuthorityDao.findByAccountId(accountId);
    }
}
