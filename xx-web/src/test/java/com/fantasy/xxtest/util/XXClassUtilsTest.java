package com.fantasy.xxtest.util;

import com.fantasy.xxblog.entity.BlogEntity;
import com.fantasy.xxblog.entity.BlogTagEntity;
import com.fantasy.xxtest.base.BaseTest;
import com.fantasy.xxutil.util.XXClassUtils;
import com.fantasy.xxblog.entity.AccountEntity;
import org.springframework.util.CollectionUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
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
    public void testFilterFieldToNULL() throws IOException, ClassNotFoundException {
        Object obj = XXClassUtils.filterFieldToNULL(getBlogEntity(), "id");
        System.out.println(obj);
    }

    @Test
    public void testGetCollectionGenericType(){
        XXClassUtils.getCollectionGenericType(getBlogEntity().getTags());
    }

    private BlogEntity getBlogEntity(){
        BlogEntity blogEntity = new BlogEntity();
        blogEntity.setId("10000");

        List<BlogTagEntity> tags = new ArrayList<>();

        BlogTagEntity tag1 = new BlogTagEntity();
        tag1.setBlogEntity(blogEntity);
        tag1.setId("1");
        tag1.setName("Java");
        tags.add(tag1);

        BlogTagEntity tag2 = new BlogTagEntity();
        tag2.setBlogEntity(blogEntity);
        tag2.setId("2");
        tag2.setName("C++");
        tags.add(tag2);

        blogEntity.setTags(tags);
        return blogEntity;
    }
}
