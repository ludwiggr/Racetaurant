package de.nullpointerexception.racetaurant.restaurant;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, String> {
	public List<Restaurant> findFiltered();
}
