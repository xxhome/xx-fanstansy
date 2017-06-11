package com.fantasy.xxblog.controller;

import com.fantasy.xxbase.controller.BaseController;
import com.fantasy.xxbase.vo.Page;
import com.fantasy.xxbase.method.XXResponseBody;
import com.fantasy.xxblog.entity.BlogGroupEntity;
import com.fantasy.xxblog.service.BlogGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @author li.fang
 * @since 2017/6/5
 */
@RestController
@RequestMapping(value = "/xxblog/group", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class BlogGroupController extends BaseController{

    @Autowired
    private BlogGroupService blogGroupService;

    @RequestMapping(value = "/list")
    public XXResponseBody<List<BlogGroupEntity>> list(){
        Page<BlogGroupEntity> page = blogGroupService.findAll();

        XXResponseBody responseBody = new XXResponseBody<>(page.getContext());
        return responseBody;
    }

}
