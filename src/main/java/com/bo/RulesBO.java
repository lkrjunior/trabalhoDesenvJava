package com.bo;

import com.dto.AlertDTO;
import com.helpers.DateTimeHelper;
import com.model.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
public class RulesBO
{
    @Autowired
    private GroupBO groupBO;

    private AlertDTO alertDTO;
    private Group group;

    public void SetAlertDTO(AlertDTO alertDTO)
    {
        this.alertDTO = alertDTO;
    }

    public AlertDTO GetAlertDTO()
    {
        return this.alertDTO;
    }

    public Group GetGroupForAlert() throws Exception
    {
        this.group = groupBO.findAlert(alertDTO.getRuleName(), DateTimeHelper.GetLocalTime(this.alertDTO.GetLocalDatetimeFromTimestamp()));
        if (group == null)
        {
            group = groupBO.findDefaultAlert();
            if (group == null)
            {
                throw new Exception("Alert group not found");
            }
        }

        return group;
    }

    public String GetMessage()
    {
        String messageAlert = "";

        if (group != null)
        {
            messageAlert = group.GetMessage();
        }

        if (this.alertDTO != null)
        {
            String value = this.alertDTO.getValue() != null ? this.alertDTO.getValue() : "";
            String source = this.alertDTO.getSource() != null ? this.alertDTO.getSource() : "";
            long timestamp = this.alertDTO.getTimestamp();

            messageAlert = messageAlert +
                    ". " + "Value: " + value +
                    ". " + "Source: " + source +
                    ". " + "Datetime: " + (timestamp > 0 ? DateTimeHelper.GetTimestampFromLongTimestamp(timestamp) : "");
        }

        return messageAlert;
    }
}
