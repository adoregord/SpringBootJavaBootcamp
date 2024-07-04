package com.example.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class KafkaConsumer {

    @KafkaListener(topics = "topic", groupId = "my-group")
    public void consume(String message) {
        log.info("message received : {}", message);
    }
    
}
