package com.fantasy.xxtest.sharding;

import com.fantasy.xxtest.base.SpringTest;
import com.fantasy.xxtest.sharding.entity.OrderEntity;
import com.fantasy.xxtest.sharding.entity.OrderItemEntity;
import com.fantasy.xxtest.sharding.service.OrderItemService;
import com.fantasy.xxtest.sharding.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

public class ShardingServiceTest extends SpringTest {

    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderItemService orderItemService;

    @Test
    public void testSharding1(){
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setName("订单A");
        orderEntity.setSort(1);
        orderService.persist(orderEntity);

        OrderItemEntity orderItemEntity = new OrderItemEntity();
        orderItemEntity.setName("手表");
        orderItemEntity.setOrder(orderEntity);
        orderItemService.persist(orderItemEntity);
    }

    @Test
    public void testSharding2(){

        orderItemService.findByName("手表");

    }

}
