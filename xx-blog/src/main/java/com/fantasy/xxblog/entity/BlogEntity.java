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
@Table(name = "t_blog")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class BlogEntity extends XXSimpleEntity {

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name="blog_tag_id")
    private List<BlogTagEntity> tags = new ArrayList<>();

    public List<BlogTagEntity> getTags() {
        return tags;
    }

    public void setTags(List<BlogTagEntity> tags) {
        this.tags = tags;
    }
}
