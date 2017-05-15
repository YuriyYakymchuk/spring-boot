package com.yuriy.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * Created by yyakymchuk on 5/14/2017.
 */
@Service
@Profile("zolota")
public class PropertyServiceZolotaImpl extends AbstractPropertyService{

	static {
		properties = new Properties();
		InputStream inputStream = null;
		try{
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			inputStream = classLoader.getResourceAsStream("/properties/app-zolota.properties");
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
