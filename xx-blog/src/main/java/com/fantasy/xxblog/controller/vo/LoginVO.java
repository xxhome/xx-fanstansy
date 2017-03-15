package com.fantasy.xxblog.controller.vo;

/**
 * @author li.fang
 * @sine 17/02/28
 */
public class LoginVO {

    private String password;

    private String username;

    private String captcha;

    private boolean isRememberMe = false;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

    public boolean isRememberMe() {
        return isRememberMe;
    }

    public void setRememberMe(boolean rememberMe) {
        isRememberMe = rememberMe;
    }
}
