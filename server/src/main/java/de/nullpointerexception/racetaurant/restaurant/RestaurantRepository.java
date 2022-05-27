package de.nullpointerexception.racetaurant.restaurant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, String> {

	@Query("SELECT * FROM restaurants WHERE " +
			"priceCategory = :price AND " +
			"rating >= :ratingMin AND " +
			"rating <= :ratingMax AND " +
			"POW( ( 69.1 * ( location.longitude - :longitude ) * cos( :latitude / 57.3 ) ) , 2 ) + POW( ( 69.1 * ( location.latitude - :latitude ) ) , 2 )) < ( :radius * :radius ) AND" +
			"ORDER BY :order :direction " +
			"LIMIT :limit OFFSET :start"
	)
	List<Restaurant> findFiltered(@Param("start") int start, @Param("limit") int limit, @Param("price") int price,  @Param("latitude") double latitude, @Param("longitude") double longitude, @Param("radius") double radius, @Param("ratingMin") double ratingMin, @Param("ratingMax") double ratingMax, @Param("order") String order, @Param("direction") String direction);

}
