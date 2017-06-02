package com.fantasy.xxbase.entity;

import javax.persistence.*;

/**
 * @author li.fang
 * @since 2017/6/2
 */
@MappedSuperclass
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class XXResourceEntity extends XXSimpleEntity{

    @Column(length = 64)
    private String mark;

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }
}
