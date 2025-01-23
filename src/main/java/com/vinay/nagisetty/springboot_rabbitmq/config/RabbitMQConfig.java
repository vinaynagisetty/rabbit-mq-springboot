package com.vinay.nagisetty.springboot_rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Value("${rabbitmq.queue.name}")
    private  String QUEUE_NAME ;

    @Value("${rabbitmq.queue.json.name}")
    private  String Json_QUEUE_NAME ;

    @Value("${rabbitmq.exchange.name}")
    private  String EXCHANGE_NAME ;

    @Value("${rabbitmq.routing.key}")
    private  String ROUTING_KEY ;

    @Value("${rabbitmq.routing.json.key}")
    private  String json_ROUTING_KEY ;

    @Bean
    public Queue queue() {
        return new Queue(QUEUE_NAME);
    }

    @Bean
    public Queue json_queue() {
        return new Queue(Json_QUEUE_NAME);
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(EXCHANGE_NAME);
    }

    @Bean
    public Binding binding() {
        return BindingBuilder.bind(queue())
                .to(exchange())
                .with(ROUTING_KEY);
    }

    @Bean
    public Binding json_binding() {
        return BindingBuilder.bind(json_queue())
                .to(exchange())
                .with(json_ROUTING_KEY);
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }


//    Connection Factory
//     rabbit template
//     rabbit admin

//Implement the rabbitTemplate bean

     @Bean
    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }


}
