package com.fantasy.xxtest.util;

import com.fantasy.xxblog.entity.BlogContentEntity;
import com.fantasy.xxblog.entity.BlogMenuEntity;
import com.fantasy.xxblog.entity.BlogTagEntity;
import com.fantasy.xxtest.base.BaseTest;
import com.fantasy.xxutil.util.XXJsonUtils;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author li.fang
 * @since 2017/7/1
 */
public class XXJsonUtilsTest extends BaseTest{

    @Test
    public void testToJsonStr(){
        BlogMenuEntity menuEntity1 = new BlogMenuEntity();
        menuEntity1.setName("首页");
        menuEntity1.setUrl("/xxblog/view/index.xhtml");
        menuEntity1.setMark("index");
        menuEntity1.setGlyphicon("glyphicon glyphicon-home");
        menuEntity1.setSort(1);

        String jsonStr = XXJsonUtils.toJsonStr(menuEntity1);

        logger.debug("json str : {}", jsonStr);


        BlogContentEntity blogContentEntity1 = new BlogContentEntity();
        List<BlogTagEntity> blogTagEntities1 = getBlogTagEntityList();
        blogTagEntities1.forEach(tag -> tag.setBlogContentEntity(blogContentEntity1));
        blogContentEntity1.setTags(blogTagEntities1);
        blogContentEntity1.setName("Android基于UPnP/DLNA的智能设备媒体互联");
        blogContentEntity1.setDescription("工欲善其事，必先利其器。一个好的工具，能够节省大量的时间，提高整体工作效率。本文主要依据一线工程师的日常工作，从使用最频繁的日志着手，介绍了如何在保障...");

        jsonStr = XXJsonUtils.toJsonStr(blogContentEntity1);
        logger.debug("json str : {}", jsonStr);

        jsonStr = XXJsonUtils.toJsonStr(getBlogTagEntityList());
        logger.debug("json str : {}", jsonStr);

        List<BlogTagEntity> blogTagEntities = XXJsonUtils.parseArray(jsonStr, BlogTagEntity.class);

        logger.debug("blogTagEntities : {}", blogTagEntities);
    }

    @Test
    public void test(){
        String jsonStr = "{\"id\":null,\"createdTime\":1498840277890,\"modifyTime\":1498840277891,\"name\":\"首页\",\"sort\":1,\"description\":null,\"enable\":true,\"mark\":\"index\",\"url\":\"/xxblog/view/index.xhtml\",\"glyphicon\":\"glyphicon glyphicon-home\"}";

        BlogMenuEntity blogMenuEntity = XXJsonUtils.parseObject(jsonStr, BlogMenuEntity.class);

        logger.debug("blogMenuEntity : {}", blogMenuEntity);
    }


    private List<BlogTagEntity> getBlogTagEntityList() {
        List<BlogTagEntity> blogTagEntities = new ArrayList<>();
        BlogTagEntity blogTagEntity1 = new BlogTagEntity();
        blogTagEntity1.setName("Java");

        BlogTagEntity blogTagEntity2 = new BlogTagEntity();
        blogTagEntity2.setName("Android");

        blogTagEntities.add(blogTagEntity1);
        blogTagEntities.add(blogTagEntity2);

        return blogTagEntities;
    }
}
