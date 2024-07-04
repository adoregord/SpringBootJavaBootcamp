package com.example.kafka;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
public class MessageController {
    
    private KafkaProducer kafkaProducer;
        
    public MessageController(KafkaProducer kafkaProducer) {
        super();
        this.kafkaProducer = kafkaProducer;
    }


    @GetMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestParam("message") String message) {
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("message sent to the topic");
    }
}
