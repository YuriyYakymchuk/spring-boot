package com.yuriy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.base.Preconditions;
import com.yuriy.service.PropertyService;

/**
 * Created by yyakymchuk on 5/6/2017.
 */
@RestController
@RequestMapping("/hello")
public class HelloWordController {

	final private PropertyService propertyService;

	@Autowired
	public HelloWordController(final PropertyService propertyService) {
		Preconditions.checkArgument(propertyService != null);

		this.propertyService = propertyService;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/word")
	@ResponseStatus(HttpStatus.OK)
	public String getMessage() {
		return "I am a man";
	}

}
