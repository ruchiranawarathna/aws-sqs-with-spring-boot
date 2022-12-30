package com.example.sqs.sender;

import com.amazonaws.services.sqs.AmazonSQSAsync;
import io.awspring.cloud.messaging.core.QueueMessagingTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AwsSqsMessageSenderApplication {

	public static void main(String[] args) {
		SpringApplication.run(AwsSqsMessageSenderApplication.class, args);
	}

	@Bean
	public QueueMessagingTemplate queueMessagingTemplate(
			AmazonSQSAsync amazonSQSAsync) {
		return new QueueMessagingTemplate(amazonSQSAsync);
	}
}
