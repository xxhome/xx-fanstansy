package com.xxtest.service;

import com.xxblog.service.BlogService;
import com.xxtest.base.SpringTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

/**
 * @author li.fang
 * @sine 17/03/13
 */
public class BlogServiceTest extends SpringTest {

    @Autowired
    private BlogService blogService;

    @Test
    public void testFind(){

        blogService.findAll();
        blogService.findAll();

    }

}
