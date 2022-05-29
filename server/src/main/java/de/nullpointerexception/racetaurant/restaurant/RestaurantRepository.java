package de.nullpointerexception.racetaurant.restaurant;

import de.nullpointerexception.racetaurant.restaurant.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RestaurantRepository extends JpaRepository<Restaurant, UUID> {

}
