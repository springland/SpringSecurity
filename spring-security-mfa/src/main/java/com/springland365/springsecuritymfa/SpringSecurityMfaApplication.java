package com.springland365.springsecuritymfa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@ComponentScan

public class SpringSecurityMfaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityMfaApplication.class, args);
	}

}
