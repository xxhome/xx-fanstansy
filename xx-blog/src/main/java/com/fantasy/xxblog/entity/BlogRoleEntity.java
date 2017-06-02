package com.fantasy.xxblog.entity;

import com.fantasy.xxbase.entity.XXAccountEntity;
import com.fantasy.xxbase.entity.XXRoleEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

/**
 * @author li.fang
 * @since 2017/6/2
 */
@Entity
@Table(name = "t_blog_role")
public class BlogRoleEntity extends XXRoleEntity{

    @OneToMany
    @JoinColumn(name = "account_id")
    private List<BlogAccountEntity> accountList = new ArrayList<>();

    public List<BlogAccountEntity> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<BlogAccountEntity> accountList) {
        this.accountList = accountList;
    }
}
