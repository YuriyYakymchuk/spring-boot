package com.yuriy.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * Created by yyakymchuk on 5/7/2017.
 */
@SpringBootApplication(scanBasePackages = "com.yuriy.*")
public class ApplicationInitializer {

	protected SpringApplicationBuilder configure(final SpringApplicationBuilder builder) {
		return builder.sources(ApplicationInitializer.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(ApplicationInitializer.class, args);
	}

}
