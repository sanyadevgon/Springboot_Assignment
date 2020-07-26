package com.Springboot.EAMS.util;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.listener.ConsumerAwareErrorHandler;

import java.util.List;

public interface RmainingRecordsErrorHandler extends ConsumerAwareErrorHandler {
    void handle (Exception thrownException, List<ConsumerRecord<?,?>> records, Consumer<?,?> consumer);
}
