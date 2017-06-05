package com.fantasy.xxtest.service;

import com.fantasy.xxblog.entity.BlogResourceEntity;
import com.fantasy.xxblog.service.BlogResourceService;
import com.fantasy.xxtest.base.SpringTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author li.fang
 * @since 2017/6/3
 */
public class BlogResourceServiceTest extends SpringTest{

    @Autowired
    private BlogResourceService blogResourceService;

    @Test
    public void persist(){
        blogResourceService.clean();
        blogResourceService.persist(getBlogResourceList());
    }


    private List<BlogResourceEntity> getBlogResourceList(){
        List<BlogResourceEntity> blogResourceEntities = new ArrayList<>();

        //1
        BlogResourceEntity blogResourceEntity1 = new BlogResourceEntity();
        blogResourceEntity1.setMark("ACCOUNT");
        blogResourceEntity1.setName("账号管理");
        blogResourceEntities.add(blogResourceEntity1);

        //2
        BlogResourceEntity blogResourceEntity2 = new BlogResourceEntity();
        blogResourceEntity2.setMark("BLOG");
        blogResourceEntity2.setName("博客管理");
        blogResourceEntities.add(blogResourceEntity2);

        return blogResourceEntities;
    }

}
