package com.bo;

import com.contracts.INotification;
import com.dto.AlertDTO;
import com.helpers.AlertDTOHelperTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;


@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class AlertSlackBOTest
{
    private final String _metric_cpu = "CPU";
    private final String _metric_memory = "MEMORY";

    @Autowired
    private RulesBO rulesBO;

    @Test
    public void SendAlertSlackCpu()
    {
        INotification notificatioSlack = new AlertSlackBO();
        AlertDTO alert = AlertDTOHelperTest.GetAlertDtoForTest("50", "localhost:alertslackbo");
        alert.setRuleName(_metric_cpu);
        rulesBO.SetAlertDTO(alert);
        assertTrue(notificatioSlack.Send(rulesBO));
    }

    @Test
    public void SendAlertSlackMemory()
    {
        INotification notificatioSlack = new AlertSlackBO();
        AlertDTO alert = AlertDTOHelperTest.GetAlertDtoForTest("50", "localhost:alertslackbo");
        alert.setRuleName(_metric_memory);
        rulesBO.SetAlertDTO(alert);
        assertTrue(notificatioSlack.Send(rulesBO));
    }
}
