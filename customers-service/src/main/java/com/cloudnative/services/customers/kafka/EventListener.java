package com.cloudnative.services.customers.kafka;

import java.util.concurrent.CountDownLatch;

import org.springframework.kafka.annotation.KafkaListener;

public class EventListener {

    private CountDownLatch eventLatch = new CountDownLatch(1);

    @KafkaListener(topics = "${event.topic.name}", containerFactory = "eventKafkaListenerContainerFactory")
    public void greetingListener(Event event) {
        System.out.println("Received event message: " + event);
        this.eventLatch.countDown();
    }

    public CountDownLatch getEventLatch() {
        return this.eventLatch;
    }

}
