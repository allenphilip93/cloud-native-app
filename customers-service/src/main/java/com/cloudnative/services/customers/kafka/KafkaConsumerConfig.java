package com.cloudnative.services.customers.kafka;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class KafkaConsumerConfig {

  @Value(value = "${kafka.bootstrapAddress}")
  private String bootstrapAddress;

  public ConsumerFactory<String, String> consumerFactory(String groupId) {
    Map<String, Object> props = new HashMap<>();
    props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
    props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
    props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
    props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
    return new DefaultKafkaConsumerFactory<>(props);
  }

  public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory(String groupId) {
    ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
    factory.setConsumerFactory(consumerFactory(groupId));
    return factory;
  }

  public ConsumerFactory<String, Event> eventConsumerFactory() {
    Map<String, Object> props = new HashMap<>();
    props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
    props.put(ConsumerConfig.GROUP_ID_CONFIG, "event");

    JsonDeserializer<Event> deserializer = new JsonDeserializer<>(Event.class);
    deserializer.setRemoveTypeHeaders(false);
    deserializer.addTrustedPackages("*");
    return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(), deserializer);
  }

  @Bean
  public ConcurrentKafkaListenerContainerFactory<String, Event> eventKafkaListenerContainerFactory() {
    ConcurrentKafkaListenerContainerFactory<String, Event> factory = new ConcurrentKafkaListenerContainerFactory<>();
    factory.setConsumerFactory(eventConsumerFactory());
    return factory;
  }

}