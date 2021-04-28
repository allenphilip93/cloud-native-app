package com.cloudnative.services.generator.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class CustomerEventProducer {

  @Autowired
  private KafkaTemplate<String, Event> eventKafkaTemplate;

  @Value(value = "${customer.topic.name}")
  private String eventTopicName;

  public void sendEventMessage(Event event) {
    eventKafkaTemplate.send(eventTopicName, event);
  }
}
