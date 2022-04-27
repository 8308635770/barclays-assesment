package com.baclays.assignment;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BarclaysAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(BarclaysAssignmentApplication.class, args);
	}
	
	@Bean
	public ModelMapper getModelMApper() {
		return new ModelMapper();
	}

}
