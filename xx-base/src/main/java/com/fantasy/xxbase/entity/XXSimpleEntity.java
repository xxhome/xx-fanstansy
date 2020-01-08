package com.fantasy.xxbase.entity;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

/**
 * @author li.fang
 * @sine 2017/02/17.
 */
@MappedSuperclass
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class XXSimpleEntity extends XXBaseEntity {

    @Column(length = 64, nullable = false)
    private String name;

    @ColumnDefault(value = "0")
    private int sort;

    @Lob
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        return "XXSimpleEntity{" +
                "id='" + super.getId() + '\'' +
                ", name='" + name + '\'' +
                ", sort=" + sort +
                '}';
    }
}
