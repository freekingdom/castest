package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration
@SpringBootApplication
@MapperScan("com.example.demo.dao")
public class CastestApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(CastestApplication.class, args);
	}

}

