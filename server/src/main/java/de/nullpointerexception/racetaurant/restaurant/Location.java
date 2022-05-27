package de.nullpointerexception.racetaurant.restaurant;

public class Location {
	private double latitude;
	private double longitude;
	private String address;

	Location(){

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
