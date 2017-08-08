package com.fantasy.xxtest.service;

import com.fantasy.xxbase.service.TestService01;
import com.fantasy.xxtest.base.SpringTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

public class TestServiceTest extends SpringTest{

    @Autowired
    private TestService01 testService01;


    @Test
    public void testSave() throws Exception {
        testService01.save01And02();
    }
}
