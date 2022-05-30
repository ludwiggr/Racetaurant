package de.nullpointerexception.racetaurant.restaurant.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum PriceCategory {
	CHEAP(0), MEDIUM(1), EXPENSIVE(2);

	private final Integer id;

	PriceCategory(Integer id) {
		this.id = id;
	}

	@JsonValue
	public Integer getId() {
		return id;
	}

}
