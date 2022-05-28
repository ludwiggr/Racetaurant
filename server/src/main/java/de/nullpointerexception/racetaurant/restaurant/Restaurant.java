package de.nullpointerexception.racetaurant.restaurant;

import javax.persistence.*;
import java.util.List;

@Entity @Table(name = "restaurants") public class Restaurant {
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE) private String id;
	private String name;
	private String website;
	private double rating;
	@OneToMany(mappedBy = "restaurant") private List<RestaurantImage> restaurantImages;
	private PriceCategory priceCategory;
	@ManyToMany(cascade = { CascadeType.MERGE,
			CascadeType.PERSIST }) @JoinTable(name = "restaurantCuisines", joinColumns = @JoinColumn(name = "restaurantId", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "cuisineId", referencedColumnName = "id")) private List<Cuisine> cuisines;
	@OneToOne(optional = false, cascade = CascadeType.ALL) @JoinColumn(name = "locationId", referencedColumnName = "id") private Location location;
	// Restaurant layouts are optional because we haven't implemented them yet
	@OneToOne(optional = true, cascade = CascadeType.ALL) @JoinColumn(name = "layoutId", referencedColumnName = "id") private RestaurantLayout layout;
	@OneToOne(optional = false, cascade = CascadeType.ALL) @JoinColumn(name = "openingTimesId", referencedColumnName = "id") private OpeningTimes times;

	protected Restaurant() {

	}

	public Restaurant(String name, String website, double rating, List<RestaurantImage> restaurantImages,
			PriceCategory priceCategory, List<Cuisine> cuisines, Location location, RestaurantLayout layout,
			OpeningTimes times) {
		this.name = name;
		this.website = website;
		this.rating = rating;
		this.restaurantImages = restaurantImages;
		this.priceCategory = priceCategory;
		this.cuisines = cuisines;
		this.location = location;
		this.layout = layout;
		this.times = times;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public List<RestaurantImage> getRestaurantImages() {
		return restaurantImages;
	}

	public void setRestaurantImages(List<RestaurantImage> restaurantImages) {
		this.restaurantImages = restaurantImages;
	}

	public PriceCategory getPriceCategory() {
		return priceCategory;
	}

	public void setPriceCategory(PriceCategory priceCategory) {
		this.priceCategory = priceCategory;
	}

	public List<Cuisine> getCuisines() {
		return cuisines;
	}

	public void setCuisines(List<Cuisine> cuisines) {
		this.cuisines = cuisines;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public RestaurantLayout getLayout() {
		return layout;
	}

	public void setLayout(RestaurantLayout layout) {
		this.layout = layout;
	}

	public OpeningTimes getTimes() {
		return times;
	}

	public void setTimes(OpeningTimes times) {
		this.times = times;
	}
}
