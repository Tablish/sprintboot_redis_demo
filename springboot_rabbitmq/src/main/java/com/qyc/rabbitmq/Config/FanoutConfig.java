package com.qyc.rabbitmq.Config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author qianyongchao
 * @Description
 * @Date 2018/12/7 9:38
 * @Modified By
 */
@Configuration
public class FanoutConfig {

    //生成三个队列
    @Bean
    public Queue fanoutQueue1() {
        return new Queue("fanout-queue-1");
    }

    @Bean
    public Queue fanoutQueue2() {
        return new Queue("fanout-queue-2");
    }

    @Bean
    public Queue fanoutQueue3() {
        return new Queue("fanout-queue-3");
    }

    //生成一个交换机 fanoutExchange
    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanoutExchange");
    }

    //交换机绑定fanoutQueue1
    @Bean
    Binding fanoutExchangeQueue1( Queue fanoutQueue1, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(fanoutQueue1).to(fanoutExchange);
    }

    //交换机绑定fanoutQueue2
    @Bean
    Binding fanoutExchangeQueue2(Queue fanoutQueue2, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(fanoutQueue2).to(fanoutExchange);
    }

    //交换机绑定fanoutQueue3
    @Bean
    Binding fanoutExchangeQueue3(Queue fanoutQueue3, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(fanoutQueue3).to(fanoutExchange);
    }

}
