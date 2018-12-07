package com.qyc.rabbitmq.Fanout;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Author qianyongchao
 * @Description
 * @Date 2018/12/7 9:48
 * @Modified By
 */
@Component
public class FanoutSender {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void fanoutSender() {
        String context = "fanout sender " + new Date();
        System.out.println(context);
        amqpTemplate.convertAndSend("fanoutExchange", "", context);
    }

}
