package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ComponentScan({ "com.example.demo"}) 

public class PafClient2Application {

	public static void main(String[] args) {
		SpringApplication.run(PafClient2Application.class, args);
	}

	
	@Bean
	   public RestTemplate restTemplate() {
	      return new RestTemplate();
	   }

}
