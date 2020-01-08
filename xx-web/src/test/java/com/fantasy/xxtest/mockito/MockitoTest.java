package com.fantasy.xxtest.mockito;

import com.fantasy.xxtest.base.BaseTest;
import org.mockito.Mockito;
import org.testng.annotations.Test;

import java.util.List;

/**
 * @author li.fang
 * @since 2017/7/15
 */
public class MockitoTest extends BaseTest{


    /**
     * 验证行为是否发生
     * 一旦mock对象创建，他会记录所有发生过的事件，通过verify可以验证之前发生的任何你感兴趣的事件。
     */
    @Test
    public void testMockito01(){
        List<String> list = Mockito.mock(List.class);

        list.add("one");
        list.clear();

        Mockito.verify(list).add("one");
        Mockito.verify(list).clear();
    }

    /**
     * 模拟期望的结果
     * 一旦mock之后，每次返回的值都是mock的期望值。
     */
    @Test
    public void testMockito02(){
        List<String> list = Mockito.mock(List.class);

        Mockito.when(list.get(0)).thenReturn("one");
        Mockito.doReturn("one").when(list).get(0);

        Mockito.when(list.get(1)).thenThrow(new RuntimeException());

        logger.debug("list.get(0) = {}", list.get(0));

        logger.debug("list.get(1) = {}", list.get(1));

        logger.debug("list.get(2) = {}", list.get(2));
    }

    @Test
    public void testMockito03(){
        List<String> list = Mockito.mock(List.class);

        Mockito.when(list.get(Mockito.anyInt())).thenReturn("hello world");

        logger.debug("result : {}", list.get(1));

        logger.debug("result : {}", list.get(1000));
    }

    @Test
    public void testMockito04(){
        List<String> list = Mockito.mock(List.class);

        list.add("one");
        list.add("one");
        list.add("one");

        Mockito.verify(list, Mockito.times(4)).add("one");
    }
}
