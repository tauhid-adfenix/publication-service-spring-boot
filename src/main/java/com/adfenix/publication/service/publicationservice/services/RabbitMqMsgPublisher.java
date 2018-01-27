package com.adfenix.publication.service.publicationservice.services;

import com.adfenix.publication.service.publicationservice.utils.Helper;
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


    public void send(String message) {
        template.convertAndSend(queue.getName(), Helper.formatPublishString(message));
        log.warn(" [x] Sent '" + message + "'");
    }
}
