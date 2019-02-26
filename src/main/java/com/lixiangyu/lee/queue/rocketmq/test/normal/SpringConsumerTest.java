package com.lixiangyu.lee.queue.rocketmq.test.normal;


import com.lixiangyu.lee.queue.rocketmq.Config;
import com.lixiangyu.lee.queue.rocketmq.normal.SpringConsumer;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.concurrent.TimeUnit;

/**
 * @program: member-service
 * @description:
 * @author: lixiangyu
 * @create: 2019-02-21 17:01
 **/
public class SpringConsumerTest {

    private ApplicationContext context;

    @Before
    public void setUp() {
        context = new AnnotationConfigApplicationContext(Config.class);
    }

    @Test
    public void consumer() throws InterruptedException {
        SpringConsumer springConsumer = context.getBean(SpringConsumer.class);
        TimeUnit.SECONDS.sleep(10);
        springConsumer.destory();
    }


}
