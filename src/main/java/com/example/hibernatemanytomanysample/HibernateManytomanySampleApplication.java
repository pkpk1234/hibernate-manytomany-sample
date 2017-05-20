package com.example.hibernatemanytomanysample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
//@EnableTransactionManagement //Spring Boot auto add a transaction manager
public class HibernateManytomanySampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateManytomanySampleApplication.class, args);
	}
}
