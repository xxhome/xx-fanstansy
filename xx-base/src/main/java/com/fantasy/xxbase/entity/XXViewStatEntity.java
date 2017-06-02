package com.fantasy.xxbase.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author li.fang
 * @sine 17/02/20
 */
@Entity
@Table(name = "t_xx_view_stat")
public class XXViewStatEntity extends XXBaseEntity {

    @Column(length = 64)
    private String ip;

    @Column(length = 120, nullable = false)
    private String url;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
