package com.model;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalTime;
import java.util.List;


@Entity
@Table(name = "GROUP_ALERT_SCHEDULE")
@EnableAutoConfiguration
public class GroupSchedule {

    @Id
    @Column(name = "ID_GROUP_SCHEDULE")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "TIME_START")
    private LocalTime timeStart;

    @NotNull
    @Column(name = "TIME_END")
    private LocalTime timeEnd;

}