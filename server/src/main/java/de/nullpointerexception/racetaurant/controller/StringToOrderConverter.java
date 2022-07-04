package de.nullpointerexception.racetaurant.controller;

import org.springframework.core.convert.converter.Converter;

import de.nullpointerexception.racetaurant.model.Order;

public class StringToOrderConverter implements Converter<String, Order> {
	@Override
	public Order convert(String source) {
		try {
			return Order.valueOf(source.toUpperCase());
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException(String.format("Invalid order '%s'.", source));
		}
	}
}
