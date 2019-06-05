package com.lingku;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.mybatis.spring.annotation.MapperScan;
@SpringBootApplication
@EnableAutoConfiguration
@MapperScan("com.lingku.*")
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
