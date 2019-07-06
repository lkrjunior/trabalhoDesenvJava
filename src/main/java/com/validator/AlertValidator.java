package com.validator;

import com.dto.AlertDTO;

public class AlertValidator
{
    public static void ValidateAlertDTO(AlertDTO alertDTO) throws Exception
    {
        if (alertDTO == null)
        {
            throw new Exception("Alert payload invalid");
        }
        else if (alertDTO.getTimestamp() == null || alertDTO.getTimestamp().equals(0))
        {
            throw new Exception("Alert payload Timestamp invalid");
        }
        else if (alertDTO.getRuleName() == null || alertDTO.getRuleName().equals(""))
        {
            throw new Exception("Alert payload RuleName invalid");
        }
        else if (alertDTO.getSource() == null || alertDTO.getSource().equals(""))
        {
            throw new Exception("Alert payload Source invalid");
        }
        else if (alertDTO.getValue() == null || alertDTO.getValue().equals(""))
        {
            throw new Exception("Alert payload Value invalid");
        }
    }

}
