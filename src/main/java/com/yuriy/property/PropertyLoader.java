package com.yuriy.property;

import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by yyakymchuk on 5/9/2017.
 */
@Component
@PropertySource("classpath:properties/app-shota.properties")
public class PropertyLoader {

}
