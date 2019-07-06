package com.bo;

import com.contracts.INotification;
import com.dto.AlertDTO;
import com.helpers.DateTimeHelper;
import com.validator.AlertValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class AlertBO
{
    @Autowired
    RulesBO rulesBO;

    AlertDTO alertDTO;

    private static final Logger logger = LoggerFactory.getLogger(AlertBO.class);

    public AlertBO()
    { }

    public AlertBO(AlertDTO alertDTO)
    {
        this.alertDTO = alertDTO;
    }

    public void SetAlertDTO(AlertDTO alertDTO)
    {
        this.alertDTO = alertDTO;
    }

    public boolean Send(AlertDTO alertDTO)
    {
        try
        {
            AlertValidator.ValidateAlertDTO(alertDTO);

            logger.info("Payload { Timestamp: " + alertDTO.getTimestamp().toString() +
                    ", Datetime: " + DateTimeHelper.GetTimestampFromLongTimestamp(alertDTO.getTimestamp()) +
                    ", Source: " + alertDTO.getSource() +
                    ", RuleName: " + alertDTO.getRuleName() +
                    ", Value: " + alertDTO.getValue() + " }");

            logger.info("Send notification e-mail");
            this.alertDTO = alertDTO;
            INotification notificatioEmail = new AlertEmailBO();
            rulesBO.SetAlertDTO(this.alertDTO);
            notificatioEmail.Send(rulesBO);

            logger.info("Send notification slack");
            INotification notificatioSlack = new AlertSlackBO();
            rulesBO.SetAlertDTO(this.alertDTO);
            notificatioSlack.Send(rulesBO);

            logger.info("Notifications sends sucessfully");
            return true;
        }
        catch (Exception ex)
        {
            logger.error(ex.getMessage());
            return false;
        }
    }
}
