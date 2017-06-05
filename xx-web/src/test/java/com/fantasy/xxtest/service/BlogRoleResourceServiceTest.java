package com.fantasy.xxtest.service;

import com.fantasy.xxblog.entity.BlogRoleResourceEntity;
import com.fantasy.xxblog.service.BlogRoleResourceService;
import com.fantasy.xxtest.base.SpringTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author li.fang
 * @since 2017/6/3
 */
public class BlogRoleResourceServiceTest extends SpringTest{

    @Autowired
    private BlogRoleResourceService blogRoleResourceService;

    @Test
    public void persist(){
        blogRoleResourceService.persist(getBlogRoleResourceList());
    }

    private List<BlogRoleResourceEntity> getBlogRoleResourceList(){
        List<BlogRoleResourceEntity> blogRoleResourceEntities = new ArrayList<>();

        //1
        BlogRoleResourceEntity blogRoleResourceEntity1 = new BlogRoleResourceEntity();
        blogRoleResourceEntity1.setRoleId("BR500050");
        blogRoleResourceEntity1.setResourceId("BR500000");
        blogRoleResourceEntities.add(blogRoleResourceEntity1);

        //2
        BlogRoleResourceEntity blogRoleResourceEntity2 = new BlogRoleResourceEntity();
        blogRoleResourceEntity2.setRoleId("BR500050");
        blogRoleResourceEntity2.setResourceId("BR500001");
        blogRoleResourceEntities.add(blogRoleResourceEntity2);

        return blogRoleResourceEntities;
    }

}
