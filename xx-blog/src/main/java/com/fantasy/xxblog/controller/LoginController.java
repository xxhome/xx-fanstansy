package com.fantasy.xxblog.controller;

import com.fantasy.xxbase.controller.BaseController;
import com.fantasy.xxbase.method.XXResponseBody;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author li.fang
 * @sine 17/02/28
 */
@RestController
@RequestMapping(value = "/xxblog/login", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class LoginController extends BaseController {

    @RequestMapping(value = "/submit")
    public XXResponseBody submit() {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("cook", "111111");
        subject.login(token);
        return new XXResponseBody();
    }

}
