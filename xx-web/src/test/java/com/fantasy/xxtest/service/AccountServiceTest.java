package com.fantasy.xxtest.service;

import com.fantasy.xxbase.exception.EntityNoExistNameException;
import com.fantasy.xxbase.method.Operator;
import com.fantasy.xxbase.method.QueryParam;
import com.fantasy.xxblog.entity.AccountEntity;
import com.fantasy.xxblog.service.AccountService;
import com.fantasy.xxtest.base.SpringTest;
import com.fantasy.xxutil.util.XXCipherUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

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

    @Test
    public void testFind(){
        List<QueryParam> queryParamList = new ArrayList<>();

        queryParamList.add(new QueryParam("id", "1000", Operator.EQ));
        queryParamList.add(new QueryParam("name", "lisi", Operator.LIKE));

        accountService.find(queryParamList);
        accountService.find(queryParamList);
    }

    @Test
    public void persist() throws EntityNoExistNameException {
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setName("cook");
        accountEntity.setEmail("cook@gmail.com");
        accountEntity.setPassword(XXCipherUtils.getDesEncryptText("111111"));
        accountService.persist(accountEntity);
    }
}
