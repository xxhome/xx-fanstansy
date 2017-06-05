package com.fantasy.xxbase.method;

import java.io.Serializable;

/**
 * 身份信息
 * @author li.fang
 * @since 2017/6/3
 */
public class Principal implements Serializable{

    private String id;

    private String username;

    public Principal(String id, String username) {
        this.id = id;
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
