package com.model;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "METRIC_ALERT")
@EnableAutoConfiguration
public class Metric {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID_METRIC")
    private Long id;

    @Column(name = "CODE", unique = true)
    @NotNull
    private String code;

    @NotNull
    @Column(name = "VALUE")
    private String value;

    public String GetValue()
    {
        return this.value;
    }
}
