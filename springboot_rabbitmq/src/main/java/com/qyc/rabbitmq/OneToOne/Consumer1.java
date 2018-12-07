package com.qyc.rabbitmq.OneToOne;

import com.qyc.rabbitmq.Enums.QueueNames;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author qianyongchao
 * @description consumer1 主要是用来测一对一 consumer2 consumer3 用来测多对多
 * @date 17:02 2018/12/6
 * @param
 * @return
 */
@Component
@RabbitListener(queues = "queue1")
public class Consumer1 {
    /*
     * @author qianyongchao
     * @description hello内容就是 Sender1 sender()方法中的context内容
     * @date 17:30 2018/12/6
     * @param
     * @return void
     */
    @RabbitHandler
    public void comsumer(String  hello) {
        System.out.println("Consumer1 "+ hello);
    }
}
