package com.thefullstackjourney.spring.hotel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

// Springboot annotation that tells Spring Boot to start the application
// It will try to connect to a database, but we don't have one yet
// So we exclude the DataSourceAutoConfiguration class
// This will allow us to run the application without a database
// The reason it tries to connect to a database is because we added the JPA dependency in the pom.xml file
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class HotelExampleApplication {

	public static void main(String[] args) {
		// This triggers the Spring Boot application
		// the cascade of components scanning (using annotations, metadata for your code)
		// and auto-configuration
		// becomes the main entry point of the application
		SpringApplication.run(HotelExampleApplication.class, args);
	}

}
