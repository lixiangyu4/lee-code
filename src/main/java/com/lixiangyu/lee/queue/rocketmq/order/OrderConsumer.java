package com.lixiangyu.lee.queue.rocketmq.order;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.MessageListenerOrderly;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @program: member-service
 * @description:
 * @author: lixiangyu
 * @create: 2019-02-21 23:37
 **/
public class OrderConsumer {

    private static final Logger logger = LoggerFactory.getLogger(OrderConsumer.class);

    private String consumerGroupName;
    private String nameServerAddr;
    private String topicName;
    private DefaultMQPushConsumer consumer;
    /**
     * 顺序消息
     */
    private MessageListenerOrderly messageListenerOrderly;

    public OrderConsumer(String consumerGroupName, String nameServerAddr, String topicName, MessageListenerOrderly messageListenerOrderly) {
        this.consumerGroupName = consumerGroupName;
        this.nameServerAddr = nameServerAddr;
        this.topicName = topicName;
        this.messageListenerOrderly = messageListenerOrderly;
    }

    @PostConstruct
    public void init() throws MQClientException {
        consumer = new DefaultMQPushConsumer(consumerGroupName);
        consumer.setNamesrvAddr(nameServerAddr);
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
        consumer.subscribe(topicName, "*");
        consumer.registerMessageListener(messageListenerOrderly);
        consumer.start();

    }

    @PreDestroy
    public void destory() {
        consumer.shutdown();
    }

}
