package com.example.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.kafka.annotation.EnableKafka;

@EnableEurekaClient
@ComponentScan(basePackages="com")
@SpringBootApplication
public class OtpServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OtpServiceApplication.class, args);
	}

}
