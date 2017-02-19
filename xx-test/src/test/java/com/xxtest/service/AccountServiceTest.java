package com.xxtest.service;

import com.xxblog.service.AccountService;
import com.xxtest.base.SpringTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

/**
 * @author li.fang
 * @sine 17/02/19
 */
public class AccountServiceTest extends SpringTest{

    @Autowired
    private AccountService accountService;

    @Test
    public void testFindAll(){
        accountService.findAll();
    }

    @Test
    public void testFindPages(){
        accountService.findPages(2, 10);
    }

    @Test
    public void testFindOneByName(){
        accountService.findOneByName("lisi");
    }

}
