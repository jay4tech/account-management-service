package com.example.inventory.utils;

import com.example.inventory.model.TransactionEvent;
import com.example.inventory.service.IAccountService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

    @Autowired
    IAccountService iAccountService;

    @Autowired
    MessageSender messageSender;

    @RabbitListener(queues = {"${queue.name.reverseDebit}"})
    public void receiveToReverseDebit(@Payload String message) {
        try {
            System.out.println("Message " + message);
            TransactionEvent transaction = (TransactionEvent) UtilityMapper.responseToModel(message, TransactionEvent.class);
            iAccountService.debitCreditAccount(transaction);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}