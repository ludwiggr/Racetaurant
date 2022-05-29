package de.nullpointerexception.racetaurant;

import de.nullpointerexception.racetaurant.restaurant.RestaurantRepository;
import de.nullpointerexception.racetaurant.restaurant.model.*;
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
			restaurantRepository.save(new Restaurant("Test1", "https://wetter.de", 5,
					List.of(new RestaurantImage("https://image.url.de")), PriceCategory.CHEAP,
					List.of(Cuisine.AMERICAN), new Location(23.1, 12.5, "Straße 3"), new RestaurantLayout(),
					new OpeningTimes()));

			restaurantRepository.save(new Restaurant("sfdsdfsdf", "https://sdfs.de", 5,
					List.of(new RestaurantImage("https://image.url.de")), PriceCategory.CHEAP,
					List.of(Cuisine.AMERICAN, Cuisine.ASIAN), new Location(23.1, 85.21, "Straße 3"),
					new RestaurantLayout(), new OpeningTimes()));

			restaurantRepository.save(new Restaurant("33333", "https://wetter.de", 5,
					List.of(new RestaurantImage("https://image.url.de")), PriceCategory.CHEAP, List.of(Cuisine.GERMAN),
					new Location(23.1, 12.5, "123213 3"), new RestaurantLayout(), new OpeningTimes()));

			restaurantRepository.save(new Restaurant("sadsadsfdsf", "https://wetter.de", 5,
					List.of(new RestaurantImage("https://image.url.de")), PriceCategory.CHEAP, List.of(Cuisine.ITALIAN),
					new Location(13.1, 15.5, "2323 3"), new RestaurantLayout(), new OpeningTimes()));
		};
	}

}
