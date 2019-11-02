package com.fantasy.xxtest.sharding.service.impl;

import com.fantasy.xxbase.dao.BaseDao;
import com.fantasy.xxbase.service.impl.BaseServiceImpl;
import com.fantasy.xxtest.sharding.entity.OrderEntity;
import com.fantasy.xxtest.sharding.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl extends BaseServiceImpl<OrderEntity> implements OrderService {

    @Autowired
    public void setBaseDao(BaseDao<OrderEntity> baseDao) {
        super.setBaseDao(baseDao);
    }
}
