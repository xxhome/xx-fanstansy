package com.fantasy.xxtest.service;

import com.fantasy.xxbase.exception.EntityNoExistNameException;
import com.fantasy.xxbase.vo.Operator;
import com.fantasy.xxbase.vo.QueryParam;
import com.fantasy.xxblog.entity.BlogAccountEntity;
import com.fantasy.xxblog.service.BlogAccountService;
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
public class BlogAccountServiceTest extends SpringTest {

    @Autowired
    private BlogAccountService blogAccountService;

    @Test
    public void testFindAll(){
        blogAccountService.findAll();
    }

    @Test
    public void testPage(){
        blogAccountService.page(2, 10);
    }

    @Test
    public void testFindOneByName(){
        blogAccountService.findOneByName("lisi");
    }

    @Test
    public void testFind(){
        List<QueryParam> queryParamList = new ArrayList<>();

        queryParamList.add(new QueryParam("id", "1000", Operator.EQ));
        queryParamList.add(new QueryParam("name", "lisi", Operator.LIKE));

        blogAccountService.find(queryParamList);
        blogAccountService.find(queryParamList);
    }

    @Test
    public void persist() throws EntityNoExistNameException {
        blogAccountService.clean();
        BlogAccountEntity blogAccountEntity = new BlogAccountEntity();
        blogAccountEntity.setName("cook");
        blogAccountEntity.setEmail("cook@gmail.com");
        blogAccountEntity.setPassword(XXCipherUtils.getDesEncryptText("111111"));
        blogAccountEntity.getRoleIds().add("BR500000");
        blogAccountEntity.getRoleIds().add("BR500001");
        blogAccountService.persist(blogAccountEntity);
    }
}
