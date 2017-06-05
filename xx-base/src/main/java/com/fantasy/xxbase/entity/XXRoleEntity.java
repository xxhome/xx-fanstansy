package com.fantasy.xxbase.entity;

import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

/**
 * @author li.fang
 * @since 2017/6/2
 */
@MappedSuperclass
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class XXRoleEntity extends XXSimpleEntity {

}
