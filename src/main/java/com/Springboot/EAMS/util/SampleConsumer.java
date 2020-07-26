package com.Springboot.EAMS.util;


//import io.confluent.kafka.serializers.AbstractKafkaAvroSerDeConfig;
     //   import io.confluent.kafka.serializers.subject.TopicRecordNameStrategy;
        //import io.confluent.kafka.serializers.KafkaAvroDeserializer;
//   import io.confluent.kafka.serializers.KafkaAvroDeserializerConfig;

public class SampleConsumer {

    private static final String TOPIC = "payment";
/*
    @SuppressWarnings("InfiniteLoopStatement")
    public void Consume() {
        final Properties props = new Properties();
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "false");
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "my-consumer");
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, KafkaAvroDeserializer.class);
        props.put(ConsumerConfig.MAX_POLL_INTERVAL_MS_CONFIG, 100000);
        props.put(AbstractKafkaAvroSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, "http://localhost:8081");
        props.put(KafkaAvroDeserializerConfig.SPECIFIC_AVRO_READER_CONFIG, true);
        props.put(KafkaAvroDeserializerConfig.KEY_SUBJECT_NAME_STRATEGY, TopicRecordNameStrategy.class.getName());
        props.put(KafkaAvroDeserializerConfig.VALUE_SUBJECT_NAME_STRATEGY, TopicRecordNameStrategy.class.getName());

        *//* Sadly, we need to do some string parsing to deal with 'poison pill' records (i.e. any message that cannot be
        de-serialized by KafkaAvroDeserializer, most likely because they weren't produced using Schema Registry) so we
        need to set up some regex things
         *//*
        final Pattern offsetPattern = Pattern.compile("\\w*offset*\\w[ ]\\d+");
        final Pattern partitionPattern = Pattern.compile("\\w*" + TOPIC + "*\\w[-]\\d+");

        KafkaConsumer<String, LoanCreated> consumer =  new KafkaConsumer<>(props);
        consumer.subscribe(Collections.singletonList(TOPIC));

        // Consume messages
        while (true) {
            try {
                final ConsumerRecords<String, LoanCreated> records = consumer.poll(Duration.ofMillis(1));
                for (final ConsumerRecord<String, LoanCreated> record : records) {
                    final String key = record.key();
                    try {
                        *//* A record can be successfully de-serialized, but is not coercable into the type we need. In
                        the case of this example, we're looking for LoanCreated records, but we are also producing
                        Payment records. *//*
                        final LoanCreated value = record.value();
                        System.out.printf("key = %s, value = %s%n", key, value);
                        // do work here
                    } catch (ClassCastException e) {
                        System.out.println("Record is not the specified type ... skipping");
                    }
                }
                consumer.commitSync();
            } catch (SerializationException e) {
                String text = e.getMessage();
                // Parse the error message to get the partition number and offset, in order to `seek` past the poison pill.
                Matcher mPart = partitionPattern.matcher(text);
                Matcher mOff = offsetPattern.matcher(text);

                mPart.find();
                Integer partition = Integer.parseInt(mPart.group().replace(TOPIC + "-", ""));
                mOff.find();
                Long offset = Long.parseLong(mOff.group().replace("offset ", ""));
                System.out.println(String.format(
                        "'Poison pill' found at partition {0}, offset {1} .. skipping", partition, offset));
                consumer.seek(new TopicPartition(TOPIC, partition), offset + 1);
                // Continue on
            }
        }
    }*/
}
