package com.blog.mvcapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.blog.*")
@ComponentScan(basePackages = { "com.blog.*" })
@EntityScan("com.blog.*")   
public class MvcapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MvcapiApplication.class, args);
	}
}
