package de.nullpointerexception.racetaurant.restaurant.model;

public enum Cuisine {
	BALKAN, ASIAN, ITALIAN, GERMAN, INDIAN, TURKISH, GREEK, AMERICAN;

	public String getId() {
		return toString().toLowerCase();
	}
}
