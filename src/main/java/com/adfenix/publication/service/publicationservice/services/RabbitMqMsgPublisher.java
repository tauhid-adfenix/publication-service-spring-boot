package com.adfenix.publication.service.publicationservice.services;

import org.apache.log4j.LogManager;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

public class RabbitMqMsgPublisher {
    private static final org.apache.log4j.Logger log = LogManager.getLogger(RabbitMqMsgPublisher.class);

    @Autowired
    private RabbitTemplate template;

    @Autowired
    private Queue queue;


//    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    public void send(String msg) {
        StringBuilder builder = new StringBuilder(msg);
        String message = builder.toString();
        template.convertAndSend(queue.getName(), message);
        log.warn(" [x] Sent '" + message + "'");
    }
}
