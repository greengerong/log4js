package com.github.greengerong.log4js.service;

import com.github.greengerong.log4js.model.LogInfo;

public interface Log4jsService {

    void info(LogInfo logInfo);

    void debug(LogInfo logInfo);

    void warn(LogInfo logInfo);

    void error(LogInfo logInfo);
}
