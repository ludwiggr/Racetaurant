package de.nullpointerexception.racetaurant.controller.errors;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class RestaurantNotFoundException extends ResponseStatusException {
	public RestaurantNotFoundException(UUID id, HttpStatus status) {
		super(status, String.format("The requested restaurant with the id '%s' does not exist", id.toString()));
	}
}
