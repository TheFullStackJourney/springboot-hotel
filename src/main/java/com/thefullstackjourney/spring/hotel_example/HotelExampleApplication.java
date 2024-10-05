package com.thefullstackjourney.spring.hotel_example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Springboot annotation that tells Spring Boot to start the application
// It will auto configure the JPA as its dependency is in the pom.xml file
@SpringBootApplication
public class HotelExampleApplication {

	public static void main(String[] args) {
		// This triggers the Spring Boot application
		// the cascade of components scanning (using annotations, metadata for your code)
		// and auto-configuration
		// becomes the main entry point of the application
		SpringApplication.run(HotelExampleApplication.class, args);
	}

}
