package com.github.greengerong.log4js.controller;


import com.github.greengerong.log4js.factory.LogService;
import com.github.greengerong.log4js.model.LogInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class LogController {

    private final LogService logService;

    @Autowired
    public LogController(LogService logService) {

        this.logService = logService;
    }

    public LogController() {

        this(new LogService());
    }


    @RequestMapping(value = "log4js", method = POST, produces = "application/json")
    @ResponseBody
    public void log(@RequestBody LogInfo logInfo) {
        logService.log(logInfo);
    }
}
