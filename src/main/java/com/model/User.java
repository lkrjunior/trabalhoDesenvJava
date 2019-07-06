package com.model;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "USER_ALERT")
@EnableAutoConfiguration
public class User {

    @Id
    @Column(name = "ID_USER")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME")
    @NotNull
    private String name;

    @ManyToOne
    @JoinColumn(name="ID_GROUP")
    private Group group;
}