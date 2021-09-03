package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeedemoApplication {

	   @Value("${message}")
	   static String message;
	   
	public static void main(String[] args) {
		
		System.out.println(message);
		SpringApplication.run(EmployeedemoApplication.class, args);
		System.out.println(message);
	}

}
