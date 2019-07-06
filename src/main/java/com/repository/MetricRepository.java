package com.repository;

import com.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalTime;

@Repository
public interface MetricRepository extends JpaRepository<Metric, Long>
{
    @Query("SELECT M \n" +
            " FROM Metric M \n" +
            "WHERE M.code = ?1")
    Metric findMetricByCode(String code);
}

