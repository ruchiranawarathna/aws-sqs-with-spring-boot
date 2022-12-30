package com.example.sqs.receiver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AwsSqsMessageReceiverApplication {

	public static void main(String[] args) {
		SpringApplication.run(AwsSqsMessageReceiverApplication.class, args);
	}

}
