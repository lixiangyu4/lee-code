package com.lixiangyu.lee.queue.rocketmq.order;

/**
 * @program: member-service
 * @description:
 * @author: lixiangyu
 * @create: 2019-02-21 21:51
 **/
public class OrderMessage {


    private int id;

    private String status;

    private int sendOrder;

    private String content;

    public int getId() {
        return id;
    }

    public OrderMessage setId(int id) {
        this.id = id;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public OrderMessage setStatus(String status) {
        this.status = status;
        return this;
    }

    public int getSendOrder() {
        return sendOrder;
    }

    public OrderMessage setSendOrder(int sendOrder) {
        this.sendOrder = sendOrder;
        return this;
    }

    public String getContent() {
        return content;
    }

    public OrderMessage setContent(String content) {
        this.content = content;
        return this;
    }

    @Override
    public String toString() {
        return "订单消息{" +
                "订单ID=" + id +
                ", 订单状态='" + status + '\'' +
                ", 发送顺序=" + sendOrder +
                ", 订单内容='" + content + '\'' +
                '}';
    }

}
