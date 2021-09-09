package com.example.demo;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class EmployeedemoApplication {

//	   @Value("${message}")
//	   static String message;
//	   
	public static void main(String[] args) {
		
		SpringApplication.run(EmployeedemoApplication.class, args);
	}
	@GetMapping("/getip")
	public String getIp() throws UnknownHostException
	{
		InetAddress ip = InetAddress.getLocalHost();
		//log.info(" From host: " + ip);
		System.out.println(" From host: " + ip);
	        return " From host: " + ip;
	}

}
