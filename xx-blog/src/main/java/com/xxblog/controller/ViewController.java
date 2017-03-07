package com.xxblog.controller;

import com.xxutil.util.XXStringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author li.fang
 * @sine 17/03/07
 */
@Controller
@RequestMapping(value = "/xxblog/view")
public class ViewController {

    private static final String VIEW_BLOG_INDEX = "/xx-blog/%s";

    @RequestMapping("/{view}")
    public ModelAndView forward(@PathVariable String view){
        return new ModelAndView(String.format(VIEW_BLOG_INDEX, view));
    }

}
