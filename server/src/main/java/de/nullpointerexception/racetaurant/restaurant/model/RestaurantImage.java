package de.nullpointerexception.racetaurant.restaurant.model;

import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity public class RestaurantImage {
	@Id @GeneratedValue private Long id;

	@NotNull @URL private String url;

	@ManyToOne(fetch = FetchType.LAZY) private Restaurant restaurant;

	protected RestaurantImage() {

	}

	public RestaurantImage(String url) {
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public Long getId() {
		return id;
	}
}
