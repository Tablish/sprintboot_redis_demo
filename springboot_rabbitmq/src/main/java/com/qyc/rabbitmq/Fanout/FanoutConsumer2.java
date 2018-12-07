package com.qyc.rabbitmq.Fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author qianyongchao
 * @Description
 * @Date 2018/12/7 9:57
 * @Modified By
 */
@Component
@RabbitListener(queues = "fanout-queue-2")
public class FanoutConsumer2 {

    @RabbitHandler
    public void test(String context) {
        System.out.println("fanout consumer2 "+context);
    }
}
