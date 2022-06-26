package de.nullpointerexception.racetaurant;

import de.nullpointerexception.racetaurant.model.*;
import de.nullpointerexception.racetaurant.repository.RestaurantLayoutRepository;
import de.nullpointerexception.racetaurant.repository.RestaurantRepository;
import de.nullpointerexception.racetaurant.samples.RestaurantLayoutFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;

import java.util.List;

@SpringBootApplication public class RacetaurantApplication {

	@Autowired private RestaurantRepository restaurantRepository;
	@Autowired private RestaurantLayoutRepository restaurantLayoutRepository;

	public static void main(String[] args) {
		SpringApplication.run(RacetaurantApplication.class, args);
	}

	@Bean("restaurant-samples") CommandLineRunner insertRestaurantSamples() {
		return (args) -> {

			//Opening Times
			OpeningTime t0 = new OpeningTime();
			OpeningTime t1 = new OpeningTime("08:00", "16:00");
			OpeningTime t2 = new OpeningTime("10:00", "20:00");
			OpeningTime t3 = new OpeningTime("13:00", "22:00");
			OpeningTime t4 = new OpeningTime("17:00", "24:00");

			OpeningTimes openingTimes0 = new OpeningTimes(t1, t1, t1, t1, t2, t2, t0);
			OpeningTimes openingTimes1 = new OpeningTimes(t0, t3, t3, t4, t4, t4, t0);
			OpeningTimes openingTimes2 = new OpeningTimes(t0, t0, t0, t4, t4, t2, t2);
			OpeningTimes openingTimes3 = new OpeningTimes(t4, t4, t4, t4, t3, t3, t3);

			//American Restaurants -> 5
			restaurantRepository.save(new Restaurant("Jones Original American Diner", "http://www.jones-diner.com", 4.6,
					List.of(new RestaurantImage(
							"https://as1.ftcdn.net/v2/jpg/02/10/97/64/1000_F_210976473_Ud6IViNN5QksXJJSBqNCWZ9loSR6bkvv.jpg")),
					PriceCategory.EXPENSIVE, List.of(Cuisine.AMERICAN),
					new Location(48.145440, 11.558920, "Karlstraße 56, 80333 München"), openingTimes0));

			restaurantRepository.save(new Restaurant("McDonalds", "http://www.mcdonalds.de", 3.2,
					List.of(new RestaurantImage(
							"https://as1.ftcdn.net/v2/jpg/02/10/97/64/1000_F_210976473_Ud6IViNN5QksXJJSBqNCWZ9loSR6bkvv.jpg")),
					PriceCategory.CHEAP, List.of(Cuisine.AMERICAN),
					new Location(48.136009, 11.579324, "Tal 6, 80331 München"), openingTimes2));

			restaurantRepository.save(new Restaurant("Pizza Hut", "https://pizzahut-muenchen.de", 4.3,
					List.of(new RestaurantImage(
							"https://as1.ftcdn.net/v2/jpg/02/10/97/64/1000_F_210976473_Ud6IViNN5QksXJJSBqNCWZ9loSR6bkvv.jpg")),
					PriceCategory.MEDIUM, List.of(Cuisine.AMERICAN),
					new Location(48.133799, 11.583252, "Zweibrückenstraße 1, 80331 München"), openingTimes2));

			restaurantRepository.save(new Restaurant("Dominos", "https://wetter.de", 3.3, List.of(new RestaurantImage(
					"https://as1.ftcdn.net/v2/jpg/02/10/97/64/1000_F_210976473_Ud6IViNN5QksXJJSBqNCWZ9loSR6bkvv.jpg")),
					PriceCategory.CHEAP, List.of(Cuisine.AMERICAN),
					new Location(48.114762, 11.592907, "Schlierseestraße 31, 81539 München"), openingTimes1));

			restaurantRepository.save(new Restaurant("Burger King", "https://www.burgerking.de", 2.2,
					List.of(new RestaurantImage(
							"https://as1.ftcdn.net/v2/jpg/02/10/97/64/1000_F_210976473_Ud6IViNN5QksXJJSBqNCWZ9loSR6bkvv.jpg")),
					PriceCategory.CHEAP, List.of(Cuisine.AMERICAN),
					new Location(48.137807, 11.564542, "Sonnenstraße 6, 80331 München"), openingTimes0));

			//Asian Restaurants -> 5
			restaurantRepository.save(
					new Restaurant("Secret Garden Vegan Sushi München", "https://secretgarden-muenchen.com", 4.5,
							List.of(new RestaurantImage(
									"https://qul.imgix.net/b1c0bc85-9e67-4f4f-ae24-a8d9f130f9f2/582695_sld.jpg")),
							PriceCategory.MEDIUM, List.of(Cuisine.ASIAN),
							new Location(48.13567, 11.577523, "Heiliggeiststraße 2 A, 80331 München"), openingTimes3));

			restaurantRepository.save(new Restaurant("Kaimug", "https://www.kaimug.de", 3.9,
					List.of(new RestaurantImage(
							"https://qul.imgix.net/b1c0bc85-9e67-4f4f-ae24-a8d9f130f9f2/582695_sld.jpg")),
					PriceCategory.MEDIUM, List.of(Cuisine.ASIAN),
					new Location(48.140536, 11.575275, "Theatinerstraße 15, 80333 München"), openingTimes2));

			restaurantRepository.save(new Restaurant("Hansik", "http://muenchen-hansik.de", 4.4,
					List.of(new RestaurantImage(
							"https://qul.imgix.net/b1c0bc85-9e67-4f4f-ae24-a8d9f130f9f2/582695_sld.jpg")),
					PriceCategory.CHEAP, List.of(Cuisine.ASIAN),
					new Location(48.136157, 11.583518, "Thomas-Wimmer-Ring 9, 80539 München"), openingTimes1));

			restaurantRepository.save(new Restaurant("Matsuhisa",
					"https://www.mandarinoriental.com/munich/altstadt/fine-dining/restaurants/japanese-peruvian-cuisine/matsuhisa-munich?htl=MOMUC&kw=MOMUC_matsuhisa&eng=google&src=local",
					4.6, List.of(new RestaurantImage(
					"https://qul.imgix.net/b1c0bc85-9e67-4f4f-ae24-a8d9f130f9f2/582695_sld.jpg")),
					PriceCategory.EXPENSIVE, List.of(Cuisine.ASIAN),
					new Location(48.13733, 11.58082, "Neuturmstraße 1, 80331 München"), openingTimes0));

			restaurantRepository.save(new Restaurant("Jin", "https://www.restaurant-jin.de", 4.0,
					List.of(new RestaurantImage(
							"https://qul.imgix.net/b1c0bc85-9e67-4f4f-ae24-a8d9f130f9f2/582695_sld.jpg")),
					PriceCategory.MEDIUM, List.of(Cuisine.ASIAN),
					new Location(48.135956, 11.584270, "Kanalstraße 14, 80538 München"), openingTimes2));

			//German Restaurants -> 5
			restaurantRepository.save(new Restaurant("Klinglwirt", "https://www.klinglwirt.de", 3.9,
					List.of(new RestaurantImage(
							"https://templesandtreehouses.com/wp-content/uploads/2019/10/A-selection-of-traditional-German-dishes-including-pretzels-and-schitzel.jpg")),
					PriceCategory.CHEAP, List.of(Cuisine.GERMAN),
					new Location(48.126785, 11.5948, "Balanstraße 16, 81669 München"), openingTimes3));

			restaurantRepository.save(new Restaurant("Augustiner", "https://augustiner-am-platzl.de", 4.2,
					List.of(new RestaurantImage(
							"https://templesandtreehouses.com/wp-content/uploads/2019/10/A-selection-of-traditional-German-dishes-including-pretzels-and-schitzel.jpg")),
					PriceCategory.MEDIUM, List.of(Cuisine.GERMAN),
					new Location(48.137535, 11.579385, "Orlandostraße 5, 80331 München"), openingTimes2));

			restaurantRepository.save(
					new Restaurant("Haxnbauer", "https://www.kuffler.de/de/restaurant/haxnbauer/", 3.6,
							List.of(new RestaurantImage(
									"https://templesandtreehouses.com/wp-content/uploads/2019/10/A-selection-of-traditional-German-dishes-including-pretzels-and-schitzel.jpg")),
							PriceCategory.MEDIUM, List.of(Cuisine.GERMAN),
							new Location(48.137509, 11.578455, "Sparkassenstraße 6, 80331 München"), openingTimes1));

			restaurantRepository.save(new Restaurant("Zum Dürnbräu", "https://www.zumduernbraeu.de", 3.5,
					List.of(new RestaurantImage(
							"https://templesandtreehouses.com/wp-content/uploads/2019/10/A-selection-of-traditional-German-dishes-including-pretzels-and-schitzel.jpg")),
					PriceCategory.MEDIUM, List.of(Cuisine.GERMAN),
					new Location(48.136277, 11.580154, "Dürnbräugasse 2, 80331 München"), openingTimes0));

			restaurantRepository.save(new Restaurant("Rumpler", "https://www.rumpler-augustiner.de", 4.6,
					List.of(new RestaurantImage(
							"https://templesandtreehouses.com/wp-content/uploads/2019/10/A-selection-of-traditional-German-dishes-including-pretzels-and-schitzel.jpg")),
					PriceCategory.MEDIUM, List.of(Cuisine.GERMAN),
					new Location(48.126353, 11.568755, "Baumstraße 21, 80469 München"), openingTimes3));

			//Italian Restaurants -> 5
			restaurantRepository.save(new Restaurant("Ristorante Albarone Monaco", "https://wetter.de", 4.8,
					List.of(new RestaurantImage(
							"https://www.tastingtable.com/img/gallery/20-italian-dishes-you-need-to-try-at-least-once/l-intro-1643403830.jpg")),
					PriceCategory.EXPENSIVE, List.of(Cuisine.ITALIAN),
					new Location(48.137998, 11.583335, "Stollbergstraße 22, 80539 München"), openingTimes1));

			restaurantRepository.save(new Restaurant("Va Bene", "https://www.ristorante-va-bene.de", 4.5,
					List.of(new RestaurantImage(
							"https://www.tastingtable.com/img/gallery/20-italian-dishes-you-need-to-try-at-least-once/l-intro-1643403830.jpg")),
					PriceCategory.MEDIUM, List.of(Cuisine.ITALIAN),
					new Location(48.134083, 11.583481, "Isartorpl. 6, 80331 München"), openingTimes2));

			restaurantRepository.save(new Restaurant("La Pizzetta", "http://www.la-pizzetta-tal.de", 3.5,
					List.of(new RestaurantImage(
							"https://www.tastingtable.com/img/gallery/20-italian-dishes-you-need-to-try-at-least-once/l-intro-1643403830.jpg")),
					PriceCategory.MEDIUM, List.of(Cuisine.ITALIAN),
					new Location(48.136069, 11.577865, "Tal 4, 80331 München"), openingTimes2));

			restaurantRepository.save(new Restaurant("Trattoria Pizzeria Lago di Garda", "https://www.lago1972.de", 3.9,
					List.of(new RestaurantImage(
							"https://www.tastingtable.com/img/gallery/20-italian-dishes-you-need-to-try-at-least-once/l-intro-1643403830.jpg")),
					PriceCategory.EXPENSIVE, List.of(Cuisine.ITALIAN),
					new Location(48.133441, 11.581173, "Baaderstraße 2, 80469 München"), openingTimes3));

			restaurantRepository.save(new Restaurant("Berni's Nudelbrett", "http://www.bernisnudelbrett.de", 4.1,
					List.of(new RestaurantImage(
							"https://www.tastingtable.com/img/gallery/20-italian-dishes-you-need-to-try-at-least-once/l-intro-1643403830.jpg")),
					PriceCategory.MEDIUM, List.of(Cuisine.ITALIAN),
					new Location(48.136013, 11.576006, "Peterspl. 8, 80331 München"), openingTimes0));

			//Balkan Restaurants -> 5
			restaurantRepository.save(new Restaurant("Sendlinger Treff", "http://www.sendlingertreff.de/menu/", 3.8,
					List.of(new RestaurantImage(
							"https://www.rakijagrill.com/wp-content/uploads/2019/11/shutterstock_1502599004-1.jpg")),
					PriceCategory.MEDIUM, List.of(Cuisine.BALKAN),
					new Location(48.12105, 11.540972, "Plinganserstraße 14A, 81369 München"), openingTimes2));

			restaurantRepository.save(new Restaurant("Ćevabdžinica 10", "https://www.cevabdzinica.de", 3.4,
					List.of(new RestaurantImage(
							"https://www.rakijagrill.com/wp-content/uploads/2019/11/shutterstock_1502599004-1.jpg")),
					PriceCategory.CHEAP, List.of(Cuisine.BALKAN),
					new Location(48.119287, 11.549457, "Oberländerstraße 3B, 81371 München"), openingTimes2));

			restaurantRepository.save(new Restaurant("Balkanwald", "https://balkanwald.de", 3.9,
					List.of(new RestaurantImage(
							"https://www.rakijagrill.com/wp-content/uploads/2019/11/shutterstock_1502599004-1.jpg")),
					PriceCategory.EXPENSIVE, List.of(Cuisine.BALKAN),
					new Location(48.112127, 11.575887, "Tegernseer Landstraße 114, 81539 München"), openingTimes3));

			restaurantRepository.save(new Restaurant("Dalmatiner Grill", "http://www.dalmatiner-grill.de", 4.4,
					List.of(new RestaurantImage(
							"https://www.rakijagrill.com/wp-content/uploads/2019/11/shutterstock_1502599004-1.jpg")),
					PriceCategory.MEDIUM, List.of(Cuisine.BALKAN),
					new Location(48.141269, 11.603692, "Geibelstraße 10, 81679 München"), openingTimes2));

			restaurantRepository.save(new Restaurant("Moosacher Paradies", "https://www.moosacherparadies.de", 3.8,
					List.of(new RestaurantImage(
							"https://www.rakijagrill.com/wp-content/uploads/2019/11/shutterstock_1502599004-1.jpg")),
					PriceCategory.CHEAP, List.of(Cuisine.BALKAN),
					new Location(48.169754, 11.507017, "Franz-Mader-Straße 11, 80992 München"), openingTimes0));

			//Greek Restaurants -> 5
			restaurantRepository.save(new Restaurant("Piatsa", "https://restaurant-piatsa.de", 4.2,
					List.of(new RestaurantImage(
							"https://greecetravelideas.com/wp-content/uploads/2018/08/shutterstock_646209769-min.jpg")),
					PriceCategory.MEDIUM, List.of(Cuisine.GREEK),
					new Location(48.15886, 11.584857, "Leopoldstraße 33, 80802 München"), openingTimes1));

			restaurantRepository.save(new Restaurant("aplafunky", "https://aplafunky.de", 4.8,
					List.of(new RestaurantImage(
							"https://greecetravelideas.com/wp-content/uploads/2018/08/shutterstock_646209769-min.jpg")),
					PriceCategory.EXPENSIVE, List.of(Cuisine.GREEK),
					new Location(48.132132, 11.57952, "Buttermelcherstraße 21, 80469 München"), openingTimes2));

			restaurantRepository.save(new Restaurant("Elafonisi", "https://elafonisi-münchen.de", 4.9,
					List.of(new RestaurantImage(
							"https://greecetravelideas.com/wp-content/uploads/2018/08/shutterstock_646209769-min.jpg")),
					PriceCategory.MEDIUM, List.of(Cuisine.GREEK),
					new Location(48.131436, 11.588424, "Rosenheimer Str. 4, 81669 München"), openingTimes3));

			restaurantRepository.save(new Restaurant("Taverne Anti", "https://www.facebook.com/TaverneANTI/", 3.6,
					List.of(new RestaurantImage(
							"https://greecetravelideas.com/wp-content/uploads/2018/08/shutterstock_646209769-min.jpg")),
					PriceCategory.MEDIUM, List.of(Cuisine.GREEK),
					new Location(48.127897, 11.569082, "Jahnstraße 36, 80469 München"), openingTimes1));

			restaurantRepository.save(new Restaurant("Kreta Grill", "https://www.kreta-grill.info", 3.1,
					List.of(new RestaurantImage(
							"https://greecetravelideas.com/wp-content/uploads/2018/08/shutterstock_646209769-min.jpg")),
					PriceCategory.CHEAP, List.of(Cuisine.GREEK),
					new Location(48.158579, 11.575033, "Nordendstraße 60, 80801 München"), openingTimes1));

			//Indian Restaurants -> 5
			restaurantRepository.save(new Restaurant("Goa",
					"https://restaurant-goa.hunger.de/8792?utm_source=google&utm_medium=mybusiness&utm_campaign=gb",
					3.7, List.of(new RestaurantImage(
					"https://www.halloessen.de/blog/wp-content/uploads/2020/10/shutterstock_649541308-1-scaled.jpg")),
					PriceCategory.MEDIUM, List.of(Cuisine.INDIAN),
					new Location(48.134075, 11.584215, "Thierschstraße 8, 80538 München"), openingTimes3));

			restaurantRepository.save(new Restaurant("Garam Masala", "http://www.garam-masala.de", 3.9,
					List.of(new RestaurantImage(
							"https://www.halloessen.de/blog/wp-content/uploads/2020/10/shutterstock_649541308-1-scaled.jpg")),
					PriceCategory.CHEAP, List.of(Cuisine.INDIAN),
					new Location(48.135459, 11.579122, "Radlsteg 1, 80331 München"), openingTimes3));

			restaurantRepository.save(new Restaurant("Ganga", "https://www.gangarestaurant.de", 3.4,
					List.of(new RestaurantImage(
							"https://www.halloessen.de/blog/wp-content/uploads/2020/10/shutterstock_649541308-1-scaled.jpg")),
					PriceCategory.MEDIUM, List.of(Cuisine.INDIAN),
					new Location(48.131832, 11.579995, "Baaderstraße 11, 80469 München"), openingTimes0));

			restaurantRepository.save(new Restaurant("Indian Mango", "http://indian-mango.com", 4.3,
					List.of(new RestaurantImage(
							"https://www.halloessen.de/blog/wp-content/uploads/2020/10/shutterstock_649541308-1-scaled.jpg")),
					PriceCategory.EXPENSIVE, List.of(Cuisine.INDIAN),
					new Location(48.132968, 11.584273, "Zweibrückenstraße 15, 80331 München"), openingTimes1));

			restaurantRepository.save(new Restaurant("Madam Chutney", "https://www.madamchutney.com", 4.1,
					List.of(new RestaurantImage(
							"https://www.halloessen.de/blog/wp-content/uploads/2020/10/shutterstock_649541308-1-scaled.jpg")),
					PriceCategory.MEDIUM, List.of(Cuisine.INDIAN),
					new Location(48.134597, 11.578123, "Frauenstraße 11, 80469 München"), openingTimes2));

			//Turkish Restaurants -> 5
			restaurantRepository.save(new Restaurant("SILA", "http://www.silarestaurant.com", 3.7,
					List.of(new RestaurantImage("https://www.melares.com/uploads/turkish-foods72022865.jpg")),
					PriceCategory.CHEAP, List.of(Cuisine.TURKISH),
					new Location(48.134009, 11.565552, "Sendlinger-Tor-Platz 8, 80336 München"), openingTimes2));

			restaurantRepository.save(new Restaurant("Lezizel Manti", "https://lezizel.de", 4.1,
					List.of(new RestaurantImage("https://www.melares.com/uploads/turkish-foods72022865.jpg")),
					PriceCategory.MEDIUM, List.of(Cuisine.TURKISH),
					new Location(48.132381, 11.57479, "Corneliusstraße 6, 80469 München"), openingTimes2));

			restaurantRepository.save(new Restaurant("Merhaba", "https://www.merhaba-restaurant.com", 4.6,
					List.of(new RestaurantImage("https://www.melares.com/uploads/turkish-foods72022865.jpg")),
					PriceCategory.CHEAP, List.of(Cuisine.TURKISH),
					new Location(48.126555, 11.596481, "Pariser Str. 9, 81669 München"), openingTimes3));

			restaurantRepository.save(new Restaurant("Pardi", "http://www.pardi-restaurant.de", 3.8,
					List.of(new RestaurantImage("https://www.melares.com/uploads/turkish-foods72022865.jpg")),
					PriceCategory.MEDIUM, List.of(Cuisine.TURKISH),
					new Location(48.155592, 11.534693, "Volkartstraße 24, 80634 München"), openingTimes1));

			restaurantRepository.save(new Restaurant("Abant", "https://www.abant-restaurant.de", 2.5,
					List.of(new RestaurantImage("https://www.melares.com/uploads/turkish-foods72022865.jpg")),
					PriceCategory.MEDIUM, List.of(Cuisine.TURKISH),
					new Location(48.133943, 11.541441, "Ligsalzstraße 46, 80339 München"), openingTimes2));

			//Fusion Restaurants -> 10
			restaurantRepository.save(new Restaurant("Opatija", "https://www.opatija-restaurant.com", 4.5,
					List.of(new RestaurantImage(
							"https://media01.stockfood.com/largepreviews/NDE0MzcyOTA4/13366868-Verschiedene-Fusion-Food-Snacks.jpg")),
					PriceCategory.MEDIUM, List.of(Cuisine.ITALIAN, Cuisine.BALKAN),
					new Location(48.13648, 11.579496, "Hochbrückenstraße 3, 80331 München"), openingTimes3));

			restaurantRepository.save(new Restaurant("Shami Kitchen", "https://shami-kitchen.de", 4.6,
					List.of(new RestaurantImage(
							"https://media01.stockfood.com/largepreviews/NDE0MzcyOTA4/13366868-Verschiedene-Fusion-Food-Snacks.jpg")),
					PriceCategory.EXPENSIVE, List.of(Cuisine.ASIAN, Cuisine.INDIAN),
					new Location(48.161889, 11.588807, "Marktstraße 6, 80802 München"), openingTimes2));

			restaurantRepository.save(new Restaurant("Baya", "http://www.baya.restaurant", 3.8,
					List.of(new RestaurantImage(
							"https://media01.stockfood.com/largepreviews/NDE0MzcyOTA4/13366868-Verschiedene-Fusion-Food-Snacks.jpg")),
					PriceCategory.MEDIUM, List.of(Cuisine.ASIAN, Cuisine.GERMAN),
					new Location(48.135445, 11.600848, "Einsteinstraße 42, 81675 München"), openingTimes1));

			restaurantRepository.save(new Restaurant("Peacock & Koi", "https://www.peacockandkoi.de", 4.9,
					List.of(new RestaurantImage(
							"https://media01.stockfood.com/largepreviews/NDE0MzcyOTA4/13366868-Verschiedene-Fusion-Food-Snacks.jpg")),
					PriceCategory.EXPENSIVE, List.of(Cuisine.ITALIAN, Cuisine.ASIAN, Cuisine.INDIAN),
					new Location(48.15042, 11.545431, "Nymphenburger Str. 92, 80636 München"), openingTimes0));

			restaurantRepository.save(new Restaurant("Cuno B", "http://www.cuno-b.de", 3.0, List.of(new RestaurantImage(
					"https://media01.stockfood.com/largepreviews/NDE0MzcyOTA4/13366868-Verschiedene-Fusion-Food-Snacks.jpg")),
					PriceCategory.CHEAP, List.of(Cuisine.ASIAN, Cuisine.INDIAN),
					new Location(48.133142, 11.578204, "Klenzestraße 8, 80469 München"), openingTimes3));

			restaurantRepository.save(new Restaurant("Chuc Bistro", "https://chuc-bistro.com", 3.3,
					List.of(new RestaurantImage(
							"https://media01.stockfood.com/largepreviews/NDE0MzcyOTA4/13366868-Verschiedene-Fusion-Food-Snacks.jpg")),
					PriceCategory.MEDIUM, List.of(Cuisine.ASIAN, Cuisine.ITALIAN),
					new Location(48.156607, 11.511935, "Südliche Auffahrtsallee, Notburgastraße 77"), openingTimes3));

			restaurantRepository.save(new Restaurant("La Barca",
					"https://de-de.facebook.com/pages/category/Asian-Restaurant/La-Barca-Feinkost-473005759434202/",
					3.7, List.of(new RestaurantImage(
					"https://media01.stockfood.com/largepreviews/NDE0MzcyOTA4/13366868-Verschiedene-Fusion-Food-Snacks.jpg")),
					PriceCategory.CHEAP, List.of(Cuisine.ITALIAN, Cuisine.INDIAN, Cuisine.ASIAN),
					new Location(48.14642, 11.631977, "Denninger Str. 170, 81927 München"), openingTimes2));

			restaurantRepository.save(new Restaurant("Riva Tal Bar", "https://www.riva-tal.de", 4.1,
					List.of(new RestaurantImage(
							"https://media01.stockfood.com/largepreviews/NDE0MzcyOTA4/13366868-Verschiedene-Fusion-Food-Snacks.jpg")),
					PriceCategory.MEDIUM, List.of(Cuisine.ITALIAN, Cuisine.GERMAN),
					new Location(48.135352, 11.581101, "Tal 44, 80331 München"), openingTimes2));

			restaurantRepository.save(new Restaurant("California Bean", "https://www.california-bean.de", 4.3,
					List.of(new RestaurantImage(
							"https://media01.stockfood.com/largepreviews/NDE0MzcyOTA4/13366868-Verschiedene-Fusion-Food-Snacks.jpg")),
					PriceCategory.EXPENSIVE, List.of(Cuisine.AMERICAN, Cuisine.GERMAN),
					new Location(48.142932, 11.560345, "Dachauer Str. 12, 80335 München"), openingTimes1));

			restaurantRepository.save(new Restaurant("HANS IM GLÜCK",
					"https://hansimglueck-burgergrill.de/burger-restaurant/muenchen-isartor/?utm_source=google&utm_medium=yext&utm_campaign=10",
					4.1, List.of(new RestaurantImage(
					"https://media01.stockfood.com/largepreviews/NDE0MzcyOTA4/13366868-Verschiedene-Fusion-Food-Snacks.jpg")),
					PriceCategory.EXPENSIVE, List.of(Cuisine.GERMAN, Cuisine.AMERICAN),
					new Location(48.13419, 11.582214, "Isartorpl. 8, 80331 München"), openingTimes0));

		};
	}

	@Bean @DependsOn("restaurant-samples") public CommandLineRunner insertRestaurantLayouts() {
		return (args) -> {
			List<Restaurant> restaurants = restaurantRepository.findAll();
			for (Restaurant restaurant : restaurants) {
				RestaurantLayout layout = RestaurantLayoutFactory.create(restaurant);
				restaurantLayoutRepository.save(layout);
			}
		};
	}

}
