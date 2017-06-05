package com.fantasy.xxbase.entity;

import com.fantasy.xxbase.usertype.JSONColumn;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 17/02/17.
 */
@MappedSuperclass
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@TypeDefs(value = {
        @TypeDef(name = "StringList", typeClass = JSONColumn.class, parameters = {@org.hibernate.annotations.Parameter(name = "StringList", value = "true")})
})
public class XXAccountEntity extends XXSimpleEntity {

    /**
     * 邮箱
     */
    @Column(length = 64)
    private String email;

    /**
     * 密码，需要加班
     */
    @Column(length = 64, nullable = false)
    private String password;

    /**
     * 盐
     */
    @Column(length = 64, nullable = false)
    private String salt = "XX-FANTASY";

    /**
     * 帐号是否锁定
     * 锁定状态不允许登录
     */
    @ColumnDefault(value = "false")
    @Column(name = "is_locked", nullable = false)
    private boolean locked = false;

    /**
     * 账户是否可用
     * 不可用状态不允许登录
     */
    @Column(name = "is_enable")
    @ColumnDefault(value = "true")
    private boolean enable = true;

    /**
     * 登录成功次数
     */
    @ColumnDefault(value = "0")
    private long loginSucceedCount = 0L;

    /**
     * 登录失败次数
     */
    @ColumnDefault(value = "0")
    private long loginFailedCount = 0L;

    @Lob
    @Type(type = "StringList")
    @Column(name = "role_ids")
    private List<String> roleIds = new ArrayList<>();


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public long getLoginSucceedCount() {
        return loginSucceedCount;
    }

    public void setLoginSucceedCount(long loginSucceedCount) {
        this.loginSucceedCount = loginSucceedCount;
    }

    public long getLoginFailedCount() {
        return loginFailedCount;
    }

    public void setLoginFailedCount(long loginFailedCount) {
        this.loginFailedCount = loginFailedCount;
    }

    public List<String> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(List<String> roleIds) {
        this.roleIds = roleIds;
    }
}
