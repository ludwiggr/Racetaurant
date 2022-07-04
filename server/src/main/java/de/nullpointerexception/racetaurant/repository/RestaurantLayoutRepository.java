package de.nullpointerexception.racetaurant.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import de.nullpointerexception.racetaurant.model.RestaurantLayout;

public interface RestaurantLayoutRepository extends JpaRepository<RestaurantLayout, UUID> {
	RestaurantLayout findByRestaurantId(UUID restaurantId);
}
