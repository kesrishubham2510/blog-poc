package com.blog.reactiveapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.config.EnableWebFlux;

import io.netty.channel.nio.NioEventLoopGroup;

@SpringBootApplication
@EnableWebFlux
public class ReactiveapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveapiApplication.class, args);
	}

	@Bean
	public NioEventLoopGroup eventLoopGroup(){
		return new NioEventLoopGroup(3);
	}
}
