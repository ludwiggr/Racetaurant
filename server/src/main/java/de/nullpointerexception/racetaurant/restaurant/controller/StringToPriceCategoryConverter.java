package de.nullpointerexception.racetaurant.restaurant.controller;

import de.nullpointerexception.racetaurant.restaurant.model.PriceCategory;
import org.springframework.core.convert.converter.Converter;

import java.util.Objects;

public class StringToPriceCategoryConverter implements Converter<String, PriceCategory> {
	@Override public PriceCategory convert(String id) {
		Integer idAsInteger;
		try {
			idAsInteger = Integer.parseInt(id);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(
					String.format("Invalid price category '%s'. Valid price categories are 0, 1 and 2.", id));
		}
		for (PriceCategory category : PriceCategory.values()) {
			if (Objects.equals(category.getId(), idAsInteger)) {
				return category;
			}
		}
		throw new IllegalArgumentException(
				String.format("Invalid price category '%s'. Valid price categories are 0, 1 and 2.", id));
	}
}
