package com.fantasy.xxbase.controller;

import com.fantasy.xxbase.annotation.XXRequestMapping;
import com.fantasy.xxbase.annotation.XXRestController;
import com.fantasy.xxbase.method.XXResponseBody;

/**
 * @author li.fang
 * @since 2017/10/16 11:48
 */
@XXRestController(path = "/test1")
public class TestController {

    @XXRequestMapping("/test2")
    public XXResponseBody<String> test(){
        return XXResponseBody.FAILURE;
    }

}
