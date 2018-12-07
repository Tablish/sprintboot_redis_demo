package com.qyc.rabbitmq.Fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author qianyongchao
 * @Description
 * @Date 2018/12/7 9:56
 * @Modified By
 */
@Component
@RabbitListener(queues = "fanout-queue-1")
public class FanoutConsumer1 {

    @RabbitHandler
    public void test(String message) {
        System.out.println("fanout consumer1 "+message);
    }
}
