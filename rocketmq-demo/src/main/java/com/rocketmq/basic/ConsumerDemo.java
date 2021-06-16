package com.rocketmq.basic;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

/**
 * @author junlin_huang
 * @create 2021-06-01 5:34 PM
 **/

public class ConsumerDemo {

    DefaultMQPushConsumer consumer;

    public static void main(String[] args) throws MQClientException {
        ConsumerDemo consumerDemo = new ConsumerDemo();
        consumerDemo.consume();
    }

    public ConsumerDemo() throws MQClientException {
        consumer = new DefaultMQPushConsumer("group1");
        consumer.setNamesrvAddr("localhost:9876");
        consumer.subscribe("orderTopic", "*");
    }


    public void consume() throws MQClientException {
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
                for (MessageExt messageExt : msgs) {
                    System.out.println("consumer:" + new String(messageExt.getBody()));
                }
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        System.out.printf("Consumer Started.%n");
        consumer.start();
    }


}