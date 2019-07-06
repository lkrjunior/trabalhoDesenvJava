package com.queue;

import com.bo.AlertBO;
import com.dto.AlertDTO;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MonitorRoute extends RouteBuilder {

    @Value("${route.from.metric}")
    private String fromQueue;


    @Override
    public void configure() {
        from(fromQueue)
                .log("Mensagem recebida")
                .unmarshal().json(JsonLibrary.Gson, AlertDTO.class)
                .bean(AlertBO.class, "Send");
    }
}
