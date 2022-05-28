package de.nullpointerexception.racetaurant.restaurant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity @Table(name = "cuisines") public class Cuisine {
	@Id @GeneratedValue private Long id;

	public Cuisine(CuisineType cuisineType) {
		this.cuisineType = cuisineType;
	}

	protected Cuisine() {
	}

	private CuisineType cuisineType;

	public Long getId() {
		return id;
	}

	public CuisineType getCuisineType() {
		return cuisineType;
	}
}
