package com.qyc.rabbitmq.TopicDemo;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author qianyongchao
 * @Description
 * @Date 2018/12/6 18:28
 * @Modified By
 */
@Component
@RabbitListener(queues = "topic.message1")
public class TopicConsumer1 {

    @RabbitHandler
    public void consumer(String message) {
        System.out.println("topic consumer1 "+ message);
    }
}
