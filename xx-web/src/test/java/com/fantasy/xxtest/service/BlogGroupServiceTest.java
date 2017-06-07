package com.fantasy.xxtest.service;

import com.fantasy.xxblog.entity.BlogGroupEntity;
import com.fantasy.xxblog.service.BlogGroupService;
import com.fantasy.xxtest.base.SpringTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author li.fang
 * @since 2017/6/5
 */
public class BlogGroupServiceTest extends SpringTest{

    @Autowired
    private BlogGroupService blogGroupService;

    @Test
    public void persist(){
        blogGroupService.clean();
        blogGroupService.persist(getBlogGroupList());
    }

    private List<BlogGroupEntity> getBlogGroupList(){
        List<BlogGroupEntity> blogGroupEntities = new ArrayList<>();

        //1
        BlogGroupEntity blogGroupEntity1 = new BlogGroupEntity();
        blogGroupEntity1.setName("Java");
        blogGroupEntities.add(blogGroupEntity1);

        //2
        BlogGroupEntity blogGroupEntity2 = new BlogGroupEntity();
        blogGroupEntity2.setName("Java设计模式");
        blogGroupEntities.add(blogGroupEntity2);


        //3
        BlogGroupEntity blogGroupEntity3 = new BlogGroupEntity();
        blogGroupEntity3.setName("Nginx");
        blogGroupEntities.add(blogGroupEntity3);

        //3
        BlogGroupEntity blogGroupEntity4 = new BlogGroupEntity();
        blogGroupEntity4.setName("MySQL");
        blogGroupEntities.add(blogGroupEntity4);

        return blogGroupEntities;
    }

}
