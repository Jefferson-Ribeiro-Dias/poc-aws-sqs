package com.exemplo.jeff.sqs.poc.springbootsqs.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class MessageConsumer {

    public static final String QUEUE = "https://sqs.us-east-1.amazonaws.com/559111842637/MyFIFOQueue.fifo";

    @SqsListener(value = QUEUE,deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
    public void receive(String message){
        log.info("message received {}" , message);
    }
}
