package com.github.greengerong.log4js.controller;


import com.github.greengerong.log4js.controller.LogController;
import com.github.greengerong.log4js.factory.LogService;
import com.github.greengerong.log4js.model.LogInfo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;


@RunWith(MockitoJUnitRunner.class)
public class LogControllerTest {

    private LogController logController;
    @Mock
    private LogService logService;

    @Before
    public void setUp() throws Exception {

        logController = new LogController(logService);
    }

    @Test
    public void shouldLogDataInfo() throws Exception {

        final LogInfo logInfo = new LogInfo();

        logController.log(logInfo);

        verify(logService).log(logInfo);
    }
}
