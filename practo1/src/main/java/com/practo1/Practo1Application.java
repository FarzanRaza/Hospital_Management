package com.practo1;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Practo1Application {

	public static void main(String[] args) {
		SpringApplication.run(Practo1Application.class, args);
	}
		@Bean
	public ModelMapper model(){
		return  new ModelMapper();
		}
}
