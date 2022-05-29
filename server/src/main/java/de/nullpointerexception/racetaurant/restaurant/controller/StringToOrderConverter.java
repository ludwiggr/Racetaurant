package de.nullpointerexception.racetaurant.restaurant.controller;

import de.nullpointerexception.racetaurant.restaurant.model.Order;
import org.springframework.core.convert.converter.Converter;

public class StringToOrderConverter implements Converter<String, Order> {
	@Override public Order convert(String source) {
		try {
			Order result = Order.valueOf(source.toUpperCase());
			return result;
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException(String.format("Invalid order '%s'.", source));
		}
	}
}
