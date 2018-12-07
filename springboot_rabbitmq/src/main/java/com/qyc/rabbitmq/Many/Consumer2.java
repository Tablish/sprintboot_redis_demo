package com.qyc.rabbitmq.Many;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author qianyongchao
 * @Description
 * @Date 2018/12/6 16:50
 * @Modified By
 */
@Component
@RabbitListener(queues = "queue2")
public class Consumer2 {
    @RabbitHandler
    public void oneToMany1(String hello) {
        System.out.println("Consumer2 " + hello);
    }
}
