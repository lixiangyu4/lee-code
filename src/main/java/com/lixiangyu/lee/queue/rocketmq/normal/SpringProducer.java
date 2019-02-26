package com.lixiangyu.lee.queue.rocketmq.normal;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @program: member-service
 * @description: rocketmq生产者
 * @author: lixiangyu
 * @create: 2019-02-21 16:08
 **/
public class SpringProducer {

    private static final Logger logger = LoggerFactory.getLogger(SpringProducer.class);

    private String producerGroupName;
    private String nameServerAddr;
    private DefaultMQProducer producer;

    public SpringProducer(String producerGroupName, String nameServerAddr) {
        this.producerGroupName = producerGroupName;
        this.nameServerAddr = nameServerAddr;
    }

    public DefaultMQProducer getProducer() {
        return producer;
    }

    @PostConstruct
    public void init() throws MQClientException {
        producer = new DefaultMQProducer(producerGroupName);
        producer.setNamesrvAddr(nameServerAddr);
        producer.start();
    }

    @PreDestroy
    public void destory() {
        producer.shutdown();
    }

}
