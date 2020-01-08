package com.fantasy.xxtest.sharding.service.impl;

import com.fantasy.xxbase.dao.BaseDao;
import com.fantasy.xxbase.service.impl.BaseServiceImpl;
import com.fantasy.xxtest.sharding.entity.OrderItemEntity;
import com.fantasy.xxtest.sharding.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderItemServiceImpl extends BaseServiceImpl<OrderItemEntity> implements OrderItemService {

    @Autowired
    public void setBaseDao(BaseDao<OrderItemEntity> baseDao) {
        super.setBaseDao(baseDao);
    }
}
