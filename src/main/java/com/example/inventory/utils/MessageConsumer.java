package com.example.inventory.utils;

import com.example.inventory.service.IAccountService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

    @Autowired
    IAccountService inventoryService;

    @Autowired
    MessageSender messageSender;

    @RabbitListener(queues = {"${queue.name.inventory}"})
    public void receive(@Payload String message) {
        try {
            System.out.println("Message " + message);
            Order orderDetails = UtilityMapper.responseToModel(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}