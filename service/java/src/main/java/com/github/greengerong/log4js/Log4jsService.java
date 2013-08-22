package com.github.greengerong.log4js;

public interface Log4jsService {

    void info(LogInfo logInfo);

    void debug(LogInfo logInfo);

    void warn(LogInfo logInfo);

    void error(LogInfo logInfo);
}
