package com.vinay.nagisetty.springboot_rabbitmq.controller;
import com.vinay.nagisetty.springboot_rabbitmq.producer.RabbitMQJsonProducer;


import com.vinay.nagisetty.springboot_rabbitmq.dto.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class RabbitMQJsonController {

    private RabbitMQJsonProducer RabbitMQJsonProducer;

    public RabbitMQJsonController(RabbitMQJsonProducer RabbitMQJsonProducer) {
        this.RabbitMQJsonProducer = RabbitMQJsonProducer;
    }


    @PostMapping("/produce")
    public ResponseEntity<String> produceMessage(@RequestBody User user) {
        RabbitMQJsonProducer.produceJsonMessage(user);
        return ResponseEntity.ok("Message sent to the RabbitMQ Successfully");
    }


}
