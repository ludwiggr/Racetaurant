package de.nullpointerexception.racetaurant.restaurant;

public enum Order {
	ID, NAME, RATING, PRICE;

	public static Order parse(String value){
		return switch (value) {
			case "id" -> ID;
			case "name" -> NAME;
			case "rating" -> RATING;
			case "price" -> PRICE;
			default -> ID;
		};
	}
}
