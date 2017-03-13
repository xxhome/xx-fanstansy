package com.xxblog.entity;

import com.xxbase.entity.AbstractSimpleEntity;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author li.fang
 * @sine 17/03/13
 */
@Entity
@Table(name = "t_tag")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class TagEntity extends AbstractSimpleEntity{
}
