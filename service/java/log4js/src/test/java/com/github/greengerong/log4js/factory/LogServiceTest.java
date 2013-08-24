package com.github.greengerong.log4js.factory;

import com.github.greengerong.log4js.factory.LogService;
import com.github.greengerong.log4js.model.Level;
import com.github.greengerong.log4js.model.LogInfo;
import com.github.greengerong.log4js.service.Log4jsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class LogServiceTest {

    @Mock
    private Log4jsService log4jsService;

    @Test
    public void shouldCallInfoMethodWhenProjectLevelIsLessThanInfo() throws Exception {
        LogService logService = new LogService(Level.Debug, log4jsService);
        final LogInfo logInfo = new LogInfo();
        logInfo.setLevel(Level.Info);

        logService.log(logInfo);

        verify(log4jsService).info(logInfo);
    }

    @Test
    public void shouldCallInfoMethodWhenProjectLevelIsEqualInfo() throws Exception {
        LogService logService = new LogService(Level.Info, log4jsService);
        final LogInfo logInfo = new LogInfo();
        logInfo.setLevel(Level.Info);


        logService.log(logInfo);

        verify(log4jsService).info(logInfo);
    }

    @Test
    public void shouldNotCallInfoMethodWhenProjectLevelIsGreaterThanInfo() throws Exception {
        LogService logService = new LogService(Level.Warn, log4jsService);
        final LogInfo logInfo = new LogInfo();
        logInfo.setLevel(Level.Info);


        logService.log(logInfo);

        verify(log4jsService, never()).info(logInfo);
    }

    @Test
    public void shouldCallDebugMethodWhenLevelIsDebug() throws Exception {
        LogService logService = new LogService(Level.All, log4jsService);
        final LogInfo logInfo = new LogInfo();
        logInfo.setLevel(Level.Debug);


        logService.log(logInfo);

        verify(log4jsService).debug(logInfo);
    }
}
