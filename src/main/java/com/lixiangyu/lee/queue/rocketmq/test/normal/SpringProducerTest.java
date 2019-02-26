package com.lixiangyu.lee.queue.rocketmq.test.normal;


import com.lixiangyu.lee.queue.rocketmq.Config;
import com.lixiangyu.lee.queue.rocketmq.normal.SpringProducer;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.UnsupportedEncodingException;

/**
 * @program: member-service
 * @description:
 * @author: lixiangyu
 * @create: 2019-02-21 16:43
 **/
public class SpringProducerTest {

    private ApplicationContext context;

    @Before
    public void setUp() {
        context = new AnnotationConfigApplicationContext(Config.class);
    }

    @Test
    public void sendMessage() throws UnsupportedEncodingException, InterruptedException, RemotingException, MQClientException, MQBrokerException {
        SpringProducer springProducer = context.getBean(SpringProducer.class);

        for (int i = 0; i < 10 ;i++) {
            Message message = new Message("spring-test-topic",
                    "aa", ("spring send message + " + i).getBytes(RemotingHelper.DEFAULT_CHARSET));
            SendResult send = springProducer.getProducer().send(message);
            System.out.println("reuslt == " + send);
        }

    }


}
