package com.xxbase.entity;

import javax.persistence.Column;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

/**
 * Created by admin on 17/02/17.
 */
@MappedSuperclass
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class AbstractAccountEntity extends AbstractSimpleEntity {

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
    @Column(name = "is_locked", nullable = false, columnDefinition = "boolean default false")
    private boolean locked = false;

    /**
     * 账户是否可用
     * 不可用状态不允许登录
     */
    @Column(name = "is_enable", nullable = true, columnDefinition = "boolean default false")
    private boolean enable = true;

    /**
     * 登录成功次数
     */
    private long loginSucceedCount = 0L;

    /**
     * 登录失败次数
     */
    private long loginFailedCount = 0L;

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
}
