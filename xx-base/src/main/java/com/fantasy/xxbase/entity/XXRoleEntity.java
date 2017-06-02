package com.fantasy.xxbase.entity;

import com.fantasy.xxbase.usertype.JSONColumn;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author li.fang
 * @since 2017/6/2
 */
@MappedSuperclass
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@TypeDefs(value = {
        @TypeDef(name = "StrList", typeClass = JSONColumn.class, parameters = {@org.hibernate.annotations.Parameter(name = "StrList", value = "true")})
})
public class XXRoleEntity extends XXSimpleEntity {

    @Lob
    @Type(type = "StrList")
    @Column(name = "role_ids")
    private List<String> roleIds = new ArrayList<>();

    public List<String> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(List<String> roleIds) {
        this.roleIds = roleIds;
    }
}
