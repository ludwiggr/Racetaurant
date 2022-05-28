package de.nullpointerexception.racetaurant.restaurant;

import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service public class RestaurantService {
	private final RestaurantRepository restaurantRepository;

	@PersistenceContext public EntityManager em;

	public RestaurantService(RestaurantRepository restaurantRepository) {
		this.restaurantRepository = restaurantRepository;
	}

	public List<Restaurant> getRestaurantsWithFilter(Integer start, Integer limit, PriceCategory priceCategory,
			Double latitude, Double longitude, Double radius, CuisineType[] requiredCuisines, Double ratingMin,
			Double ratingMax, String timeStart, String timeStop, Integer persons, String order, Boolean asc) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Restaurant> cq = cb.createQuery(Restaurant.class);

		Root<Restaurant> root = cq.from(Restaurant.class);

		boolean priceCategoryFilter = priceCategory != null;
		boolean locationFilter = latitude != null && longitude != null && radius != null;
		boolean cuisineFilter = requiredCuisines != null;
		boolean ratingMinFilter = ratingMin != null;
		boolean ratingMaxFilter = ratingMax != null;
		boolean openingTimesFilter = timeStart != null && timeStop != null;
		boolean personsFilter = persons != null;

		if (openingTimesFilter) {
			// TODO: Implement opening times filter
		}

		if (personsFilter) {
			// TODO: Implement persons filter
		}

		// Filter by price category
		if (priceCategoryFilter) {
			cq.where(cb.equal(root.get("priceCategory"), priceCategory));
		}

		// Filter by minimum rating
		if (ratingMinFilter) {
			cq.where(cb.greaterThanOrEqualTo(root.get("rating"), ratingMin));
		}

		// Filter by maximum rating
		if (ratingMaxFilter) {
			cq.where(cb.lessThanOrEqualTo(root.get("rating"), ratingMax));
		}

		// Filter by distance
		// @formatter:off
		if(locationFilter){
			cq.where(cb.lessThan(cb.prod(
					6371.0,
					cb.function(
							"ACOS",
							Double.class,
							cb.sum(
									cb.prod(
											cb.prod(
													cb.function("COS", Double.class, cb.function("RADIANS", Double.class, cb.parameter(Double.class, "latitude"))),
													cb.function("COS", Double.class, cb.function("RADIANS", Double.class, root.get("location").get("latitude")))
											),
											cb.function("COS", Double.class,
													cb.diff(
															cb.function("RADIANS", Double.class, root.get("location").get("longitude")),
															cb.function("RADIANS", Double.class, cb.parameter(Double.class, "longitude"))
													)
											)
									),
									cb.prod(
											cb.function("SIN", Double.class, cb.function("RADIANS", Double.class, cb.parameter(Double.class, "latitude"))),
											cb.function("SIN", Double.class, cb.function("RADIANS", Double.class, root.get("location").get("latitude")))
									)
							)
					)
			), cb.parameter(Double.class, "radius")));
		}
		// @formatter:on

		// Sort (default is descending by id)
		asc = asc != null && asc;
		order = order == null ? "id" : order;
		if (asc) {
			cq.orderBy(cb.asc(root.get(order)));
		} else {
			cq.orderBy(cb.desc(root.get(order)));
		}

		TypedQuery<Restaurant> createdQuery = em.createQuery(cq);
		if (locationFilter) {
			createdQuery.setParameter("radius", radius);
			createdQuery.setParameter("longitude", longitude);
			createdQuery.setParameter("latitude", latitude);
		}

		// Offset results (default 0)
		start = start == null ? 0 : start;
		createdQuery.setFirstResult(start);

		// Limit results (default 50)
		limit = limit == null ? 50 : limit;
		createdQuery.setMaxResults(limit);

		List<Restaurant> results = createdQuery.getResultList();

		// TODO: Filter by cuisines using SQL (currently done using streams)
		if (cuisineFilter) {
			return filterRestaurantsByCuisines(results, requiredCuisines);
		} else {
			return results;
		}
	}

	private List<Restaurant> filterRestaurantsByCuisines(List<Restaurant> restaurants, CuisineType[] requiredCuisines) {
		return restaurants.stream().filter(r -> {
			for (CuisineType requiredCuisine : requiredCuisines) {
				boolean containsRequiredCuisine = false;
				for (Cuisine restaurantCuisine : r.getCuisines()) {
					if (restaurantCuisine.getCuisineType() == requiredCuisine) {
						containsRequiredCuisine = true;
						break;
					}
				}
				if (!containsRequiredCuisine) {
					return false;
				}
			}
			return true;
		}).toList();
	}

	public Optional<Restaurant> getRestaurantById(UUID id) {
		return restaurantRepository.findById(id);
	}
}
