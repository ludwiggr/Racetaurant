package de.nullpointerexception.racetaurant.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Cuisine {
	BALKAN, ASIAN, ITALIAN, GERMAN, INDIAN, TURKISH, GREEK, AMERICAN;

	@JsonValue
	public String getId() {
		return toString().toLowerCase();
	}
}
