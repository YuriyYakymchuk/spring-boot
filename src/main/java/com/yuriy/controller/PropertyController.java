package com.yuriy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yuriy.property.bean.DogeSettings;
import com.yuriy.service.PropertyService;

/**
 * Created by yyakymchuk on 5/13/2017.
 */
@RestController
@RequestMapping("/property")
@PropertySource(value = "classpath:properties/app-shota.properties")
public class PropertyController {

	private final String randomProperty;

	private final String staticProperty;

	private final PropertyService propertyService;

	private final DogeSettings dogeSettings;

	@Autowired
	public PropertyController(@Value("${random.uuid}") final String randomProperty, @Value("${property.static}") final String staticProperty,
		final PropertyService propertyService, final DogeSettings dogeSettings) {
		this.randomProperty = randomProperty;
		this.propertyService = propertyService;
		this.staticProperty = staticProperty;
		this.dogeSettings = dogeSettings;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String getProperty(@RequestParam final String name) {
		return propertyService.getProperty(name);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/random")
	public String getRandomProperty() {
		return randomProperty;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/static")
	public String getStaticProperty() {
		return staticProperty;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/configuration/{type}")
	public Object getConfigurationProperty(@PathVariable final String type) {
		if (type == null) {
			return null;
		}
		switch (type) {
			case "name":
			{
				return dogeSettings.getName();
			}
			case "surname":
			{
				return dogeSettings.getSurname();
			}
			case "year":
			{
				return dogeSettings.getYear();
			}
			default:
			{
				throw new IllegalArgumentException("Wrong property type");
			}
		}
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<Object> handleException(IllegalArgumentException ex) {
		return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}


}
