package com.fantasy.xxtest.service;

import com.fantasy.xxblog.entity.BlogRoleEntity;
import com.fantasy.xxblog.service.BlogRoleService;
import com.fantasy.xxtest.base.SpringTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author li.fang
 * @since 2017/6/3
 */
public class BlogRoleServiceTest extends SpringTest{

    @Autowired
    private BlogRoleService blogRoleService;

    @Test
    public void persist(){
        blogRoleService.persist(getBlogRoleList());
    }

    @Test
    public void clean(){
        blogRoleService.clean();
    }


    private List<BlogRoleEntity> getBlogRoleList(){
        List<BlogRoleEntity> blogRoleEntities = new ArrayList<>();

        //1
        BlogRoleEntity blogRoleEntity1 = new BlogRoleEntity();
        blogRoleEntity1.setName("超级管理员角色");
        blogRoleEntity1.setDescription("超级管理员角色");
        blogRoleEntities.add(blogRoleEntity1);

        //2
        BlogRoleEntity blogRoleEntity2 = new BlogRoleEntity();
        blogRoleEntity2.setName("普通用户角色");
        blogRoleEntity2.setDescription("普通用户角色");
        blogRoleEntities.add(blogRoleEntity2);

        return blogRoleEntities;
    }

}
