package com.fantasy.xxtest.sharding.dao.impl;

import com.fantasy.xxbase.dao.BaseDaoImpl;
import com.fantasy.xxtest.sharding.dao.OrderItemDao;
import com.fantasy.xxtest.sharding.entity.OrderItemEntity;
import org.springframework.stereotype.Repository;

@Repository
public class OrderItemDaoImpl extends BaseDaoImpl<OrderItemEntity> implements OrderItemDao {
}
