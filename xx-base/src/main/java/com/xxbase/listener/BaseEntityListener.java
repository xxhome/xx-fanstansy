package com.xxbase.listener;

import com.xxbase.entity.AbstractBaseEntity;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.Date;

/**
 * @author li.fang
 * @sine 17/02/28
 */
public class BaseEntityListener {

    /**
     * Entity持久化之前,自动创建时间
     *
     * @param baseEntity
     */
    @PrePersist
    public void prePersist(AbstractBaseEntity baseEntity) {
        baseEntity.setCreatedTime(new Date());
        baseEntity.setModifyTime(new Date());
    }

    /**
     * Entity更新时,自动修改更新时间
     *
     * @param baseEntity
     */
    @PreUpdate
    public void preUpdate(AbstractBaseEntity baseEntity) {
        baseEntity.setModifyTime(new Date());
    }

}
