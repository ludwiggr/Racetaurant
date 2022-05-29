package de.nullpointerexception.racetaurant.restaurant.model;

import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.UUID;

@Entity @Table(name = "restaurants") public class Restaurant {
	@Id @GeneratedValue(strategy = GenerationType.AUTO) @Column(name = "id", insertable = false, updatable = false, nullable = false) private UUID id;
	@NotNull private String name;
	@NotNull @URL private String website;
	@NotNull private double rating;
	@OneToMany(cascade = CascadeType.ALL) @JoinColumn(name = "imageId") @NotNull @Size(min = 1, message = "At least one image per restaurant is required.") private List<RestaurantImage> restaurantImages;

	@NotNull private PriceCategory priceCategory;

	@NotNull @ElementCollection(targetClass = Cuisine.class) @JoinTable(name = "restaurantsCuisines", joinColumns = @JoinColumn(name = "id")) @Column(name = "cuisine", nullable = false) @Enumerated(EnumType.STRING) private List<Cuisine> cuisines;
	@NotNull @OneToOne(optional = false, cascade = CascadeType.ALL) @JoinColumn(name = "locationId", referencedColumnName = "id") private Location location;
	@NotNull @OneToOne(optional = false, cascade = CascadeType.ALL) @JoinColumn(name = "layoutId", referencedColumnName = "id") private RestaurantLayout layout;
	@NotNull @OneToOne(optional = false, cascade = CascadeType.ALL) @JoinColumn(name = "openingTimesId", referencedColumnName = "id") private OpeningTimes open;

	protected Restaurant() {

	}

	public Restaurant(String name, String website, double rating, List<RestaurantImage> restaurantImages,
			PriceCategory priceCategory, List<Cuisine> cuisines, Location location, RestaurantLayout layout,
			OpeningTimes open) {
		this.name = name;
		this.website = website;
		this.rating = rating;
		this.restaurantImages = restaurantImages;
		this.priceCategory = priceCategory;
		this.cuisines = cuisines;
		this.location = location;
		this.layout = layout;
		this.open = open;
	}

	public UUID getId() {
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

	public OpeningTimes getOpen() {
		return open;
	}

	public void setOpen(OpeningTimes times) {
		this.open = times;
	}
}
