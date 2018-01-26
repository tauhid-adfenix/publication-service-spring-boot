package com.adfenix.publication.service.publicationservice.config;

import com.adfenix.publication.service.publicationservice.services.RabbitMqMsgPublisher;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author Tauhid
 */

@Configuration
public class RabbitMqConfig {
private static String RABBITMQ_MSG_QUEUE = "rabittmq.test.queue";

    @Bean
    public Queue queue() {
        return new Queue(RABBITMQ_MSG_QUEUE, true);
    }

    @Bean
    public RabbitMqMsgPublisher sender() {
        return new RabbitMqMsgPublisher();
    }

//    @Profile("receiver")
//    private static class ReceiverConfig {
//
//        @Bean
//        public Queue autoDeleteQueue1() {
//            return new AnonymousQueue();
//        }
//
//        @Bean
//        public Queue autoDeleteQueue2() {
//            return new AnonymousQueue();
//        }
//
//        @Bean
//        public Binding binding1(FanoutExchange fanout, Queue autoDeleteQueue1) {
//            return BindingBuilder.bind(autoDeleteQueue1).to(fanout);
//        }
//
//        @Bean
//        public Binding binding2(FanoutExchange fanout, Queue autoDeleteQueue2) {
//            return BindingBuilder.bind(autoDeleteQueue2).to(fanout);
//        }
//
//        @Bean
//        public Tut3Receiver receiver() {
//            return new Tut3Receiver();
//        }
//
//    }

}