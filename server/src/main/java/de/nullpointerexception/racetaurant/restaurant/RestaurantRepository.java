package de.nullpointerexception.racetaurant.restaurant;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public class RestaurantRepository{
	@PersistenceContext
	private EntityManager entityManager;

	public List<Restaurant> findFiltered(Integer start, Integer limit, PriceCategory priceCategory, Double latitude, Double longitude, Double radius, Cuisine[] cuisines, Double ratingMin, Double ratingMax, String timeStart, String timeStop, Integer persons, Order order, boolean asc){
		String query = "SELECT * FROM restaurants";
		// TODO: Adjust query to respect filters
		List<Restaurant> rawResults = entityManager.createNativeQuery(query).getResultList();
		// TODO: Manually filter results to respect filters that weren't implemented in the sql query
		return rawResults;
	}

	public Optional<Restaurant> findById(String id){
		String query = String.format("SELECT * FROM restaurants WHERE id=%s;", id);
		List<Restaurant> results = entityManager.createNativeQuery(query).getResultList();
		if(results.isEmpty()){
			return Optional.empty();
		}else{
			return Optional.of(results.get(0));
		}
	}

}
