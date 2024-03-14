package com.tugcetasyildiz.restaurants.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public KafkaAdmin.NewTopics createTopics() {
        NewTopic errorLog = TopicBuilder.name("errorLog").build();
        NewTopic requestLog = TopicBuilder.name("requestLog").build();

        return new KafkaAdmin.NewTopics(errorLog, requestLog);
    }

}
