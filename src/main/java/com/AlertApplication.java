package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
@EntityScan
@ComponentScan
public class AlertApplication
{
    private static final Logger logger = LoggerFactory.getLogger(AlertApplication.class);

    public static void main(String[] args)
    {
        logger.info("Initialize application");
        SpringApplication.run(AlertApplication.class, args);
    }
}
