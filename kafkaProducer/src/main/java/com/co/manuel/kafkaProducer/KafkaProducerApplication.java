package com.co.manuel.kafkaProducer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class KafkaProducerApplication {

  @Value("${spring.kafka.topicName}")
  private String topicName;

  public static void main(String[] args) {
    SpringApplication.run(KafkaProducerApplication.class, args);
  }

  @Bean
  CommandLineRunner init(KafkaTemplate<String, String> kafkaTemplate) {
    return args -> {
      kafkaTemplate.send(topicName, "Message from Spring Boot kafka 4.");

    };
  }

}
