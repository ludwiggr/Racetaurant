package de.nullpointerexception.racetaurant.restaurant;

import javax.persistence.*;

@Entity
@Table(name = "cuisines")
public class Cuisine {
	@Id
	@GeneratedValue
	private Long id;

	private CuisineType cuisineType;

	public Long getId() {
		return id;
	}

	public CuisineType getCuisineType() {
		return cuisineType;
	}
}
