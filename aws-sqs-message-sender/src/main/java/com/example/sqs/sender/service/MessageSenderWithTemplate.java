package com.example.sqs.sender.service;

import io.awspring.cloud.messaging.core.QueueMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class MessageSenderWithTemplate {
    @Autowired
    private QueueMessagingTemplate messagingTemplate;

    public void send(final String queueName,final String messagePayload) {

        Message<String> msg = MessageBuilder.withPayload(messagePayload)
                .setHeader("sender", "aws-sqs-message-sender-app")
                .setHeaderIfAbsent("country", "LK")
                .build();

        messagingTemplate.convertAndSend(queueName, msg);
    }
}
