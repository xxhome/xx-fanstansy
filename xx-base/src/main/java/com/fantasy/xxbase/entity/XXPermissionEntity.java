package com.fantasy.xxbase.entity;

import com.alibaba.fastjson.annotation.JSONField;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.*;
import java.util.List;

/**
 * @author li.fang
 * @since 2017/6/2
 */
@MappedSuperclass
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class XXPermissionEntity extends XXBaseEntity {

    @JSONField(deserialize = false, serialize = false)
    public void setPermission(String accountId, String resource, XXPermissionActionEnum action) {
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
        setPermission(permission);
    }

    @JSONField(deserialize = false, serialize = false)
    public void setPermission(String accountId, List<String> roleIds, String resource, XXPermissionActionEnum action) {
        String permission;
        switch (action) {
            case CREATE:
            case UPDATE:
            case DELETE:
                permission = String.format("%s:%s:%s:%s,%s", accountId, StringUtils.join(roleIds, ","), resource, XXPermissionActionEnum.VIEW.name(), action.name());
                break;
            default:
                permission = String.format("%s:%s:%s:%s", accountId, StringUtils.join(roleIds, ","), resource, XXPermissionActionEnum.VIEW.name());
                break;
        }
        setPermission(permission);
    }

    /**
     * user:resource:action
     * user:role:resource:action
     */
    private String permission;

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
}
