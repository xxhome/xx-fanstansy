package com.fantasy.xxbase.entity;

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

    @Override
    public String toString() {
        return "XXSimpleEntity{" +
                "id='" + super.getId() + '\'' +
                "name='" + name + '\'' +
                '}';
    }
}
