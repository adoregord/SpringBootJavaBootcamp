package com.example.jms.receiver;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.example.jms.model.Email;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class Receiver {

    @JmsListener(destination = "mailbox", containerFactory = "myFactory")
    public void receiveMessage(Email email) {
        log.info("Received <" + email + ">");
    }

}