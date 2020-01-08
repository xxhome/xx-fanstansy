package com.fantasy.xxtest.sharding.dao.impl;

import com.fantasy.xxbase.dao.BaseDaoImpl;
import com.fantasy.xxtest.sharding.dao.OrderDao;
import com.fantasy.xxtest.sharding.entity.OrderEntity;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDaoImpl extends BaseDaoImpl<OrderEntity> implements OrderDao {
}
