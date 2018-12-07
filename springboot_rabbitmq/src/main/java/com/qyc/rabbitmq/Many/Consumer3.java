package com.qyc.rabbitmq.Many;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "queue2")
public class Consumer3 {



    @RabbitHandler
    public void oneToMany2(String hello) {
        System.out.println("Consumer3 " + hello);
    }
}
