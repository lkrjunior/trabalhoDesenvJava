package com.dto;

import com.helpers.DateTimeHelper;

import java.time.LocalDateTime;

public class AlertDTO
{
    private LocalDateTime dateTime;
    private Long timestamp;
    private String source;
    private String name;
    private String ruleName;
    private String value;

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRuleName()
    {
        if (ruleName != null)
        {
            return ruleName.toLowerCase();
        }

        return "";
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public LocalDateTime GetLocalDatetimeFromTimestamp()
    {
        return DateTimeHelper.GetLocalTime(timestamp);
    }
}
