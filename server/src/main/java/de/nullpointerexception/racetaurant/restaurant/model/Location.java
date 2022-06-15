package de.nullpointerexception.racetaurant.restaurant.model;

import javax.persistence.Embeddable;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Embeddable
public class Location {

	@NotNull @Min(value = -90, message = "A location's minimum latitude is -90.") @Max(value = 90, message = "A location's maximum latitude is 90.") private double latitude;

	@NotNull @Min(value = -90, message = "A location's minimum longitude is -90.") @Max(value = 90, message = "A location's maximum longitude is 90.") private double longitude;

	@NotNull private String address;

	protected Location() {

	}

	public Location(double latitude, double longitude, String address) {
		this.latitude = latitude;
		this.longitude = longitude;
		this.address = address;
	}

	public double getLatitude() {
		return latitude;
	}

	private void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	private void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getAddress() {
		return address;
	}

	private void setAddress(String address) {
		this.address = address;
	}

}
