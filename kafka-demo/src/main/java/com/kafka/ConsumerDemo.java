package com.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.Properties;

/**
 * @author junlin_huang
 * @create 2021-06-01 4:07 AM
 **/

public class ConsumerDemo {

    private Properties properties;

    private KafkaConsumer consumer;

    Logger log = LoggerFactory.getLogger(ConsumerDemo.class);

    public ConsumerDemo() {
        properties = new Properties();
        properties.put("bootstrap.servers", "localhost:9092");
        properties.put("group.id", "group");
        properties.put("enable.auto.commit", false);
        properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        consumer = new KafkaConsumer(properties);
        consumer.subscribe(Collections.singletonList("topic"));
    }

    public void consumeAndCommitOffsetSync() {
        try {
            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(100);
                for (ConsumerRecord record : records) {
                    System.out.printf("topic = %s,partition = %s,offset = %d,key = %s,value = %s",
                            record.topic(), record.partition(), record.offset(), record.key(), record.value());
                    System.out.println();
                }
                try {
                    consumer.commitSync();
                } catch (Exception e) {
                    log.info("commit falied", e);
                }
            }
        } finally {
            consumer.close();
        }
    }

    public void consumeAndCommitOffsetAsync() {
        try {
            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(100);
                for (ConsumerRecord record : records) {
                    System.out.printf("topic = %s,partition = %s,offset = %d,key = %s,value = %s",
                            record.topic(), record.partition(), record.offset(), record.key(), record.value());
                    System.out.println();
                }
                try {
                    consumer.commitAsync();
                } catch (Exception e) {
                    log.info("commit falied", e);
                }
            }
        } finally {
            consumer.close();
        }
    }

    public void compositeSyncAndAsyncCommit() {
        try {
            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(100);
                for (ConsumerRecord record : records) {
                    System.out.printf("topic = %s,partition = %s,offset = %d,key = %s,value = %s",
                            record.topic(), record.partition(), record.offset(), record.key(), record.value());
                    System.out.println();
                }
                try {
                    consumer.commitAsync();
                } catch (Exception e) {
                    log.info("commit falied", e);
                }
            }
        } finally {
            try {
                consumer.commitSync();
            } finally {
            consumer.close();
        }
    }
}


    public static void main(String[] args) throws InterruptedException {
        ConsumerDemo consumerDemo = new ConsumerDemo();
        consumerDemo.compositeSyncAndAsyncCommit();
    }


}