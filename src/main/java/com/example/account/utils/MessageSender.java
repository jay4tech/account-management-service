package com.example.account.utils;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MessageSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    @Qualifier("queueDebitCredit")
    private Queue queueDebitCredit;

    public void sendDebitCreditDetails(String message) {
        rabbitTemplate.convertAndSend(queueDebitCredit.getName(), message);
    }
    @Autowired
    @Qualifier("queueEvent")
    private Queue queueEvent;

    public void sendAuditEvent(String message) {
        rabbitTemplate.convertAndSend(queueEvent.getName(), message);
    }
}
