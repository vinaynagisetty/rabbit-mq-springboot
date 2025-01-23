package com.vinay.nagisetty.springboot_rabbitmq.controller;

import com.vinay.nagisetty.springboot_rabbitmq.producer.RabbitMQProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class RabbitMQController {

    private RabbitMQProducer rabbitMQProducer;

    public RabbitMQController(RabbitMQProducer rabbitMQProducer) {
        this.rabbitMQProducer = rabbitMQProducer;
    }

    @GetMapping("/produce")
    public ResponseEntity<String> produceMessage(@RequestParam("message") String message) {
        rabbitMQProducer.produceMessage(message);
        return ResponseEntity.ok("Message sent to the RabbitMQ Successfully");
    }

}
