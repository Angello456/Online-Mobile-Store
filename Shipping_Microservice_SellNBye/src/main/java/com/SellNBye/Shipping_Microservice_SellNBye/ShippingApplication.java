package com.SellNBye.Shipping_Microservice_SellNBye;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication //mark this class as spring boot application
@EnableJpaAuditing
public class ShippingApplication {

		public static void main(String[] args) {
			SpringApplication.run(ShippingApplication.class, args);
		}

}
