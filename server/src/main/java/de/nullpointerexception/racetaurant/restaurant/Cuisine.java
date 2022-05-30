package de.nullpointerexception.racetaurant.restaurant;

public enum Cuisine {
	BALKAN("balkan"), ASIAN("asian"), ITALIAN("italian"), GERMAN("german"), INDIAN("indian"), TURKISH("turkish"),
	GREEK("greek"), AMERICAN("american");

	private final String id;

	private Cuisine(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}
}
