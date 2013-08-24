package com.github.greengerong.log4js.service;

import com.github.greengerong.log4js.model.LogInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Slf4jService implements Log4jsService {

    private final Logger logger = LoggerFactory.getLogger(Log4jsService.class);

    @Override
    public void info(LogInfo logInfo) {
        logger.info(getMessage(logInfo));
    }


    @Override
    public void debug(LogInfo logInfo) {
        logger.debug(getMessage(logInfo));

    }

    @Override
    public void warn(LogInfo logInfo) {
        logger.warn(getMessage(logInfo));

    }

    @Override
    public void error(LogInfo logInfo) {
        logger.error(getMessage(logInfo));

    }

    private String getMessage(LogInfo logInfo) {
        return String.format("%s: message = %s, data = %s;",
                logInfo.getLevel().name(), logInfo.getMsg(), logInfo.getData());
    }

}
