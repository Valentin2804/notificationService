package com.example.notificationservice.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic bought() {
        return TopicBuilder.name("bought").build();
    }

    @Bean
    public NewTopic sold() {
        return TopicBuilder.name("sold").build();
    }
}
