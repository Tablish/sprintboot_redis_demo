package com.qyc.rabbitmq.OneToOne;

import com.sun.javafx.collections.MappingChange;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Sender1 {
    @Autowired
    private AmqpTemplate amqpTemplate;

    /**
     * 发送消息
     */
    public void send() {
        String context = "hello hahah";
        System.out.println("sender1 " + context);
        amqpTemplate.convertAndSend("queue1", context);
    }
}
