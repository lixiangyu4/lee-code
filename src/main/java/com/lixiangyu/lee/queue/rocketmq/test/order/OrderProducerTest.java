package com.lixiangyu.lee.queue.rocketmq.test.order;


import com.lixiangyu.lee.queue.rocketmq.Config;
import com.lixiangyu.lee.queue.rocketmq.normal.SpringProducer;
import com.lixiangyu.lee.queue.rocketmq.order.OrderMessage;
import com.lixiangyu.lee.queue.rocketmq.order.OrderMessageQueueSelector;

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
 * @create: 2019-02-21 22:02
 **/
public class OrderProducerTest {

    private ApplicationContext context;

    @Before
    public void setUp() {
        context = new AnnotationConfigApplicationContext(Config.class);
    }

    @Test
    public void sendMessage() throws UnsupportedEncodingException, InterruptedException, RemotingException, MQClientException, MQBrokerException {

        SpringProducer producer = context.getBean(SpringProducer.class);
        OrderMessageQueueSelector orderMessageQuueueSelector = context.getBean(OrderMessageQueueSelector.class);

        String topicName = "topic_example_order";
        String[] statusnames = {"已创建","已付款","已配送","已取消","已完成"};

        //模拟订单消息
        for (int orderId = 1; orderId <= 10; orderId++) {
            //模拟订单的每个状态来发送消息
            for (int i = 0; i< statusnames.length;i++) {
                String messageContent = new OrderMessage().setId(orderId)
                        .setStatus(statusnames[i]).setSendOrder(i).setContent("hello orderly rocketmq message").toString();
                Message message = new Message(topicName, statusnames[i],
                        orderId + "#" + statusnames[i], messageContent.getBytes(RemotingHelper.DEFAULT_CHARSET));

                SendResult send = producer.getProducer().send(message, orderMessageQuueueSelector, orderId);

                System.out.println(send);
            }
        }

    }

}
