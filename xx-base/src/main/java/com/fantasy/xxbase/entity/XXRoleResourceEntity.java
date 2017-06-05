package com.fantasy.xxbase.entity;

import javax.persistence.*;

/**
 * @author li.fang
 * @since 2017/6/2
 */
@MappedSuperclass
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class XXRoleResourceEntity extends XXBaseEntity{

    @Column(length = 64, nullable = false)
    private String roleId;

    @Column(length = 64, nullable = false)
    private String resourceId;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }
}
