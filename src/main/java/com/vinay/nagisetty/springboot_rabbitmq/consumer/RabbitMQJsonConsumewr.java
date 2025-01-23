package com.vinay.nagisetty.springboot_rabbitmq.consumer;


import com.vinay.nagisetty.springboot_rabbitmq.dto.User;
import com.vinay.nagisetty.springboot_rabbitmq.producer.RabbitMQProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQJsonConsumewr {

    private static final Logger LOGGER1= LoggerFactory.getLogger(RabbitMQProducer.class);

    @RabbitListener(queues = "${rabbitmq.queue.json.name}")
    public void consumeMessage(User user) {
        LOGGER1.info("Consuming message: "+user.toString());
    }
}
