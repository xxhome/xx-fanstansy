package com.fantasy.xxblog.entity;

import com.fantasy.xxbase.entity.XXSimpleEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

/**
 * @author li.fang
 * @sine 17/03/13
 */
@Entity
@Table(name = "t_blog_tag")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class BlogTagEntity extends XXSimpleEntity {

    @ManyToOne
    @JoinColumn(name = "blog_content_id")
    @JsonIgnore
    private BlogContentEntity blogContentEntity;

    public BlogContentEntity getBlogContentEntity() {
        return blogContentEntity;
    }

    public void setBlogContentEntity(BlogContentEntity blogContentEntity) {
        this.blogContentEntity = blogContentEntity;
    }
}
