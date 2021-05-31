package com.kafka;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Properties;

/**
 * @author junlin_huang
 * @create 2021-06-01 4:07 AM
 **/

public class ProducerDemo {

    private Properties properties;

    private KafkaProducer producer;

    public ProducerDemo() {
        properties = new Properties();
        properties.put("bootstrap.servers", "localhost:9092");
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        producer = new KafkaProducer(properties);
    }


    public static void main(String[] args) throws InterruptedException {
        ProducerDemo producerDemo = new ProducerDemo();
        producerDemo.fireAndForget();
        producerDemo.sendMsgSync();
        producerDemo.sendMsgAsync();
        //让异步发送有机会完成
        Thread.sleep(3000);
    }

    public void fireAndForget() {
        ProducerRecord<String, String> record = new ProducerRecord<String, String>("topic", "key", "value");
        producer.send(record);

    }

    public void sendMsgSync() {
        ProducerRecord<String, String> record = new ProducerRecord<String, String>("topic", "key1", "value1");
        try {
            RecordMetadata recordMetadata = (RecordMetadata) producer.send(record).get();
            System.out.println("send sync return:" + recordMetadata);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void sendMsgAsync() {
        ProducerRecord<String, String> record = new ProducerRecord<String, String>("topic", "key2", "value2");
        try {
            producer.send(record, new Callback() {
                public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                    if(e != null) {
                        e.printStackTrace();
                    }
                    System.out.println("send async return:" + recordMetadata);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}