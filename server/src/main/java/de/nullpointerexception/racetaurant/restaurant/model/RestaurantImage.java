package de.nullpointerexception.racetaurant.restaurant.model;

import org.hibernate.validator.constraints.URL;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity public class RestaurantImage {
	@Id @GeneratedValue private Long id;

	@NotNull @URL private String url;

	protected RestaurantImage() {

	}

	public RestaurantImage(String url) {
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public Long getId() {
		return id;
	}
}
