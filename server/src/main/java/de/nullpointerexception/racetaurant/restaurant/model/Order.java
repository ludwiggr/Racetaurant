package de.nullpointerexception.racetaurant.restaurant.model;

public enum Order {
	ID("id"), NAME("name"), RATING("rating"), PRICE("priceCategory");

	private final String columnName;

	Order(String columnName) {
		this.columnName = columnName;
	}

	public String getColumnName() {
		return columnName;
	}
}
