package com.blog.reactiveapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.netty.NettyReactiveWebServerFactory;
import org.springframework.boot.web.reactive.server.ReactiveWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer;
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator;
import org.springframework.web.reactive.config.EnableWebFlux;

import io.r2dbc.spi.ConnectionFactory;
import reactor.netty.resources.LoopResources;

@SpringBootApplication
@EnableWebFlux
public class ReactiveapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveapiApplication.class, args);
	}

	@Bean
	public ReactiveWebServerFactory reactiveWebServerFactory() {
		NettyReactiveWebServerFactory factory = new NettyReactiveWebServerFactory();
		factory.addServerCustomizers(builder -> builder.runOn(LoopResources.create("my-http", 3, true)));

		return factory;
	}
	
	@Bean
	ConnectionFactoryInitializer databaseInitializer(ConnectionFactory connectionFactory) {
  
	  ConnectionFactoryInitializer connectionInit = new ConnectionFactoryInitializer();
	  connectionInit.setConnectionFactory(connectionFactory);
	  connectionInit.setDatabasePopulator(new ResourceDatabasePopulator(new ClassPathResource("schema.sql")));
  
	  return connectionInit;
	}
}
