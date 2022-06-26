package de.nullpointerexception.racetaurant.controller;

import de.nullpointerexception.racetaurant.model.Cuisine;
import org.springframework.core.convert.converter.Converter;

public class StringToCuisineConverter implements Converter<String, Cuisine> {
	@Override public Cuisine convert(String source) {
		try {
			return Cuisine.valueOf(source.toUpperCase());
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException(String.format("Invalid cuisine '%s'.", source));
		}
	}
}
