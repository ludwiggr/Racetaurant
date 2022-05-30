package de.nullpointerexception.racetaurant.restaurant;

public enum PriceCategory {
	CHEAP(0), MEDIUM(1), EXPENSIVE(2);

	private final int value;

	private PriceCategory(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

}
