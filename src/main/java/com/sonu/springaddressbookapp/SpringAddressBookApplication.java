package com.sonu.springaddressbookapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.sonu.springaddressbookapp.Repository")
public class SpringAddressBookApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAddressBookApplication.class, args);
	}

}
