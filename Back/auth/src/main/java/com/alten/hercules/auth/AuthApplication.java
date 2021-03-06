package com.alten.hercules.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import com.alten.hercules.auth.controller.UserController;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@ComponentScan("com.company")
@ComponentScan(basePackageClasses = UserController.class)
public class AuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthApplication.class, args);
	}

}
