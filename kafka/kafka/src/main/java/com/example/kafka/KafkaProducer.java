package com.example.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class KafkaProducer {
    private KafkaTemplate<String, String> template;

    public KafkaProducer(KafkaTemplate<String, String> template) {
        super();
        this.template = template;
    }
    
    public void sendMessage(String message) {
        log.info("message sent: {}", message);
        template.send("topic1", message);
    }
}
