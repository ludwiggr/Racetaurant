package de.nullpointerexception.racetaurant.restaurant.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Cuisine {
	BALKAN, ASIAN, ITALIAN, GERMAN, INDIAN, TURKISH, GREEK, AMERICAN;

	@JsonValue
	public String getId() {
		return toString().toLowerCase();
	}
}
