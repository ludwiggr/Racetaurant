package de.nullpointerexception.racetaurant.restaurant.model;

public enum PriceCategory {
	CHEAP(0), MEDIUM(1), EXPENSIVE(2);

	private final Integer id;

	PriceCategory(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

}
