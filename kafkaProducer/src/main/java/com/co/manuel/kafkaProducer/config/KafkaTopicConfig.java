package com.co.manuel.kafkaProducer.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

  @Value("${spring.kafka.topicName}")
  private String topicName;

  public NewTopic getTopicConfig() {

    Map<String, String> config = new HashMap<>();
    config.put(TopicConfig.CLEANUP_POLICY_CONFIG, TopicConfig.CLEANUP_POLICY_DELETE); // delete messages,compact keep
                                                                                      // the updated message
    config.put(TopicConfig.RETENTION_MS_CONFIG, "86400000"); // Time in ms to keep the messages (default -1)
    config.put(TopicConfig.SEGMENT_BYTES_CONFIG, "1073741824");// Max size Bytes of segment (default 1GB)
    config.put(TopicConfig.MAX_MESSAGE_BYTES_CONFIG, "1000548");// Max size of each message (default 1MB)

    return TopicBuilder.name(topicName)
        .partitions(3)
        .replicas(2)
        .configs(config)
        .build();
  }

}
