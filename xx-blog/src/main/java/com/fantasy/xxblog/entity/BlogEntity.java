package com.fantasy.xxblog.entity;

import com.fantasy.xxbase.entity.AbstractSimpleEntity;
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
public class BlogEntity extends AbstractSimpleEntity{

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name="tag_id")
    private List<TagEntity> tags = new ArrayList<>();

    public List<TagEntity> getTags() {
        return tags;
    }

    public void setTags(List<TagEntity> tags) {
        this.tags = tags;
    }
}
