package de.nullpointerexception.racetaurant.restaurant;

public class RestaurantNotFoundException extends RuntimeException {
	RestaurantNotFoundException(String id) {
		super("Could not find restaurant " + id);
	}

}
