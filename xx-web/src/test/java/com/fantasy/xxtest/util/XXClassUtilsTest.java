package com.fantasy.xxtest.util;

import com.fantasy.xxtest.base.BaseTest;
import com.fantasy.xxutil.util.XXClassUtils;
import com.fantasy.xxblog.entity.AccountEntity;
import org.springframework.util.CollectionUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Field;
import java.util.List;

/**
 * @author li.fang
 * @sine 17/02/19
 */
public class XXClassUtilsTest extends BaseTest {


    @Test
    public void testGetClassDeclaredFields(){
        List<Field> fieldList = XXClassUtils.getClassDeclaredFields(AccountEntity.class);

        Assert.assertTrue(CollectionUtils.isEmpty(fieldList));
    }

    @Test
    public void testStaticSingleton(){
        StaticSingleton s1 = StaticSingleton.getInstance();
        StaticSingleton s2 = StaticSingleton.getInstance();
        StaticSingleton s3 = StaticSingleton.getInstance();
        logger.debug("{}", s1 == s2);
        logger.debug("{}", s1 == s3);
        logger.debug("{}", s2 == s3);
    }
}
