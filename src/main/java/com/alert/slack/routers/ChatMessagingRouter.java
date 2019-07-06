package com.alert.slack.routers;

import org.apache.camel.Endpoint;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.slack.SlackComponent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

public class ChatMessagingRouter { }
/*
@Component
public class ChatMessagingRouter extends RouteBuilder {

    @Value("${slack.webhookup}")
    private String webHookUrl;

    @Value("${slack.endpoint}")
    private String slackEndpoint;

    @Value("${slack.message}")
    private String textMessageSlack;

    @Override
    public void configure() throws Exception {
        from("timer:hello?period=60000").process(new MessageResolver()).to(getSlackEndpoint());
    }

    private Endpoint getSlackEndpoint() throws Exception {
        SlackComponent component = new SlackComponent();
        component.setWebhookUrl(webHookUrl);
        component.setCamelContext(getContext());
        return component.createEndpoint(slackEndpoint);
    }

    private class MessageResolver implements Processor {
        @Override
        public void process(Exchange exchange) {
            exchange.getOut().setBody(textMessageSlack);
        }
    }
}
*/
