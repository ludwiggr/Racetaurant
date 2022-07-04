package de.nullpointerexception.racetaurant.controller;

import java.util.UUID;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import de.nullpointerexception.racetaurant.model.LayoutObjectType;
import de.nullpointerexception.racetaurant.model.RestaurantLayout;
import de.nullpointerexception.racetaurant.service.RestaurantLayoutService;

@RestController
@RequestMapping("/api/restaurants")
@Validated
@CrossOrigin
public class RestaurantLayoutController {
	private final RestaurantLayoutService service;

	RestaurantLayoutController(RestaurantLayoutService service) {
		this.service = service;
	}

	@GetMapping("/{id}/layout")
	public RestaurantLayout getRestaurantLayout(@PathVariable UUID id,
			@RequestParam(name = "object-types", required = false) LayoutObjectType[] objectTypes) {
		return service.getRestaurantLayoutWithFilter(id, objectTypes);
	}
}
