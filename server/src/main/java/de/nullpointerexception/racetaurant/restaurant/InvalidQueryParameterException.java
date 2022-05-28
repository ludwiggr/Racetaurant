package de.nullpointerexception.racetaurant.restaurant;

public class InvalidQueryParameterException extends RuntimeException {

	InvalidQueryParameterException() {
		super("Invalid use of query parameters");
	}

	InvalidQueryParameterException(String message) {
		super(message);
	}
}
