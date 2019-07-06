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
public class AlertEmailBOTest
{
    private final String _metric_cpu = "CPU";
    private final String _metric_memory = "MEMORY";

    @Autowired
    private RulesBO rulesBO;

    @Test
    public void SendAlertEmailCpu()
    {
        INotification notificatioEmail = new AlertEmailBO();
        AlertDTO alert = AlertDTOHelperTest.GetAlertDtoForTest("40", "localhost:alertemailbo");
        alert.setRuleName(_metric_cpu);
        rulesBO.SetAlertDTO(alert);
        assertTrue(notificatioEmail.Send(rulesBO));
    }

    @Test
    public void SendAlertEmailMemory()
    {
        INotification notificatioEmail = new AlertEmailBO();
        AlertDTO alert = AlertDTOHelperTest.GetAlertDtoForTest("40", "localhost:alertemailbo");
        alert.setRuleName(_metric_memory);
        rulesBO.SetAlertDTO(alert);
        assertTrue(notificatioEmail.Send(rulesBO));
    }
}