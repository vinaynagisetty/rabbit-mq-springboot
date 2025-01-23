package com.vinay.nagisetty.springboot_rabbitmq.producer;

import com.vinay.nagisetty.springboot_rabbitmq.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQJsonProducer {

    @Value("${rabbitmq.exchange.name}")
    private  String EXCHANGE_NAME ;

    @Value("${rabbitmq.routing.json.key}")
    private  String json_ROUTING_KEY ;

    private static final Logger LOGGER= LoggerFactory.getLogger(RabbitMQProducer.class);

    private RabbitTemplate rabbitTemplate;

    public RabbitMQJsonProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void produceJsonMessage(User user) {
        LOGGER.info("Producing message: "+user.toString());
        rabbitTemplate.convertAndSend(EXCHANGE_NAME, json_ROUTING_KEY, user);
    }

}
