package com.bo;

import com.dto.AlertDTO;
import com.helpers.AlertDTOHelperTest;
import com.helpers.DateTimeHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;


@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class AlertBOTest
{
    private final String _metric_cpu = "CPU";
    private final String _metric_memory = "MEMORY";

    @Autowired
    private AlertBO alertBO;

    private static final Logger logger = LoggerFactory.getLogger(AlertBOTest.class);

    @Test
    public void GetCurrentTimestamp()
    {
        long timestamp = DateTimeHelper.GetCurrentLongTimestamp();
        logger.info("Timestamp in milliseconds: " + timestamp);

        Timestamp timestampFormatted = DateTimeHelper.GetTimestampFromLongTimestamp(timestamp);
        logger.info("Current timestamp: " + timestampFormatted);

        assertTrue(timestamp != 0);
        assertTrue(timestampFormatted != null);
    }

    @Test
    public void SendAlertsMemory()
    {
        AlertDTO alert = AlertDTOHelperTest.GetAlertDtoForTest("30", "localhost:alertbo");
        alert.setRuleName(_metric_memory);
        alertBO.SetAlertDTO(alert);
        assertTrue(alertBO.Send(alert));
    }

    @Test
    public void SendAlertsCPU()
    {
        AlertDTO alert = AlertDTOHelperTest.GetAlertDtoForTest("30", "localhost:alertbo");
        alert.setRuleName(_metric_cpu);
        alertBO.SetAlertDTO(alert);
        assertTrue(alertBO.Send(alert));
    }
}