package de.nullpointerexception.racetaurant.controller;

public class RestaurantNotFoundException extends RuntimeException {
	RestaurantNotFoundException(String id) {
		super("Could not find restaurant '" + id + "'.");
	}

}
