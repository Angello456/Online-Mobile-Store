package com.placeorderservice.placeorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class PlaceOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlaceOrderApplication.class, args);
	}
	
	

}
