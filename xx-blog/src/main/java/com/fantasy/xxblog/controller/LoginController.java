package com.fantasy.xxblog.controller;

import com.fantasy.xxbase.controller.BaseController;
import com.fantasy.xxbase.method.XXResponseBody;
import com.fantasy.xxblog.controller.vo.LoginVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author li.fang
 *
 * @sine 17/02/28
 */
@Controller
@RequestMapping(value = "/xxblog/login", produces = "application/json; charset=UTF-8")
public class LoginController extends BaseController {


    @ResponseBody
    public XXResponseBody login(@RequestBody LoginVO loginVO){
        return new XXResponseBody();
    }


}
