package com.poc.temperature.conversion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class TemperatureConversionApplication {

	public static void main(String[] args) {
		SpringApplication.run(TemperatureConversionApplication.class, args);
	}

}
