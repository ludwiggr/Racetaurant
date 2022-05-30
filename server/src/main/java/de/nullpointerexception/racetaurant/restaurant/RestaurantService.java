package de.nullpointerexception.racetaurant.restaurant;

import de.nullpointerexception.racetaurant.restaurant.model.Cuisine;
import de.nullpointerexception.racetaurant.restaurant.model.Order;
import de.nullpointerexception.racetaurant.restaurant.model.PriceCategory;
import de.nullpointerexception.racetaurant.restaurant.model.Restaurant;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service public class RestaurantService {
	private final RestaurantRepository restaurantRepository;

	@PersistenceContext public EntityManager em;

	public RestaurantService(RestaurantRepository restaurantRepository) {
		this.restaurantRepository = restaurantRepository;
	}

	/**
	 * Gets all restaurants stored in the database meeting the passed filters.
	 * All parameters are optional (just pass <code>null</code>). Some parameters
	 * take default values if they are <code>null</code>.
	 *
	 * @param start            the amount of restaurants to skip (default value: 0)
	 * @param limit            the maximum amount of restaurants to return (default value: 50)
	 * @param priceCategory    the required price category
	 * @param latitude         the target's latitude
	 * @param longitude        the target's longitude
	 * @param radius           the maximum restaurant distance (in kilometres) from the target position (default: <code>1km</code>)
	 * @param requiredCuisines the cuisines the restaurant has to offer
	 * @param ratingMin        the restaurant's minimum average rating
	 * @param ratingMax        the restaurant's maximum average rating
	 * @param timeStart        the ISO 8601 timestamp from when a free table should be available
	 * @param timeStop         the ISO 8601 timestamp until when a free table should be available
	 * @param persons          the minimum amount of free places a free table of the restaurant has to offer in the given time interval
	 * @param order            the attribute to sort by
	 * @param ascending        whether to sort ascending (default: false)
	 * @return all restaurants stored in the database meeting the passed filters
	 */
	public List<Restaurant> getRestaurantsWithFilter(Integer start, Integer limit, PriceCategory priceCategory,
			Double latitude, Double longitude, Double radius, Cuisine[] requiredCuisines, Double ratingMin,
			Double ratingMax, LocalDateTime timeStart, LocalDateTime timeStop, Integer persons, Order order,
			Boolean ascending) {
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
		ascending = ascending != null && ascending;
		order = order == null ? Order.ID : order;
		if (ascending) {
			cq.orderBy(cb.asc(root.get(order.getColumnName())));
		} else {
			cq.orderBy(cb.desc(root.get(order.getColumnName())));
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

	private List<Restaurant> filterRestaurantsByCuisines(List<Restaurant> restaurants, Cuisine[] requiredCuisines) {
		return restaurants.stream().filter(r -> {
			for (Cuisine requiredCuisine : requiredCuisines) {
				boolean containsRequiredCuisine = false;
				for (Cuisine restaurantCuisine : r.getCuisines()) {
					if (restaurantCuisine == requiredCuisine) {
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
