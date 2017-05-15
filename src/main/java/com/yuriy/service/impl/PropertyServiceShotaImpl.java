package com.yuriy.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * Created by yyakymchuk on 5/9/2017.
 */
@Service
@Profile("shota")
public class PropertyServiceShotaImpl extends AbstractPropertyService {

	private static final Logger logger = LoggerFactory.getLogger(PropertyServiceShotaImpl.class);

	static {
		properties = new Properties();
		InputStream inputStream = null;
		try{
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			inputStream = classLoader.getResourceAsStream("/properties/app-shota.properties");
			properties.load(inputStream);
		} catch (IOException io) {
			System.out.println("Couldn't load property file");
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}


}
