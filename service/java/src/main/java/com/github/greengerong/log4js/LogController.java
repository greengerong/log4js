package com.github.greengerong.log4js;


public class LogController {

    private final LogService logService;

    public LogController(LogService logService) {

        this.logService = logService;
    }

    public void log(LogInfo logInfo) {
        logService.log(logInfo);
    }
}
