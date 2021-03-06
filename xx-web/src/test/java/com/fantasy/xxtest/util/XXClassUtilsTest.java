package com.fantasy.xxtest.util;

import com.fantasy.xxblog.entity.BlogAccountEntity;
import com.fantasy.xxblog.entity.BlogContentEntity;
import com.fantasy.xxblog.entity.BlogTagEntity;
import com.fantasy.xxtest.base.BaseTest;
import com.fantasy.xxutil.util.XXClassUtils;
import org.springframework.util.CollectionUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @author li.fang
 * @sine 17/02/19
 */
public class XXClassUtilsTest extends BaseTest {

    @Test
    public void testGetClassDeclaredFields(){
        List<Field> fieldList = XXClassUtils.getClassDeclaredFields(BlogAccountEntity.class);

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

    private BlogContentEntity getBlogEntity(){
        BlogContentEntity blogContentEntity = new BlogContentEntity();
        blogContentEntity.setId("10000");

        List<BlogTagEntity> tags = new ArrayList<>();

        BlogTagEntity tag1 = new BlogTagEntity();
        tag1.setBlogContentEntity(blogContentEntity);
        tag1.setId("1");
        tag1.setName("Java");
        tags.add(tag1);

        BlogTagEntity tag2 = new BlogTagEntity();
        tag2.setBlogContentEntity(blogContentEntity);
        tag2.setId("2");
        tag2.setName("C++");
        tags.add(tag2);

        blogContentEntity.setTags(tags);
        return blogContentEntity;
    }
}
