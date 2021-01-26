package com.naresh.springbootrestapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@EnableJpaAuditing
@EnableAutoConfiguration
@SpringBootApplication(scanBasePackages={
"com.naresh.springbootrestapi", "com.naresh.springbootrestapi.repository"})
@ComponentScan("com.naresh.springbootrestapi.repository")
public class AccountApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(AccountApplication.class, args);
	}
}
