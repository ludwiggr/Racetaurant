package de.nullpointerexception.racetaurant.restaurant.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity @Table(name = "restaurantsLayout") public class RestaurantLayout {
	@Id @GeneratedValue private Long id;

	public RestaurantLayout() {

	}

	public Long getId() {
		return id;
	}
}
