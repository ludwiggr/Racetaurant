package de.nullpointerexception.racetaurant.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import de.nullpointerexception.racetaurant.model.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, UUID> {

}
