package de.nullpointerexception.racetaurant.restaurant;

import java.util.Arrays;
import java.util.Objects;

public record Restaurant(String id, String name, String website, double rating, String[] images,
		PriceCategory priceCategory, Cuisine[] cuisines, Location location, RestaurantLayout layout,
		OpeningTimes times) {

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(cuisines);
		result = prime * result + Arrays.hashCode(images);
		result = prime * result + Objects.hash(id, layout, location, name, priceCategory, rating, times, website);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Restaurant other = (Restaurant) obj;
		return Arrays.equals(cuisines, other.cuisines) && Objects.equals(id, other.id)
				&& Arrays.equals(images, other.images) && Objects.equals(layout, other.layout)
				&& Objects.equals(location, other.location) && Objects.equals(name, other.name)
				&& priceCategory == other.priceCategory
				&& Double.doubleToLongBits(rating) == Double.doubleToLongBits(other.rating)
				&& Objects.equals(times, other.times) && Objects.equals(website, other.website);
	}

	@Override
	public String toString() {
		return "Restaurant [id=" + id + ", name=" + name + ", website=" + website + ", rating=" + rating + ", images="
				+ Arrays.toString(images) + ", priceCategory=" + priceCategory + ", cuisines="
				+ Arrays.toString(cuisines) + ", location=" + location + ", layout=" + layout + ", times=" + times
				+ "]";
	}

}
