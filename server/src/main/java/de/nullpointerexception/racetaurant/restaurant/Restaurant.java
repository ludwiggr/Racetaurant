package de.nullpointerexception.racetaurant.restaurant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Arrays;
import java.util.Objects;

@Entity public class Restaurant {
	@Id
	@GeneratedValue
	private String id;
	private String name;
	private String website;
	private double rating;
	private String[] images;
	private PriceCategory priceCategory;
	private Cuisine[] cuisines;
	private Location location;
	private RestaurantLayout layout;
	private OpeningTimes times;

	Restaurant(){

	}

	public Restaurant(String name, String website, double rating, String[] images, PriceCategory priceCategory,
			Cuisine[] cuisines, Location location, RestaurantLayout layout, OpeningTimes times) {
		this.name = name;
		this.website = website;
		this.rating = rating;
		this.images = images;
		this.priceCategory = priceCategory;
		this.cuisines = cuisines;
		this.location = location;
		this.layout = layout;
		this.times = times;
	}

	@Override public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(cuisines);
		result = prime * result + Arrays.hashCode(images);
		result = prime * result + Objects.hash(id, layout, location, name, priceCategory, rating, times, website);
		return result;
	}

	@Override public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Restaurant other = (Restaurant) obj;
		return Arrays.equals(cuisines, other.cuisines) && Objects.equals(id, other.id) && Arrays.equals(images,
				other.images) && Objects.equals(layout, other.layout) && Objects.equals(location,
				other.location) && Objects.equals(name,
				other.name) && priceCategory == other.priceCategory && Double.doubleToLongBits(
				rating) == Double.doubleToLongBits(other.rating) && Objects.equals(times,
				other.times) && Objects.equals(website, other.website);
	}

	@Override public String toString() {
		return "Restaurant [id=" + id + ", name=" + name + ", website=" + website + ", rating=" + rating + ", images=" + Arrays.toString(
				images) + ", priceCategory=" + priceCategory + ", cuisines=" + Arrays.toString(
				cuisines) + ", location=" + location + ", layout=" + layout + ", times=" + times + "]";
	}

	public String getId() {
		return id;
	}

	private void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}

	public String getWebsite() {
		return website;
	}

	private void setWebsite(String website) {
		this.website = website;
	}

	public double getRating() {
		return rating;
	}

	private void setRating(double rating) {
		this.rating = rating;
	}

	public String[] getImages() {
		return images;
	}

	private void setImages(String[] images) {
		this.images = images;
	}

	public PriceCategory getPriceCategory() {
		return priceCategory;
	}

	private void setPriceCategory(PriceCategory priceCategory) {
		this.priceCategory = priceCategory;
	}

	public Cuisine[] getCuisines() {
		return cuisines;
	}

	private void setCuisines(Cuisine[] cuisines) {
		this.cuisines = cuisines;
	}

	public Location getLocation() {
		return location;
	}

	private void setLocation(Location location) {
		this.location = location;
	}

	public RestaurantLayout getLayout() {
		return layout;
	}

	private void setLayout(RestaurantLayout layout) {
		this.layout = layout;
	}

	public OpeningTimes getTimes() {
		return times;
	}

	private void setTimes(OpeningTimes times) {
		this.times = times;
	}
}
