package com.yuriy.service.impl;

import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yuriy.service.PropertyService;

/**
 * Created by yyakymchuk on 5/14/2017.
 */
public abstract class AbstractPropertyService implements PropertyService{

	private static final Logger logger = LoggerFactory.getLogger(AbstractPropertyService.class);

	protected static Properties properties;


	@Override
	public String getProperty(final String name) {
		final String propertyValue = properties.getProperty(name);
		if(StringUtils.isEmpty(propertyValue)) {
			throw new IllegalArgumentException(String.format("Property % doesn't exist", name));
		}
		logger.debug("Retrieved property {}", propertyValue);
		return propertyValue;
	}
}
