package com.lixiangyu.lee.queue.rocketmq;


import com.lixiangyu.lee.queue.rocketmq.normal.MessageListener;
import com.lixiangyu.lee.queue.rocketmq.normal.SpringConsumer;
import com.lixiangyu.lee.queue.rocketmq.normal.SpringProducer;
import com.lixiangyu.lee.queue.rocketmq.order.OrderConsumer;
import com.lixiangyu.lee.queue.rocketmq.order.OrderMessageListener;
import com.lixiangyu.lee.queue.rocketmq.order.OrderMessageQueueSelector;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: member-service
 * @description:
 * @author: lixiangyu
 * @create: 2019-02-21 16:37
 **/
@Configuration
public class Config {

    @Bean
    public SpringConsumer getSpringConsumer() {
        MessageListener messageListener = new MessageListener();
        SpringConsumer springConsumer = new SpringConsumer("spring-consumer",
                "127.0.0.1:9876", "spring-test-topic", messageListener);
        return springConsumer;
    }

    @Bean
    public SpringProducer getSpringProducer() {
        SpringProducer springProducer = new SpringProducer("spring-producer", "127.0.0.1:9876");
        return  springProducer;

    }

    @Bean
    public OrderMessageQueueSelector getOrderMessageQueueSelector() {
        return new OrderMessageQueueSelector();
    }

    @Bean
    public OrderConsumer getOrderConsumer() {
        OrderMessageListener orderMessageListener = new OrderMessageListener();
        OrderConsumer consumer = new OrderConsumer("order-consumer", "127.0.0.1:9876",
                "topic_example_order", orderMessageListener);
        return consumer;
    }



}
