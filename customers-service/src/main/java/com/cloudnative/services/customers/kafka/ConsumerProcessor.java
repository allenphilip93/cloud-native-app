package com.cloudnative.services.customers.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ConsumerProcessor {

  private final ObjectMapper objectMapper;
  private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerProcessor.class);

  @Autowired
  public ConsumerProcessor(ObjectMapper objectMapper) {
    super();
    this.objectMapper = objectMapper;
  }

  public void recieveMessage(String json) {
    LOGGER.info("Recieved message");
    try {
      Event event = this.objectMapper.readValue(json, Event.class);
      LOGGER.info("JSON recieved: ", event.toString());
    } catch(IOException exc) {
      LOGGER.error("Exception caught", exc);
    }
  }
}
