package com.model;


import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalTime;
import java.util.List;


@Entity
@Table(name = "GROUP_ALERT")
@EnableAutoConfiguration
public class Group {

    @Id
    @Column(name = "ID_GROUP")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME")
    @NotNull
    private String name;

    @ManyToOne
    @JoinColumn(name = "ID_METRIC")
    private Metric metric;

    @ManyToOne
    @JoinColumn(name = "ID_GROUP_SCHEDULE")
    private GroupSchedule groupSchedule;

    @Column(name = "SLACK_WEBHOOK")
    private String slackWebhook;

    @Column(name = "SLACK_ENDPOINT")
    private String slackEndpoint;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "DEFAULT_ALERT")
    private boolean defaultAlert;

    @OneToMany(mappedBy = "group", targetEntity = User.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<User> users;

    public String GetEmail()
    {
        return this.email;
    }

    public String GetSlackWebook()
    {
        return this.slackWebhook;
    }

    public String GetSlackEndpoint()
    {
        return this.slackEndpoint;
    }

    public String GetMessage()
    {
        if (this.metric != null)
        {
            return this.metric.GetValue();
        }
        else
        {
            return "MetricUnknown";
        }
    }

}