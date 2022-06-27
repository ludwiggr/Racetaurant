package de.nullpointerexception.racetaurant.model;

import java.util.List;
import java.util.UUID;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class RestaurantLayout {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", insertable = false, updatable = false, nullable = false)
	@JsonIgnore
	private UUID id;

	@NotNull
	@OneToMany(cascade = CascadeType.ALL)
	private List<Floor> floors;

	@NotNull
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "restaurantId", referencedColumnName = "id")
	@JsonIgnore
	private Restaurant restaurant;

	@NotNull
	private int defaultFloor;

	public RestaurantLayout(List<Floor> floors, Restaurant restaurant, int defaultFloor) {
		this.floors = floors;
		this.restaurant = restaurant;
		this.defaultFloor = defaultFloor;
	}

	protected RestaurantLayout() {

	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public List<Floor> getFloors() {
		return floors;
	}

	public void setFloors(List<Floor> floors) {
		this.floors = floors;
	}

	public int getDefaultFloor() {
		return defaultFloor;
	}
}
