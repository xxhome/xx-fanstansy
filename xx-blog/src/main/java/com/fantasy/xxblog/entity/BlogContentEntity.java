package com.fantasy.xxblog.entity;

import com.fantasy.xxbase.entity.XXSimpleEntity;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author li.fang
 * @sine 17/03/13
 */
@Entity
@Table(name = "t_blog_content")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class BlogContentEntity extends XXSimpleEntity {

    @Lob
    private String content;

    @OneToMany(mappedBy = "blogContentEntity", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<BlogTagEntity> tags = new ArrayList<>();

    public List<BlogTagEntity> getTags() {
        return tags;
    }

    public void setTags(List<BlogTagEntity> tags) {
        this.tags = tags;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
