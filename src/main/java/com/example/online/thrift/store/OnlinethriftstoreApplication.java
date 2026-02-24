package com.example.online.thrift.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class OnlinethriftstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlinethriftstoreApplication.class, args);
	}

}
