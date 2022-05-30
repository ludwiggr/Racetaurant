package de.nullpointerexception.racetaurant.restaurant.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.CustomConversions;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@Configuration public class Converters implements WebMvcConfigurer {

	@Override public void addFormatters(FormatterRegistry registry) {
		registry.addConverter(new StringToCuisineConverter());
		registry.addConverter(new StringToOrderConverter());
		registry.addConverter(new StringToPriceCategoryConverter());
	}
}
