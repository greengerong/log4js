package com.github.greengerong.log4js;

public class LogService {

    private Level projectLevel;
    private Log4jsService log4jsService;

    public LogService(Level projectLevel, Log4jsService log4jsService) {
        this.projectLevel = projectLevel;
        this.log4jsService = log4jsService;
    }

    public LogService(Log4jsService log4jsService) {
        this(Level.Info, log4jsService);
    }

    public void log(LogInfo logInfo) {
        if (shouldLog(logInfo)) {
            innerLog(logInfo);
        }

    }

    private void innerLog(LogInfo logInfo) {

        if (Level.Debug == logInfo.getLevel()) {
            log4jsService.debug(logInfo);
        } else if (Level.Info == logInfo.getLevel()) {
            log4jsService.info(logInfo);
        } else if (Level.Warn == logInfo.getLevel()) {
            log4jsService.warn(logInfo);
        } else if (Level.Error == logInfo.getLevel()) {
            log4jsService.error(logInfo);
        }
    }

    private boolean shouldLog(LogInfo logInfo) {
        return projectLevel.getValue() <= logInfo.getLevel().getValue();
    }
}
