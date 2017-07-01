package com.fantasy.xxtest.service;

import com.fantasy.xxblog.entity.BlogMenuEntity;
import com.fantasy.xxblog.service.BlogMenuService;
import com.fantasy.xxtest.base.SpringTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author li.fang
 * @since 2017/6/29
 */
public class BlogMenuServiceTest extends SpringTest{

    @Autowired
    private BlogMenuService blogMenuService;

    @Test
    public void persist(){
        List<BlogMenuEntity> menuEntities = getBlogMenuList();
        blogMenuService.clean();
        blogMenuService.persist(menuEntities);
    }

    private List<BlogMenuEntity> getBlogMenuList(){
        List<BlogMenuEntity> menuEntities = new ArrayList<>();

        BlogMenuEntity menuEntity1 = new BlogMenuEntity();
        menuEntity1.setName("首页");
        menuEntity1.setUrl("/xxblog/view/index.xhtml");
        menuEntity1.setMark("index");
        menuEntity1.setGlyphicon("glyphicon glyphicon-home");
        menuEntity1.setSort(1);

        BlogMenuEntity menuEntity2 = new BlogMenuEntity();
        menuEntity2.setName("博客");
        menuEntity2.setUrl("/xxblog/view/blog.xhtml");
        menuEntity2.setMark("blog");
        menuEntity2.setGlyphicon("glyphicon glyphicon-book");
        menuEntity2.setSort(2);

        BlogMenuEntity menuEntity3 = new BlogMenuEntity();
        menuEntity3.setName("相册");
        menuEntity3.setUrl("/xxblog/view/photos.xhtml");
        menuEntity3.setMark("photos");
        menuEntity3.setGlyphicon("glyphicon glyphicon-picture");
        menuEntity3.setSort(3);

        BlogMenuEntity menuEntity4 = new BlogMenuEntity();
        menuEntity4.setName("设置");
        menuEntity4.setUrl("/xxblog/view/setting.xhtml");
        menuEntity4.setMark("setting");
        menuEntity4.setGlyphicon("glyphicon glyphicon-cog");
        menuEntity4.setSort(4);

        BlogMenuEntity menuEntity5 = new BlogMenuEntity();
        menuEntity5.setName("关于");
        menuEntity5.setUrl("/xxblog/view/about.xhtml");
        menuEntity5.setMark("about");
        menuEntity5.setGlyphicon("glyphicon glyphicon-envelope");
        menuEntity5.setSort(5);

        BlogMenuEntity menuEntity6 = new BlogMenuEntity();
        menuEntity6.setName("写博客");
        menuEntity6.setUrl("/xxblog/view/write.xhtml");
        menuEntity6.setMark("write");
        menuEntity6.setGlyphicon("glyphicon glyphicon-envelope");
        menuEntity6.setSort(6);

        menuEntities.add(menuEntity1);
        menuEntities.add(menuEntity2);
        menuEntities.add(menuEntity3);
        menuEntities.add(menuEntity4);
        menuEntities.add(menuEntity5);
        menuEntities.add(menuEntity6);
        return menuEntities;
    }

}
