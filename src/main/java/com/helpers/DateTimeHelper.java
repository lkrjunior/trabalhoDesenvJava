package com.helpers;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.TimeZone;

public class DateTimeHelper
{
    public static LocalTime GetLocalTime(LocalDateTime localDateTime)
    {
        return LocalTime.of(localDateTime.getHour(), localDateTime.getMinute(), localDateTime.getSecond(), localDateTime.getNano());
    }

    public static LocalDateTime GetLocalTime(long timestamp)
    {
        if (timestamp == 0)
        {
            return null;
        }

        return LocalDateTime.ofInstant(Instant.ofEpochSecond(timestamp),
                TimeZone.getDefault().toZoneId());
    }

    public static long GetCurrentLongTimestamp()
    {
        Date date = new Date();

        return date.getTime();
    }

    public static Timestamp GetTimestampFromLongTimestamp(long timestamp)
    {
        return new Timestamp(timestamp);
    }
}
