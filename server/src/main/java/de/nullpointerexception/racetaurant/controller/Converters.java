package de.nullpointerexception.racetaurant.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration public class Converters implements WebMvcConfigurer {

	@Override public void addFormatters(FormatterRegistry registry) {
		registry.addConverter(new StringToCuisineConverter());
		registry.addConverter(new StringToOrderConverter());
		registry.addConverter(new StringToPriceCategoryConverter());
		registry.addConverter(new StringToLayoutObjectTypeConverter());
	}
}
