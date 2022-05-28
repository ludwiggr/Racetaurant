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

	public List<Restaurant> findFiltered(int start, int limit, PriceCategory priceCategory, double latitude, double longitude, double radius, CuisineType[] cuisines, Double ratingMin, Double ratingMax, String timeStart, String timeStop, int persons, String order, boolean direction){
		// 1.) Create sql query
		String query = "SELECT * FROM restaurants WHERE ";
		if(priceCategory != null){
			query += String.format("price=%d AND ", priceCategory.getValue());
		}
		query += String.format("POW( ( 69.1 * ( location.longitude - %f ) * cos( %f / 57.3 ) ) , 2 ) + POW( ( 69.1 * ( location.latitude - %f ) ) , 2 )) < ( %f * %f ) AND ", longitude, latitude, latitude, radius, radius);
		if(ratingMin != null){
			query += String.format("rating >= %f", ratingMin);
		}
		if(ratingMax != null){
			if(ratingMin != null){
				query += " AND ";
			}
			query += String.format("rating <= %f", ratingMax);
		}
		query += String.format("ORDER BY %s %s LIMIT %d OFFSET %d", order, direction ? "ASC" : "DSC", limit, start);

		// 2.) Execute sql query
		List<Restaurant> restaurants = entityManager.createQuery(query, Restaurant.class).getResultList();

		// 3.) Filter cuisine types (not done using sql)
		if(cuisines != null){
			restaurants = filterRestaurantsByCuisines(restaurants, cuisines);
		}

		// TODO: Filter by persons
		// TODO: Filter by startTime and stopTime
		return restaurants;
	}

	private List<Restaurant> filterRestaurantsByCuisines(List<Restaurant> restaurants, CuisineType[] requiredCuisines){
		return restaurants.stream().filter(r -> {
			for(CuisineType requiredCuisine : requiredCuisines){
				boolean containsRequiredCuisine = false;
				for(Cuisine restaurantCuisine : r.getCuisines()){
					if(restaurantCuisine.getCuisineType() == requiredCuisine){
						containsRequiredCuisine = true;
						break;
					}
				}
				if(!containsRequiredCuisine){
					return false;
				}
			}
			return true;
		}).toList();
	}

	public Optional<Restaurant> findById(String id){
		String query = String.format("SELECT * FROM restaurants WHERE id=%s;", id);
		List<Restaurant> results = entityManager.createQuery(query, Restaurant.class).getResultList();
		if(results.isEmpty()){
			return Optional.empty();
		}else{
			return Optional.of(results.get(0));
		}
	}

}
