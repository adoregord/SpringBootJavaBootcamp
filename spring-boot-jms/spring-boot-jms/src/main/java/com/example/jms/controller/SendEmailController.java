package com.example.jms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.jms.model.Email;

@RestController
public class SendEmailController {
    @Autowired
    JmsTemplate jmsTemplate;
    
    @PostMapping("/api/send-email")
    public ResponseEntity<Email> sendEmail(@RequestBody Email email) throws Exception{
        jmsTemplate.convertAndSend("mailbox", email);
        return ResponseEntity.ok(email);
    }
}