package com.fantasy.xxbase.controller;

import com.fantasy.xxbase.method.XXResponseBody;
import com.fantasy.xxbase.service.SchedulerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author li.fang
 * @since 17/03/22
 */
@RestController
@RequestMapping("/xxbase/scheduler")
public class SchedulerController {

    @Autowired
    private SchedulerService schedulerService;

    @RequestMapping("/update")
    public XXResponseBody update() {
        schedulerService.schedule("sysMemoryListenerTrigger", "DEFAULT", "0/20 * * ? * * *");
        return XXResponseBody.SUCCEED;
    }


}
