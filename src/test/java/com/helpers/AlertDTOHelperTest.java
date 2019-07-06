package com.helpers;

import com.dto.AlertDTO;
import java.time.LocalDateTime;
import java.util.Date;
import java.sql.Timestamp;

public class AlertDTOHelperTest
{
    public static AlertDTO GetAlertDtoForTest(String value, String source)
    {
        Date date = new Date();
        AlertDTO alert = new AlertDTO();

        alert.setDateTime(LocalDateTime.now());
        alert.setTimestamp(date.getTime());
        alert.setValue(value);
        alert.setSource(source);

        return alert;
    }
}
