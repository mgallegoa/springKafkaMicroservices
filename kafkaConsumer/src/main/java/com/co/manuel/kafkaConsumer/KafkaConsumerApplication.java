package com.co.manuel.kafkaConsumer;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class KafkaConsumerApplication {

  public static void main(String[] args) {
    SpringApplication.run(KafkaConsumerApplication.class, args);
  }

  @Bean
  public ApplicationRunner runner(Environment env) {
    return args -> {
      System.out.println("*************************************************");
      System.out.println("BOOTSTRAP: " +
          env.getProperty("spring.kafka.bootstrapServer"));
      System.out.println("*************************************************");
    };
  }

}
