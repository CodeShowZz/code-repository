package com.rocketmq.basic;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

/**
 * @author junlin_huang
 * @create 2021-06-01 12:45 PM
 **/

public class ProducerDemo {

    DefaultMQProducer producer;

    public static void main(String[] args) throws Exception {
        ProducerDemo producerDemo = new ProducerDemo();
        producerDemo.start();
        producerDemo.sendOneWay();
        producerDemo.sendSync();
        producerDemo.sendAsync();
        producerDemo.shutdown();
    }

    public ProducerDemo() throws Exception {
        producer = new DefaultMQProducer("group");
        producer.setNamesrvAddr("localhost:9876");
        producer.setSendMsgTimeout(10000);
    }

    public void start() throws MQClientException {
        producer.start();
    }

    public void shutdown() {
        producer.shutdown();
    }

    public void sendOneWay() throws Exception{
        for(int i =0;i<100;i++) {
            Message msg = new Message("topic","tag",("oneway-body" + i).getBytes(RemotingHelper.DEFAULT_CHARSET));
            producer.sendOneway(msg);
        }
    }

    public void sendSync() throws Exception {
        for(int i =0;i<100;i++) {
            Message msg = new Message("topic","tag",("sync-body" + i).getBytes(RemotingHelper.DEFAULT_CHARSET));
            SendResult sendResult = producer.send(msg);
            System.out.printf("sync result-%s%n", sendResult);
        }
    }

    public void sendAsync() throws Exception{
        producer.setRetryTimesWhenSendAsyncFailed(0);
        int messageCount = 100;
        for(int i = 0 ;i<messageCount;i++) {
            final int index = i;
            Message msg = new Message("topic","tag",("async-body" + i).getBytes(RemotingHelper.DEFAULT_CHARSET));
            producer.send(msg, new SendCallback() {
                public void onSuccess(SendResult sendResult) {
                    System.out.printf("async result- %-10d OK %s %n", index,
                            sendResult.getMsgId());
                }

                public void onException(Throwable e) {
                    System.out.printf("%-10d Exception %s %n", index, e);
                    e.printStackTrace();
                }
            });
        }
        //等待三秒
        Thread.sleep(3000);
    }


}