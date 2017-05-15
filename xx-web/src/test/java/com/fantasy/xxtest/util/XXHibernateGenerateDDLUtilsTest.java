package com.fantasy.xxtest.util;

import com.fantasy.xxtest.base.SpringTest;
import com.fantasy.xxutil.util.XXHibernateGenerateDDLUtils;
import org.hibernate.dialect.MySQL5Dialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import javax.sql.DataSource;

/**
 * @author li.fang
 * @since 2017/5/9
 */
public class XXHibernateGenerateDDLUtilsTest extends SpringTest {

    @Autowired
    private DataSource dataSource;

    @Test
    public void test(){
        XXHibernateGenerateDDLUtils.export(dataSource, MySQL5Dialect.class, "com.fantasy.xxblog");
    }

}
