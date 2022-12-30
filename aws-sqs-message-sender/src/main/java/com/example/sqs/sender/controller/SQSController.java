package com.example.sqs.sender.controller;

import com.example.sqs.sender.service.MessageSender;
import com.example.sqs.sender.service.MessageSenderWithTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SQSController {

    @Autowired
    private MessageSenderWithTemplate messageSenderWithTemplate;

    @Autowired
    private MessageSender messageSender;

    @GetMapping("/publish/{msg}")
    public void publishMessageToQueue(@PathVariable("msg") String message) {
        System.out.println("Publish Message: " + message);
        //send message with QueueMessagingTemplate
        messageSenderWithTemplate.send("order-queue", (message + " from message sender template"));
        //send message without QueueMessagingTemplate
        messageSender.send(message + " from message sender");
    }
}
