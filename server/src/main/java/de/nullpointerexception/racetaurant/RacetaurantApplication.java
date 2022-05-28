package de.nullpointerexception.racetaurant;

import de.nullpointerexception.racetaurant.restaurant.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication public class RacetaurantApplication {

	@Autowired private RestaurantRepository restaurantRepository;

	public static void main(String[] args) {
		SpringApplication.run(RacetaurantApplication.class, args);
	}

	@Bean CommandLineRunner insertSamples() {
		return (args) -> {
			restaurantRepository.save(
					new Restaurant("Test1", "wetter.de", 5, List.of(new RestaurantImage("bildurl.de")),
							PriceCategory.CHEAP, List.of(new Cuisine(CuisineType.AMERICAN)),
							new Location(23.1, 12.5, "Straße 3"), new RestaurantLayout(), new OpeningTimes()));

			restaurantRepository.save(
					new Restaurant("sfdsdfsdf", "sdfs.de", 5, List.of(new RestaurantImage("bildurl.de")),
							PriceCategory.EXPENSIVE,
							List.of(new Cuisine(CuisineType.AMERICAN), new Cuisine(CuisineType.ASIAN)),
							new Location(23.1, 1232.5, "Straße 3"), new RestaurantLayout(), new OpeningTimes()));

			restaurantRepository.save(
					new Restaurant("33333", "wetter.de", 5, List.of(new RestaurantImage("bildurl.de")),
							PriceCategory.CHEAP, List.of(new Cuisine(CuisineType.GERMAN)),
							new Location(233.1, 12.5, "123213 3"), new RestaurantLayout(), new OpeningTimes()));

			restaurantRepository.save(
					new Restaurant("sadsadsfdsf", "wetter.de", 5, List.of(new RestaurantImage("bildurl.de")),
							PriceCategory.CHEAP, List.of(new Cuisine(CuisineType.ITALIAN)),
							new Location(23.1, 12.5, "2323 3"), new RestaurantLayout(), new OpeningTimes()));
		};
	}

}
