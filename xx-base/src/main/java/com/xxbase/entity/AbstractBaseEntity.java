package com.xxbase.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by admin on 17/02/15.
 */
@MappedSuperclass
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class AbstractBaseEntity implements Serializable{

    @Id
    @TableGenerator(name = "GEN_INDEX", table = "t_generator",
            pkColumnName = "gen_key", valueColumnName = "gen_value",
            pkColumnValue = "id", allocationSize = 2, initialValue = 1000)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "GEN_INDEX")
    @Column(length = 30, unique = true, nullable = false)
    private String id;

    /**
     * 创建时间，不更新
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false, nullable = false)
    private Date createdTime;

    /**
     * 修改时间
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false, nullable = false)
    private Date modifyTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}
