package de.nullpointerexception.racetaurant.repository;

import de.nullpointerexception.racetaurant.model.RestaurantLayout;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RestaurantLayoutRepository extends JpaRepository<RestaurantLayout, UUID> {
	RestaurantLayout findByRestaurantId(UUID restaurantId);
}
