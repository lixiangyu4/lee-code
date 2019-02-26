package com.lixiangyu.lee.queue.rocketmq.order;

import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;

import java.util.List;

/**
 * @program: member-service
 * @description:
 * @author: lixiangyu
 * @create: 2019-02-21 21:55
 **/
public class OrderMessageQueueSelector implements MessageQueueSelector {
    @Override
    public MessageQueue select(List<MessageQueue> list, Message message, Object orderId) {
        Integer id = (Integer) orderId;
        return list.get(id % list.size());
    }
}
