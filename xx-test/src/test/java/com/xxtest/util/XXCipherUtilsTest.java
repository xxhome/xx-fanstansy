package com.xxtest.util;

import com.xxtest.base.BaseTest;
import com.xxutil.util.XXCipherUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author li.fang
 * @sine 17/02/28
 */
public class XXCipherUtilsTest extends BaseTest{

    @Test
    public void testGetTime64MD5(){

        String username = "root";
        String password = "123456";
        String url = "jdbc:mysql://localhost:3306/db_fanstasy?serverTimezone=UTC&characterEncoding=utf8&useUnicode=true&useSSL=false";

        String p1 = XXCipherUtils.getTime64MD5(username, "hello");
        String p2 = XXCipherUtils.getTime64MD5(password);
        String p3 = XXCipherUtils.getTime64MD5(url);

        String p11 = XXCipherUtils.getTime64MD5(username, "hello");
        String p22 = XXCipherUtils.getTime64MD5(password);
        String p33 = XXCipherUtils.getTime64MD5(url);

        Assert.assertTrue(XXCipherUtils.isMD5Equal(p1, p11));
        Assert.assertTrue(XXCipherUtils.isMD5Equal(p2, p22));
        Assert.assertTrue(XXCipherUtils.isMD5Equal(p3, p33));


        String s1 = XXCipherUtils.getDesEncryptText(username);

        Assert.assertEquals(XXCipherUtils.getDesDecryptText(s1), username);
    }

}
