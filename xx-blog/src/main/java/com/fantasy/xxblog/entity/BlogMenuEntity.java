package com.fantasy.xxblog.entity;

import com.fantasy.xxbase.entity.XXSimpleEntity;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author li.fang
 * @since 2017/6/29
 */
@Entity
@Table(name = "t_blog_menu")
public class BlogMenuEntity extends XXSimpleEntity{

    @ColumnDefault(value = "true")
    private boolean enable = true;

    @Column(length = 64, unique = true, nullable = false)
    private String mark;

    @Column(length = 200)
    private String url;

    @Column(length = 64)
    private String glyphicon;

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getGlyphicon() {
        return glyphicon;
    }

    public void setGlyphicon(String glyphicon) {
        this.glyphicon = glyphicon;
    }
}
