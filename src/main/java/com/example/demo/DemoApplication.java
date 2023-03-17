package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableConfigurationProperties
@EnableJpaRepositories("com.example.demo.repository")
@EntityScan("com.example.demo.entity")
public class DemoApplication {

	private static ConfigurableApplicationContext applicationContext;
	public static void main(String[] args) {
		// SpringApplication.run(DemoApplication.class, args);
		DemoApplication.applicationContext = SpringApplication.run(DemoApplication.class, args);


	}

}
