package de.nullpointerexception.racetaurant.controller;

import de.nullpointerexception.racetaurant.model.LayoutObjectType;
import org.springframework.core.convert.converter.Converter;

import java.util.Objects;

public class StringToLayoutObjectTypeConverter implements Converter<String, LayoutObjectType> {
	@Override public LayoutObjectType convert(String source) {
		for (LayoutObjectType type : LayoutObjectType.values()) {
			if (Objects.equals(type.getId(), source)) {
				return type;
			}
		}
		throw new IllegalArgumentException(String.format("Invalid layout object type '%s'.", source));
	}
}
