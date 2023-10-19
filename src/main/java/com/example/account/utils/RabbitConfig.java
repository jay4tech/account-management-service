package com.example.account.utils;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    @Value("${queue.name.debitCredit}")
    private String queueDebitCredit;

    @Bean(name = "queueDebitCredit")
    public Queue queueDebitCredit() {
        return new Queue(queueDebitCredit, true);
    }

    @Value("${queue.name.reverseDebit}")
    private String queueNameReverseDebit;

    @Bean(name = "queueReverseDebit")
    public Queue queueReverseDebit() {
        return new Queue(queueNameReverseDebit, true);
    }


    @Value("${queue.name.audit}")
    private String queueNameEvent;

    @Bean(name = "queueEvent")
    public Queue queueEvent() {
        return new Queue(queueNameEvent, true);
    }
}