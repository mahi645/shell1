package com.axis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringBootRestProductTableApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestProductTableApplication.class, args);
	}

}
