package com.qyc.rabbitmq.Config;

import com.qyc.rabbitmq.Enums.QueueNames;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author qianyongchao
 * @Description
 * @Date 2018/12/6 15:48
 * @Modified By
 */
@Configuration
public class Config {
    @Bean
    public Queue Queue1() {
        return new Queue(QueueNames.ONETOMANY_NAME.getVal());
    }

    @Bean
    public Queue Queue2() {
        return new Queue(QueueNames.MANYTOMANY_NAME.getVal());
    }
}
