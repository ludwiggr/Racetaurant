package de.nullpointerexception.racetaurant.restaurant.controller;

import de.nullpointerexception.racetaurant.restaurant.RestaurantService;
import de.nullpointerexception.racetaurant.restaurant.model.Cuisine;
import de.nullpointerexception.racetaurant.restaurant.model.Order;
import de.nullpointerexception.racetaurant.restaurant.model.PriceCategory;
import de.nullpointerexception.racetaurant.restaurant.model.Restaurant;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController @RequestMapping("/api/restaurants") @Validated public class RestaurantController {
	private final RestaurantService service;

	RestaurantController(RestaurantService service) {
		this.service = service;
	}

	@GetMapping List<Restaurant> filtered(
			// @formatter:off
			@Min(value = 0, message = "start has to be greater or equal to 0.") @RequestParam(name = "start", required = false) Integer start,
			@Min(value = 0, message = "The minimum limit is 0.") @Max(value = 200, message = "The maximum limit is 200.") @RequestParam(name = "limit", required = false) Integer limit,
			@RequestParam(name = "price", required = false) PriceCategory priceCategory,
			@Min(value = -90, message = "The minimum latitude is -90.") @Max(value = 90, message = "The maximum latitude is 90.") @RequestParam(name = "latitude", required = false)  Double latitude,
			@Min(value = -90, message = "The minimum longitude is -90.") @Max(value = 90, message = "The maximum longitude is 90.") @RequestParam(name = "longitude", required = false)  Double longitude,
			@Min(value = 0, message = "The minimum radius is 0.") @RequestParam(name = "radius", required = false)  Double radius,
			@RequestParam(name = "cuisines", required = false, defaultValue = "") Cuisine[] cuisines,
			@Min(value = 0, message = "The minimum rating_min is 0.") @Max(value = 5, message = "The maximum rating_min is 5.") @RequestParam(name = "rating_min", required = false)  Double ratingMin,
			@Min(value = 0, message = "The minimum rating_max is 0.") @Max(value = 5, message = "The maximum rating_max is 5.") @RequestParam(name = "rating_max", required = false)  Double ratingMax,
			@Min(value = 1, message = "The minimum value for persons is 1.") @RequestParam(name = "persons", required = false) Integer persons,
			@RequestParam(name = "order", required = false) Order order,
			@RequestParam(name = "time_start", required = false) LocalDateTime timeStart,
			@RequestParam(name = "time_stop", required = false) LocalDateTime timeStop,
			@RequestParam(name = "asc", required = false) boolean ascending
			// @formatter:on
	) {
		return service.getRestaurantsWithFilter(start, limit, priceCategory, latitude, longitude, radius, cuisines,
				ratingMin, ratingMax, timeStart, timeStop, persons, order, ascending);
	}

	@GetMapping("/{id}") Restaurant one(@PathVariable UUID id) {
		return service.getRestaurantById(id).orElseThrow(() -> new RestaurantNotFoundException(id.toString()));
	}
}
