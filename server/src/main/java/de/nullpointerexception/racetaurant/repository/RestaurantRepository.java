package de.nullpointerexception.racetaurant.repository;

import de.nullpointerexception.racetaurant.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RestaurantRepository extends JpaRepository<Restaurant, UUID> {

}
