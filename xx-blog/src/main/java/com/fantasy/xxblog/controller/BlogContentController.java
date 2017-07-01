package com.fantasy.xxblog.controller;

import com.fantasy.xxbase.controller.BaseController;
import com.fantasy.xxbase.method.XXResponseBody;
import com.fantasy.xxbase.vo.Page;
import com.fantasy.xxblog.entity.BlogContentEntity;
import com.fantasy.xxblog.service.BlogContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author li.fang
 * @since 2017/6/29
 */
@RestController
@RequestMapping(value = "/xxblog/content", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class BlogContentController extends BaseController {

    @Autowired
    private BlogContentService blogContentService;

    @RequestMapping(value = "/list")
    public XXResponseBody<List<BlogContentEntity>> list(){
        Page<BlogContentEntity> page = blogContentService.page(1, 20);
        return new XXResponseBody<>(page.getContext());
    }

    @RequestMapping(value = "/markdown")
    public XXResponseBody<BlogContentEntity> markdown(@RequestParam String id){
        BlogContentEntity blogContentEntity = blogContentService.findById(id);
        return new XXResponseBody<>(blogContentEntity);
    }
}
