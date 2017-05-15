package com.yuriy.property.bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

/**
 * Created by yyakymchuk on 5/13/2017.
 */
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "man")
@Validated
public class DogeSettings {

	@NotBlank
	private String name;
	@NotNull
	private String surname;
	private int year;

	public DogeSettings() {
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(final String surname) {
		this.surname = surname;
	}

	public int getYear() {
		return year;
	}

	public void setYear(final int year) {
		this.year = year;
	}
}
