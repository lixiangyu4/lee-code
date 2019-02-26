package com.lixiangyu.lee.queue.rocketmq.transaction;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.apache.rocketmq.client.producer.TransactionListener;
import org.apache.rocketmq.client.producer.TransactionMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @program: member-service
 * @description:
 * @author: lixiangyu
 * @create: 2019-02-22 17:09
 **/
public class TransactionProducer {

    private static final Logger logger = LoggerFactory.getLogger(TransactionProducer.class);

    public static void main(String[] args) throws MQClientException {

        TransactionMQProducer producer = new TransactionMQProducer("transaction_producer_group");
        producer.setNamesrvAddr("127.0.0.1:9876");

        ExecutorService executorService = new ThreadPoolExecutor(2, 5, 100, TimeUnit.SECONDS, new ArrayBlockingQueue<>(2000), new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setName("client-transaction-msg-chect-thread");
                return thread;
            }
        });
        //设置本地事务执行的线程池 rocketmq client-4.3版本及以上
        producer.setExecutorService(executorService);

        producer.setTransactionListener(new TransactionListener() {
            @Override
            public LocalTransactionState executeLocalTransaction(Message message, Object o) {
                //本地事务处理逻辑
                logger.info("本地事务执行。。。");
                logger.info("消息标签是: " + message.getTags());
                logger.info("消息内容是: " + new String(message.getBody()));
                String tag = message.getTags();
                if(tag.equals("Transaction1")) {
                    //Transaction1，则返回事务失败标记
                    logger.info("模拟本地事务执行失败");
                    //表示本地事务执行失败，当事务执行失败时需要返回ROLLBACK
                    return LocalTransactionState.ROLLBACK_MESSAGE;
                }
                logger.info("模拟本地事务执行成功");

                return LocalTransactionState.COMMIT_MESSAGE;
            }

            @Override
            public LocalTransactionState checkLocalTransaction(MessageExt messageExt) {
                logger.info("消息服务器调用消息回查接口");
                logger.info("消息标签是: " + messageExt.getTags());
                logger.info("消息内容是: " + new String(messageExt.getBody()));
                return LocalTransactionState.COMMIT_MESSAGE;
            }
        });

        producer.start();

        

    }


}
