package com.rocketmq.order;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.*;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author junlin_huang
 * @create 2021-06-01 5:34 PM
 **/

public class OrderConsumerDemo {

    DefaultMQPushConsumer consumer;

    public static void main(String[] args) throws MQClientException {
        OrderConsumerDemo consumerDemo = new OrderConsumerDemo();
        consumerDemo.consumeOrderly();
    }

    public OrderConsumerDemo() throws MQClientException {
        consumer = new DefaultMQPushConsumer("group1");
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
        consumer.setNamesrvAddr("localhost:9876");
        consumer.subscribe("orderTopic", "TagA || TagC || TagD");
    }


    public void consumeOrderly() throws MQClientException {
        consumer.registerMessageListener(new MessageListenerOrderly() {
            public ConsumeOrderlyStatus consumeMessage(List<MessageExt> msgs, ConsumeOrderlyContext context) {
                context.setAutoCommit(true);
                for(MessageExt msg : msgs) {
                    System.out.println("consumeThread=" + Thread.currentThread().getName() + "queueId=" +
                            msg.getQueueId() + ", content:" + new String(msg.getBody()));
                }
                return ConsumeOrderlyStatus.SUCCESS;
            }
        });
        consumer.start();
        System.out.println("Consumer Started.");

    }


}