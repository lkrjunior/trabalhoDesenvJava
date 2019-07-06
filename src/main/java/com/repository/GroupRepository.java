package com.repository;

import com.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalTime;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long>
{
    @Query("SELECT GA \n"+
            " FROM Group GA \n" +
            "WHERE GA.defaultAlert = true")
    Group findDefaultAlert();
/*
    @Query("SELECT GA \n" +
            " FROM Group GA \n" +
            " INNER JOIN GroupSchedule GAS  \n" +
            " INNER JOIN Metric MA  \n" +
            "WHERE MA.code = ?1 \n" +
            "  AND GAS.timeStart = ?2 \n" +
            "  AND GAS.timeEnd = ?3")
*/
    @Query("SELECT GA \n" +
            " FROM Group GA \n" +
            " INNER JOIN GA.groupSchedule GAS  \n" +
            " INNER JOIN GA.metric MA  \n" +
            "WHERE LOWER(MA.code) = ?1 \n" +
            "  AND ?2 BETWEEN GAS.timeStart AND GAS.timeEnd")
    Group findAlert(String metric, LocalTime time);

}
