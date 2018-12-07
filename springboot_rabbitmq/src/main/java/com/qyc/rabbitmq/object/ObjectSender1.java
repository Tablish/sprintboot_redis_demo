package com.qyc.rabbitmq.object;

import com.qyc.rabbitmq.Entity.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Author qianyongchao
 * @Description
 * @Date 2018/12/6 17:56
 * @Modified By
 */

@Component
public class ObjectSender1 {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void sender(User user) {

        System.out.println("object_sender:"+ user.toString());
        amqpTemplate.convertAndSend("queue2", user.toString());
    }

}
