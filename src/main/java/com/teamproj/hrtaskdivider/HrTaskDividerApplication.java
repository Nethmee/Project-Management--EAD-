package com.teamproj.hrtaskdivider;

import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableJpaAuditing
public class HrTaskDividerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrTaskDividerApplication.class, args);
	}

}
