package com.fantasy.xxtest.util;

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
public class XXClassUtilsTest {

    @Test
    public void testGetClassDeclaredFields(){
        List<Field> fieldList = XXClassUtils.getClassDeclaredFields(AccountEntity.class);

        Assert.assertTrue(CollectionUtils.isEmpty(fieldList));
    }

}
