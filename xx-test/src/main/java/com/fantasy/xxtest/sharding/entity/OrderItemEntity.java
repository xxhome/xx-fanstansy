package com.fantasy.xxtest.sharding.entity;

import com.fantasy.xxbase.entity.XXSimpleEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_order_item")
public class OrderItemEntity extends XXSimpleEntity {

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderEntity order;

    public OrderEntity getOrder() {
        return order;
    }

    public void setOrder(OrderEntity order) {
        this.order = order;
    }
}
