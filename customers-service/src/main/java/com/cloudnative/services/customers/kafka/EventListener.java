package com.cloudnative.services.customers.kafka;

import java.util.concurrent.CountDownLatch;

import com.cloudnative.services.customers.model.EntityPOJO;
import com.cloudnative.services.customers.service.ApiService;
import com.cloudnative.services.customers.service.GeneratorService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

public class EventListener {

  private static final Logger log = LoggerFactory.getLogger(EventListener.class);

  private final ApiService apiService;
  private final GeneratorService generatorService;

  @Autowired
  public EventListener(ApiService apiService, GeneratorService generatorService) {
    this.apiService = apiService;
    this.generatorService = generatorService;
  }

  private CountDownLatch eventLatch = new CountDownLatch(1);

  @KafkaListener(topics = "${event.topic.name}", containerFactory = "eventKafkaListenerContainerFactory")
  public void eventListener(Event event) {
    System.out.println("Received event message: " + event);
    switch(event.getType()) {
      case "create":
        log.info("Creating a customer: " + event.getInfo());
        EntityPOJO pojo = generatorService.generateNewPojo();
        apiService.create(pojo);
        break;
      default:
        log.error("Invalid event type recieved");
    }
    this.eventLatch.countDown();
  }

  public CountDownLatch getEventLatch() {
    return this.eventLatch;
  }
}
