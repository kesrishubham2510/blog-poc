package com.blog.requestor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class RequestorApplication {

	public static void main(String[] args) {
		SpringApplication.run(RequestorApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(){
        log.info("Requestor Service instantiated....");
		return new RestTemplate();
	}
}
