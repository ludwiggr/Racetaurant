package de.nullpointerexception.racetaurant.restaurant;

import javax.persistence.*;

@Entity public class RestaurantImage {
	@Id @GeneratedValue private Long id;
	private String url;

	@ManyToOne(optional = false) @JoinColumn(name = "restaurantId", referencedColumnName = "id") private Restaurant restaurant;

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
