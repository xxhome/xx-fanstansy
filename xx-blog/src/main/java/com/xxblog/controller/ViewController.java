package com.xxblog.controller;

import com.xxbase.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author li.fang
 * @sine 17/02/22
 */
@Controller
@RequestMapping(value = "/xxblog/view")
public class ViewController extends BaseController {

    private static final String VIEW_PATH_INDEX = "/xx-blog/%s";

    @RequestMapping(value = "/{name}")
    public ModelAndView view(@PathVariable String name) {
        return new ModelAndView(String.format(VIEW_PATH_INDEX, name));
    }

}
