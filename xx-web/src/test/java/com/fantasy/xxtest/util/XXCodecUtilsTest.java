package com.fantasy.xxtest.util;

import com.fantasy.xxtest.base.BaseTest;
import com.fantasy.xxutil.util.XXCodecUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author li.fang
 * @sine 17/02/28
 */
public class XXCodecUtilsTest extends BaseTest {

    @Test
    public void testGetTime64MD5(){

        String username = "root";
        String password = "123456";
        String url = "jdbc:mysql://localhost:3306/db_fantasy?serverTimezone=UTC&characterEncoding=utf8&useUnicode=true&useSSL=false";

        String p1 = XXCodecUtils.getTime64MD5(username);
        String p2 = XXCodecUtils.getTime64MD5(password);
        String p3 = XXCodecUtils.getTime64MD5(url);

        String p11 = XXCodecUtils.getTime64MD5(username);
        String p22 = XXCodecUtils.getTime64MD5(password);
        String p33 = XXCodecUtils.getTime64MD5(url);

        Assert.assertTrue(XXCodecUtils.isMD5Equal(p1, p11));
        Assert.assertTrue(XXCodecUtils.isMD5Equal(p2, p22));
        Assert.assertTrue(XXCodecUtils.isMD5Equal(p3, p33));


        String usr1 = XXCodecUtils.getDesEncryptText(username);
        String psw1 = XXCodecUtils.getDesEncryptText(password);

        logger.debug("usr : {}", usr1);
        logger.debug("psw : {}", psw1);

        Assert.assertEquals(XXCodecUtils.getDesDecryptText(usr1), username);
    }

}
