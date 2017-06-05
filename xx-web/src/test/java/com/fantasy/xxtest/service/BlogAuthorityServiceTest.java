package com.fantasy.xxtest.service;

import com.fantasy.xxbase.entity.XXPermissionActionEnum;
import com.fantasy.xxblog.entity.BlogAuthorityEntity;
import com.fantasy.xxblog.service.BlogAuthorityService;
import com.fantasy.xxtest.base.SpringTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author li.fang
 * @since 2017/6/3
 */
public class BlogAuthorityServiceTest extends SpringTest{

    @Autowired
    private BlogAuthorityService blogAuthorityService;

    @Test
    public void persist(){
        blogAuthorityService.clean();
        blogAuthorityService.persist(getBlogPermissionList());
    }

    private List<BlogAuthorityEntity> getBlogPermissionList(){
        List<BlogAuthorityEntity> blogPermissionEntities = new ArrayList<>();

        BlogAuthorityEntity blogAuthorityEntity1 = new BlogAuthorityEntity();
        blogAuthorityEntity1.setAuthorities("BA500050", "ACCOUNT", XXPermissionActionEnum.CREATE);
        blogPermissionEntities.add(blogAuthorityEntity1);

        return blogPermissionEntities;
    }

}
