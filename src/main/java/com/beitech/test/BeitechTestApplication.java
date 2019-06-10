package com.beitech.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.beitech.test.repository.CustomerRepository;

@SpringBootApplication
public class BeitechTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeitechTestApplication.class, args);
	}

}
