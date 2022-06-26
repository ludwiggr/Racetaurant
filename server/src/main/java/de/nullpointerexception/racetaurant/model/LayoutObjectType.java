package de.nullpointerexception.racetaurant.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum LayoutObjectType {
	STAIRCASE("staircase"), TABLE("table"), COLORED_SHAPE("colored-shape"), TEXT("text"), BAR("bar"), TOILETS(
			"toilets"), ENTRANCE("entrance"), DOOR("door"), IMAGE("image");

	private final String id;

	LayoutObjectType(String id) {
		this.id = id;
	}

	@JsonValue public String getId() {
		return id;
	}
}
