package com.fantasy.xxbase.entity;


import com.fantasy.xxbase.listener.BaseEntityListener;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by admin on 17/02/15.
 */
@MappedSuperclass
@EntityListeners(BaseEntityListener.class)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class XXBaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "TableStringGenerator")
    @GenericGenerator(name = "TableStringGenerator", strategy = "enhanced-table",
            parameters = {
                @org.hibernate.annotations.Parameter(name = "format", value = "%1$d"),
                @org.hibernate.annotations.Parameter(name = org.hibernate.id.enhanced.TableGenerator.CONFIG_PREFER_SEGMENT_PER_ENTITY, value = "true"),
                @org.hibernate.annotations.Parameter(name = org.hibernate.id.enhanced.TableGenerator.TABLE_PARAM, value = "t_generator"),
                @org.hibernate.annotations.Parameter(name = org.hibernate.id.enhanced.TableGenerator.SEGMENT_COLUMN_PARAM, value = "gen_name"),
                @org.hibernate.annotations.Parameter(name = org.hibernate.id.enhanced.TableGenerator.VALUE_COLUMN_PARAM, value = "gen_value"),
                @org.hibernate.annotations.Parameter(name = org.hibernate.id.enhanced.TableGenerator.INITIAL_PARAM, value = "500000"),
                @org.hibernate.annotations.Parameter(name = org.hibernate.id.enhanced.TableGenerator.INCREMENT_PARAM, value = "50"),
                @org.hibernate.annotations.Parameter(name = org.hibernate.id.enhanced.TableGenerator.OPT_PARAM, value = "pooled-lo")
    })
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

    public XXBaseEntity() {
        createdTime = new Date();
        modifyTime = new Date();
    }

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
