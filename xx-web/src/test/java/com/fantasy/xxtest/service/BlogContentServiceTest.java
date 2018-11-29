package com.fantasy.xxtest.service;

import com.fantasy.xxblog.entity.BlogContentEntity;
import com.fantasy.xxblog.entity.BlogTagEntity;
import com.fantasy.xxblog.service.BlogContentService;
import com.fantasy.xxtest.base.SpringTest;
import com.fantasy.xxutil.util.XXClassUtils;
import com.fantasy.xxutil.util.XXCollectionUtils;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author li.fang
 * @sine 17/03/13
 */
public class BlogContentServiceTest extends SpringTest {

    @Autowired
    private BlogContentService blogContentService;
    @Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @Test
    public void testFind() {
        blogContentService.findAll();
        blogContentService.findAll();
    }

    @Test
    public void testBatchPersist(){
        blogContentService.clean();

        List<BlogContentEntity> blogContentEntities = new ArrayList<>(1000);

        for(int i = 1; i < 1000; i ++) {
            BlogContentEntity blogContentEntity1 = new BlogContentEntity();
            List<BlogTagEntity> blogTagEntities1 = getBlogTagEntityList();
            blogTagEntities1.forEach(tag -> tag.setBlogContentEntity(blogContentEntity1));
            blogContentEntity1.setTags(blogTagEntities1);

            blogContentEntity1.setName(i + ". Android基于UPnP/DLNA的智能设备媒体互联");
            blogContentEntity1.setDescription("工欲善其事，必先利其器。一个好的工具，能够节省大量的时间，提高整体工作效率。本文主要依据一线工程师的日常工作，从使用最频繁的日志着手，介绍了如何在保障...");

            blogContentEntities.add(blogContentEntity1);
        }

        List<List<BlogContentEntity>> page = XXCollectionUtils.toPage(blogContentEntities, 100);

        for(List<BlogContentEntity> list : page){

            blogContentService.persist(list);

        }
    }

    @Test
    public void testPersist() throws IOException, ClassNotFoundException {
//        blogContentService.clean();

        BlogContentEntity blogContentEntity1 = new BlogContentEntity();

        List<BlogTagEntity> blogTagEntities1 = getBlogTagEntityList();
        blogTagEntities1.forEach(tag -> tag.setBlogContentEntity(blogContentEntity1));
        blogContentEntity1.setTags(blogTagEntities1);

        blogContentEntity1.setName("Android基于UPnP/DLNA的智能设备媒体互联");
        blogContentEntity1.setDescription("工欲善其事，必先利其器。一个好的工具，能够节省大量的时间，提高整体工作效率。本文主要依据一线工程师的日常工作，从使用最频繁的日志着手，介绍了如何在保障...");
        blogContentService.persist(blogContentEntity1);

        //===================================
        BlogContentEntity blogContentEntity2 = new BlogContentEntity();

        List<BlogTagEntity> blogTagEntities2 = getBlogTagEntityList();
        blogTagEntities2.forEach(tag -> tag.setBlogContentEntity(blogContentEntity2));
        blogContentEntity2.setTags(blogTagEntities2);

        blogContentEntity2.setName("Android基于UPnP/DLNA的智能设备媒体互联");
        blogContentEntity2.setDescription("工欲善其事，必先利其器。一个好的工具，能够节省大量的时间，提高整体工作效率。本文主要依据一线工程师的日常工作，从使用最频繁的日志着手，介绍了如何在保障...");
        blogContentService.persist(blogContentEntity2);


        //===================================
        BlogContentEntity blogContentEntity3 = new BlogContentEntity();

        List<BlogTagEntity> blogTagEntities3 = getBlogTagEntityList();
        blogTagEntities3.forEach(tag -> tag.setBlogContentEntity(blogContentEntity3));
        blogContentEntity3.setTags(blogTagEntities3);

        blogContentEntity3.setName("Android基于UPnP/DLNA的智能设备媒体互联");
        blogContentEntity3.setDescription("工欲善其事，必先利其器。一个好的工具，能够节省大量的时间，提高整体工作效率。本文主要依据一线工程师的日常工作，从使用最频繁的日志着手，介绍了如何在保障...");
        blogContentService.persist(blogContentEntity3);

    }

    private List<BlogTagEntity> getBlogTagEntityList() {
        List<BlogTagEntity> blogTagEntities = new ArrayList<>();
        BlogTagEntity blogTagEntity1 = new BlogTagEntity();
        blogTagEntity1.setName("Java");

        BlogTagEntity blogTagEntity2 = new BlogTagEntity();
        blogTagEntity2.setName("Android");

        BlogTagEntity blogTagEntity3 = new BlogTagEntity();
        blogTagEntity3.setName("设计模式");

        blogTagEntities.add(blogTagEntity1);
        blogTagEntities.add(blogTagEntity2);
        blogTagEntities.add(blogTagEntity3);

        return blogTagEntities;
    }
}
