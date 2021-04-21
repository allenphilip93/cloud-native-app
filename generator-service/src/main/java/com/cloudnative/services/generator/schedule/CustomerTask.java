package com.cloudnative.services.generator.schedule;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CustomerTask {
    
    private static final Logger log = LoggerFactory.getLogger(CustomerTask.class);

    @Scheduled(initialDelay = 5000, fixedDelay = 5000)
    void execute() {
        log.info("Method executed at every 5 seconds. Current time is :: " + new Date());
    }
}
