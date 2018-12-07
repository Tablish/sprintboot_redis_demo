package com.qyc.rabbitmq.object;

import com.qyc.rabbitmq.Entity.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author qianyongchao
 * @Description
 * @Date 2018/12/6 18:01
 * @Modified By
 */

@Component
@RabbitListener(queues = "queue2")
public class ObjectConsumer1 {

    @RabbitHandler
    public void consumer1(User user) {
        System.out.println("object_consumer1 " + user.toString());


    }
}
