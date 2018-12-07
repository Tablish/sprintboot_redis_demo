package com.qyc.rabbitmq.Config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author qianyongchao
 * @Description
 * @Date 2018/12/6 18:22
 * @Modified By
 */
@Configuration
public class TopicConfig {
    final static String MESSAGE1 = "topic.message1";
    final static String MESSAGE2 = "topic.message2";


    @Bean
    public Queue queueMessage1() {
        return new Queue(TopicConfig.MESSAGE1);
    }

    @Bean
    public Queue queueMessage2() {
        return new Queue(TopicConfig.MESSAGE2);
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange("exchange");
    }

    @Bean
    Binding bindingExchangeMessage1(Queue queueMessage1, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessage1).to(exchange).with("topic.message1");
    }

    @Bean
    Binding bindingExchangeMessage2(Queue queueMessage2, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessage2).to(exchange).with("topic.*");
    }



}
