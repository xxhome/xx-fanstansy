package com.xxblog.service;

import com.xxbase.dao.BaseDao;
import com.xxbase.service.BaseServiceImpl;
import com.xxblog.entity.AccountEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by admin on 17/02/17.
 */
@Service
public class AccountServiceImpl extends BaseServiceImpl<AccountEntity, Long> implements AccountService {


    @Autowired
    public void setBaseDao(BaseDao<AccountEntity, Long> baseDao) {
        super.setBaseDao(baseDao);
    }

}
