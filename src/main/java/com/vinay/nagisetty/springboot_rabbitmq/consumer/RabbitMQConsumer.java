package com.vinay.nagisetty.springboot_rabbitmq.consumer;

import com.vinay.nagisetty.springboot_rabbitmq.producer.RabbitMQProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQConsumer {

    private static final Logger LOGGER1= LoggerFactory.getLogger(RabbitMQProducer.class);

    @RabbitListener(queues = "${rabbitmq.queue.name}")
    public void consumeMessage(String message) {
        LOGGER1.info("Consuming message: "+message);
    }
}


