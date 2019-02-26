package com.lixiangyu.lee.queue.rocketmq.order;

import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerOrderly;
import org.apache.rocketmq.common.message.MessageExt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @program: member-service
 * @description:
 * @author: lixiangyu
 * @create: 2019-02-21 22:36
 **/
public class OrderMessageListener implements MessageListenerOrderly {

    private static final Logger logger = LoggerFactory.getLogger(OrderMessageListener.class);

    @Override
    public ConsumeOrderlyStatus consumeMessage(List<MessageExt> list, ConsumeOrderlyContext consumeOrderlyContext) {

        if(null != list) {
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            logger.info(LocalDateTime.now().format(timeFormatter) + " 接受到消息: ");

            for (MessageExt ext : list) {
                try {
                    logger.info(LocalDateTime.now().format(timeFormatter) + " 消息内容: " + new String(ext.getBody(), "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }
        return ConsumeOrderlyStatus.SUCCESS;
    }
}
