package com.qyc.rabbitmq.TopicDemo;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author qianyongchao
 * @Description
 * @Date 2018/12/6 18:28
 * @Modified By
 */
@Component
public class TopicSender1 {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send1() {
        String context = " message 1";
        System.out.println("topic sender1 "+context);
        amqpTemplate.convertAndSend("exchange", "topic.message1", context);
    }

    public void send2() {
        String context = " message 2";
        System.out.println("topic sender2 "+context);
        amqpTemplate.convertAndSend("exchange", "topic.message2", context);
    }
}
