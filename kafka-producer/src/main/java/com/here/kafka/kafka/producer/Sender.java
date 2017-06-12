package com.here.kafka.kafka.producer;

import com.here.kafka.model.Data;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.logging.Logger;

/**
 * Created by risingh on 5/28/17.
 */
@Component
public class Sender {
    @Autowired
    private KafkaTemplate<String, Data> kafkaTemplate;
    org.slf4j.Logger logger = LoggerFactory.getLogger(Sender.class);


    public void send(String topic, Data data){
        ListenableFuture<SendResult<String, Data>> future = kafkaTemplate.send(topic, data);

        future.addCallback(new ListenableFutureCallback<SendResult<String, Data>>() {
            @Override
            public void onFailure(Throwable throwable) {

            }

            @Override
            public void onSuccess(SendResult<String, Data> stringStringSendResult) {
                stringStringSendResult.getRecordMetadata().offset();
                logger.info("success !");
            }
        });


    }

}
