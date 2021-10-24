package com.ts.resident.listener;

import com.ts.resident.model.Localization;
import com.ts.resident.utils.LocalizationKafkaListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

@Component
public class LocalizationListener {

    private static final Logger logger = LoggerFactory.getLogger(LocalizationListener.class);

    @KafkaListener(topics = "topic-1", groupId = "group-1", concurrency = "2")
    public void listen(String message) {
        logger.info("Thread: {} Message: {}", Thread.currentThread().getId(), message);
    }

    @KafkaListener(topicPartitions = {@TopicPartition(topic = "my-topic", partitions = "0")}, groupId = "my-group")
    public void listen2(String message, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
        logger.info("Partition 0: {} Message: {}", partition, message);
    }

    @KafkaListener(topicPartitions = {@TopicPartition(topic = "my-topic", partitions = "1-9")}, groupId = "my-group")
    public void listen3(String message, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
        logger.info("Partition 1-9: {} Message: {}", partition, message);
    }

    @LocalizationKafkaListener(groupId = "group-1")
    public void create(Localization localization) {
        logger.info("Thread: {}", Thread.currentThread().getId());
        logger.info("Criar: {}", localization);
    }
}
