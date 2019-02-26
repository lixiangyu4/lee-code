package com.lixiangyu.lee.queue.rocketmq.normal;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
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
 * @create: 2019-02-21 16:19
 **/
public class SpringConsumer {

    private static final Logger logger = LoggerFactory.getLogger(SpringConsumer.class);


    private String consumerGroupName;
    private String nameServerAddr;
    private String topicName;
    private DefaultMQPushConsumer consumer;
    /**
     * 普通消息
     */
    private MessageListenerConcurrently messageListener;

    public SpringConsumer(String consumerGroupName, String nameServerAddr, String topicName, MessageListenerConcurrently messageListener) {
        this.consumerGroupName = consumerGroupName;
        this.nameServerAddr = nameServerAddr;
        this.topicName = topicName;
        this.messageListener = messageListener;
    }

    @PostConstruct
    public void init() throws MQClientException {
        consumer = new DefaultMQPushConsumer(consumerGroupName);
        consumer.setNamesrvAddr(nameServerAddr);
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
        consumer.subscribe(topicName, "*");
        consumer.registerMessageListener(messageListener);
        consumer.start();

    }

    @PreDestroy
    public void destory() {
        consumer.shutdown();
    }

}
