package com.qyc.rabbitmq.Many;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Author qianyongchao
 * @Description
 * @Date 2018/12/6 16:59
 * @Modified By
 */
@Component
public class Sender3 {

    @Autowired
    private AmqpTemplate amqpTemplate;

    /**
     * 发送消息
     */
    public void send() {
        String context = "hello "+ new Date();
        amqpTemplate.convertAndSend("queue2", context);
    }
}
