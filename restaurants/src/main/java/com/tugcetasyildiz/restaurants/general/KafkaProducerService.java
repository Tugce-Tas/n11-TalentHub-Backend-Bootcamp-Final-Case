package com.tugcetasyildiz.restaurants.general;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    private final String applicationName;

    public KafkaProducerService(KafkaTemplate kafkaTemplate,
                                @Value("${application.title}") String applicationName) {
        this.kafkaTemplate = kafkaTemplate;
        this.applicationName = applicationName;
    }
    public void sendMessage(String topic, String errorMessage){
        kafkaTemplate.send(topic, String.format("%s, FROM: %s",
                errorMessage,
                applicationName));
    }
}