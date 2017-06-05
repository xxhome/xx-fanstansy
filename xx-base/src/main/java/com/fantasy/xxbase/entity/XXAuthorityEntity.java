package com.fantasy.xxbase.entity;

import com.alibaba.fastjson.annotation.JSONField;

import javax.persistence.Column;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

/**
 * @author li.fang
 * @since 2017/6/2
 */
@MappedSuperclass
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class XXAuthorityEntity extends XXBaseEntity {

    @Column(length = 64, nullable = false)
    private String accountId;

    /**
     * user:resource:action
     * user:role:resource:action
     */
    private String authorities;

    @JSONField(deserialize = false, serialize = false)
    public void setAuthorities(String accountId, String resource, XXPermissionActionEnum action) {
        String permission;
        switch (action) {
            case CREATE:
            case UPDATE:
            case DELETE:
                permission = String.format("%s:%s:%s,%s", accountId, resource, XXPermissionActionEnum.VIEW.name(), action.name());
                break;
            default:
                permission = String.format("%s:%s:%s", accountId, resource, action.name());
                break;
        }
        setAuthorities(permission);
        setAccountId(accountId);
    }


    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAuthorities() {
        return authorities;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }
}
