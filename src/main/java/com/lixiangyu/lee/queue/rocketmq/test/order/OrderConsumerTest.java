package com.lixiangyu.lee.queue.rocketmq.test.order;


import com.lixiangyu.lee.queue.rocketmq.Config;
import com.lixiangyu.lee.queue.rocketmq.order.OrderConsumer;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.concurrent.TimeUnit;

/**
 * @program: member-service
 * @description:
 * @author: lixiangyu
 * @create: 2019-02-22 13:40
 **/
public class OrderConsumerTest {

    private ApplicationContext context;

    @Before
    public void setUp() {
        context = new AnnotationConfigApplicationContext(Config.class);
    }

    @Test
    public void consumer() throws InterruptedException {
        OrderConsumer consumer = context.getBean(OrderConsumer.class);
        TimeUnit.SECONDS.sleep(10);
        consumer.destory();
    }

}
