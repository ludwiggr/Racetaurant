package de.nullpointerexception.racetaurant.restaurant.controller;

import de.nullpointerexception.racetaurant.restaurant.model.Cuisine;
import org.springframework.core.convert.converter.Converter;

public class StringToCuisineConverter implements Converter<String, Cuisine> {
	@Override public Cuisine convert(String source) {
		try {
			Cuisine result = Cuisine.valueOf(source.toUpperCase());
			return result;
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException(String.format("Invalid cuisine '%s'.", source));
		}

	}
}
