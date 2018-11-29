package com.fantasy.xxtest.util;

import com.fantasy.xxtest.base.BaseTest;
import com.fantasy.xxutil.util.XXStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author li.fang
 * @since 2017/10/19 13:49
 */
public class XXStringUtilsTest extends BaseTest{

    @Test
    public void testToUpperCase(){

        Assert.assertEquals("", XXStringUtils.getUpperCase("abc"));
        Assert.assertEquals("B", XXStringUtils.getUpperCase("aBc"));
        Assert.assertEquals("ABC", XXStringUtils.getUpperCase("ABC"));
        Assert.assertEquals("AC", XXStringUtils.getUpperCase("AbC"));

    }

    @Test
    public void testLong(){
        Long sum = 0L;
        for(int i = 0; i < Integer.MAX_VALUE; i++){
            sum += i;
        }
    }

}
