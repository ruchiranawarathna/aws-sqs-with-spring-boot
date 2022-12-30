package com.example.sqs.sender.service;

import com.amazonaws.services.sqs.AmazonSQSAsync;
import io.awspring.cloud.messaging.core.QueueMessageChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class MessageSender {
    @Value("${cloud.aws.sqs.endpoint}")
    private String sqsUriEndpoint;

    @Autowired
    private final AmazonSQSAsync amazonSqs;

    @Autowired
    public MessageSender(final AmazonSQSAsync amazonSQSAsync) {
        this.amazonSqs = amazonSQSAsync;
    }

    public boolean send(final String messagePayload) {
        MessageChannel messageChannel
                = new QueueMessageChannel(amazonSqs, sqsUriEndpoint);

        Message<String> msg = MessageBuilder.withPayload(messagePayload)
                .setHeader("sender", "aws-sqs-message-sender-app")
                .setHeaderIfAbsent("country", "LK")
                .build();

        long waitTimeoutMillis = 5000;
        boolean sentStatus = messageChannel.send(msg,waitTimeoutMillis);
        return sentStatus;
    }
}
