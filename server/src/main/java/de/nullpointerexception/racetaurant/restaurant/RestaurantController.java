package de.nullpointerexception.racetaurant.restaurant;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.UUID;

@RestController public class RestaurantController {
	private final RestaurantService service;

	RestaurantController(RestaurantService service) {
		this.service = service;
	}

	@GetMapping("/restaurants") List<Restaurant> filtered(@RequestParam(defaultValue = "0") int start,
			@RequestParam(defaultValue = "50") int limit, @RequestParam(required = false) Integer price,
			@RequestParam(required = false) double latitude, @RequestParam(required = false) double longitude,
			@RequestParam(defaultValue = "5.0") double radius, @RequestParam(required = false) String[] cuisines,
			@RequestParam(required = false) Double ratingMin, @RequestParam(required = false) Double ratingMax,
			@RequestParam(required = false) String timeStart, @RequestParam(required = false) String timeStop,
			@RequestParam(defaultValue = "1") int persons, @RequestParam(defaultValue = "id") String order,
			@RequestParam(defaultValue = "false") boolean asc) {

		if (!RestaurantValidator.validateStart(start)) {
			throw new InvalidQueryParameterException("Start has to be a number greater or equal to 0");
		}

		if (!RestaurantValidator.validateLimit(limit)) {
			throw new InvalidQueryParameterException("Limit has to be a number between 0 and 200");
		}

		if (price != null && !RestaurantValidator.validatePrice(price)) {
			throw new InvalidQueryParameterException(
					"Price has to be the number 0 (cheap), 1 (medium) or 2 (expensive)");
		}
		PriceCategory priceCategory = null;
		if (price != null) {
			priceCategory = PriceCategory.valueOf(Integer.toString(price));
		}

		if (!RestaurantValidator.validateLatitude(latitude)) {
			throw new InvalidQueryParameterException("Latitude has to a floating-point number between -90 and 90");
		}

		if (!RestaurantValidator.validateLongitude(longitude)) {
			throw new InvalidQueryParameterException("Longitude has to a floating-point number between -90 and 90");
		}

		//No limits on radius so far
		//if (!RestaurantValidator.validateRadius(radius)){}

		if (cuisines != null && !RestaurantValidator.validateCuisines(cuisines)) {
			throw new InvalidQueryParameterException("One or more specified cuisines are incorrect");
		}
		CuisineType[] cuisineArray = null;
		if (cuisines != null) {
			cuisineArray = new CuisineType[cuisines.length];
			for (int i = 0; i < cuisines.length; i++) {
				cuisineArray[i] = CuisineType.valueOf(cuisines[i]);
			}
		}

		if (!RestaurantValidator.validateRatingMin(ratingMin)) {
			throw new InvalidQueryParameterException("MinRating has to be a value between 0 and 5");
		}
		if (!RestaurantValidator.validateRatingMax(ratingMax)) {
			throw new InvalidQueryParameterException("MaxRating has to be a value between 0 and 5");
		}
		if (ratingMin != null && ratingMax != null && ratingMin > ratingMax) {
			throw new InvalidQueryParameterException("MinRating can not be higher than MaxRating");
		}

		if (!RestaurantValidator.validateTimeStart(timeStart)) {
			throw new InvalidQueryParameterException("Start time has to be a correct ISO 8601 timestamp");
		}

		if (!RestaurantValidator.validateTimeStop(timeStop)) {
			throw new InvalidQueryParameterException("Stop time has to be a correct ISO 8601 timestamp");
		}

		if (!RestaurantValidator.validatePersons(persons)) {
			throw new InvalidQueryParameterException("Number of persons should be 1 or higher");
		}

		if (!RestaurantValidator.validateOrder(order)) {
			throw new InvalidQueryParameterException("Order has to be either id, name, rating or price");
		}

		return service.getRestaurantsWithFilter(start, limit, priceCategory, latitude, longitude, radius, cuisineArray,
				ratingMin, ratingMax, timeStart, timeStop, persons, order, asc);
	}

	@GetMapping("/restaurants/{id}") Restaurant one(@PathVariable UUID id) {
		return service.getRestaurantById(id).orElseThrow(() -> new RestaurantNotFoundException(id.toString()));
	}

	@ControllerAdvice class RestaurantNotFoundAdvice {
		@ResponseBody @ExceptionHandler(RestaurantNotFoundException.class) @ResponseStatus(HttpStatus.NOT_FOUND) String restaurantNotFoundHandler(
				RestaurantNotFoundException ex) {
			return ex.getMessage();
		}
	}

	@ControllerAdvice class InvalidQueryParameterAdvice {
		@ResponseBody @ExceptionHandler(InvalidQueryParameterException.class) @ResponseStatus(HttpStatus.BAD_REQUEST) String invalidQueryParameterHandler(
				InvalidQueryParameterException ex) {
			return ex.getMessage();
		}
	}

	static class RestaurantValidator {
		static boolean validateStart(int start) {
			if (start < 0) {
				return false;
			}
			return true;
		}

		static boolean validateLimit(int limit) {
			if (limit < 0 || limit > 200) {
				return false;
			}
			return true;
		}

		static boolean validatePrice(Integer price) {
			if (price == null || price < 0 || price > 2) {
				return false;
			}
			return true;
		}

		static boolean validateLatitude(double latitude) {
			if (latitude < -90 || latitude > 90) {
				return false;
			}
			return true;
		}

		static boolean validateLongitude(double longitude) {
			if (longitude < -90 || longitude > 90) {
				return false;
			}
			return true;
		}

		static boolean validateRadius(double radius) {
			return true;
		}

		static boolean validateCuisines(String[] cuisines) {
			if (cuisines == null || cuisines.length == 0) {
				return false;
			}
			for (String cuisine : cuisines) {
				try {
					CuisineType.valueOf(cuisine);
				} catch (IllegalArgumentException e) {
					return false;
				}
			}
			return true;
		}

		static boolean validateRatingMin(Double ratingMin) {
			if (ratingMin == null || ratingMin < 0 || ratingMin > 5) {
				return false;
			}
			return true;
		}

		static boolean validateRatingMax(Double ratingMax) {
			if (ratingMax == null || ratingMax < 0 || ratingMax > 5) {
				return false;
			}
			return true;
		}

		static boolean validateTimeStart(String timeStart) {
			if (timeStart != null) {
				try {
					DateTimeFormatter.ISO_DATE_TIME.parse(timeStart);
				} catch (DateTimeParseException e) {
					return false;
				}
			}
			return true;
		}

		static boolean validateTimeStop(String timeStop) {
			if (timeStop != null) {
				try {
					DateTimeFormatter.ISO_DATE_TIME.parse(timeStop);
				} catch (DateTimeParseException e) {
					return false;
				}
			}
			return true;
		}

		static boolean validatePersons(int persons) {
			if (persons < 1) {
				return false;
			}
			return true;
		}

		static boolean validateOrder(String order) {
			switch (order) {
				case "id":
				case "name":
				case "rating":
				case "price":
					return true;
				default:
					return false;
			}
		}
	}
}
