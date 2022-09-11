package com.springland365.springsecuritymfa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class SpringSecurityMfaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityMfaApplication.class, args);
	}

}
