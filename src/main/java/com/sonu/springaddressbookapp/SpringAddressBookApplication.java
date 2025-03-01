package com.sonu.springaddressbookapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.sonu.springaddressbookapp.repository")
public class SpringAddressBookApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAddressBookApplication.class, args);
	}
}
