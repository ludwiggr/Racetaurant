package de.nullpointerexception.racetaurant.model;

import java.util.List;
import java.util.UUID;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.URL;

@Entity
@Table(name = "restaurants")
public class Restaurant {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", insertable = false, updatable = false, nullable = false)
	private UUID id;
	@NotNull
	private String name;
	@NotNull
	@URL
	private String website;
	@NotNull
	@Min(value = 0, message = "The minimum average rating is 0.")
	@Max(value = 5, message = "The maximum average rating is 5.")
	private double rating;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "imageId")
	@NotNull
	@Size(min = 1, message = "At least one image per restaurant is required.")
	private List<RestaurantImage> images;

	@NotNull
	private PriceCategory priceCategory;

	@NotNull
	@ElementCollection(targetClass = Cuisine.class)
	@JoinTable(name = "restaurantsCuisines", joinColumns = @JoinColumn(name = "id"))
	@Column(name = "cuisine", nullable = false)
	@Enumerated(EnumType.STRING)
	private List<Cuisine> cuisines;
	@NotNull
	@Embedded
	private Location location;
	@NotNull
	@Embedded
	private OpeningTimes open;

	protected Restaurant() {

	}

	public Restaurant(String name, String website, double rating, List<RestaurantImage> images,
			PriceCategory priceCategory, List<Cuisine> cuisines, Location location, OpeningTimes open) {
		this.name = name;
		this.website = website;
		this.rating = rating;
		this.images = images;
		this.priceCategory = priceCategory;
		this.cuisines = cuisines;
		this.location = location;
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

	public List<RestaurantImage> getImages() {
		return images;
	}

	public void setImages(List<RestaurantImage> restaurantImages) {
		this.images = restaurantImages;
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

	public OpeningTimes getOpen() {
		return open;
	}

	public void setOpen(OpeningTimes times) {
		this.open = times;
	}
}
