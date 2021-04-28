package com.cloudnative.services.generator.schedule;

import java.util.Date;

import com.cloudnative.services.generator.kafka.Event;
import com.cloudnative.services.generator.kafka.ProductEventProducer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ProductTask {
    
    private static final Logger log = LoggerFactory.getLogger(ProductTask.class);

    @Autowired
    private ProductEventProducer producer;

    @Scheduled(initialDelay = 5000, fixedDelay = 5000)
    void execute() {
        String dateStr = new Date().toString();
        log.info("Sending message every 5 seconds: Time is " + dateStr);
        producer.sendEventMessage(new Event("create", dateStr));
    }
}
