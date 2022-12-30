package com.example.sqs.receiver.service;

import io.awspring.cloud.messaging.listener.SqsMessageDeletionPolicy;
import io.awspring.cloud.messaging.listener.annotation.SqsListener;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class SQSMessageListener {
    @SqsListener(value = "order-queue", deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
    public void loadPaymentMessageFromQueue(String message, @Headers Map<String, Object> payloadHeaders) {
        System.out.println("Queue Message: " + message);
        System.out.println("Sender: " + payloadHeaders.get("sender"));
    }
}
