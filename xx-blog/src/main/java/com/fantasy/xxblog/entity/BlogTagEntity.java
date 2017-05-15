package com.fantasy.xxblog.entity;

import com.fantasy.xxbase.entity.XXSimpleEntity;
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
    @JoinColumn(name = "blog_id")
    private BlogEntity blogEntity;

    public BlogEntity getBlogEntity() {
        return blogEntity;
    }

    public void setBlogEntity(BlogEntity blogEntity) {
        this.blogEntity = blogEntity;
    }
}
