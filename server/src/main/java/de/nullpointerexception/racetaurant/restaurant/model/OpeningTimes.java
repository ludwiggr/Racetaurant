package de.nullpointerexception.racetaurant.restaurant.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity @Table(name = "restaurantsOpeningTimes") public class OpeningTimes {
	@Id @GeneratedValue private Long id;

	private String mondayFrom;
	private String mondayTo;

	private String tuesdayFrom;
	private String tuesDayTo;

	private String wednesdayFrom;
	private String wednesdayTo;

	private String thursdayFrom;
	private String thursdayTo;

	private String fridayFrom;
	private String fridayTo;

	private String saturdayFrom;
	private String saturdayTo;

	public OpeningTimes() {

	}

	public OpeningTimes(String mondayFrom, String mondayTo, String tuesdayFrom, String tuesDayTo, String wednesdayFrom,
			String wednesdayTo, String thursdayFrom, String thursdayTo, String fridayFrom, String fridayTo,
			String saturdayFrom, String saturdayTo) {
		this.mondayFrom = mondayFrom;
		this.mondayTo = mondayTo;
		this.tuesdayFrom = tuesdayFrom;
		this.tuesDayTo = tuesDayTo;
		this.wednesdayFrom = wednesdayFrom;
		this.wednesdayTo = wednesdayTo;
		this.thursdayFrom = thursdayFrom;
		this.thursdayTo = thursdayTo;
		this.fridayFrom = fridayFrom;
		this.fridayTo = fridayTo;
		this.saturdayFrom = saturdayFrom;
		this.saturdayTo = saturdayTo;
	}

	public Long getId() {
		return id;
	}

	public String getMondayFrom() {
		return mondayFrom;
	}

	public void setMondayFrom(String mondayFrom) {
		this.mondayFrom = mondayFrom;
	}

	public String getMondayTo() {
		return mondayTo;
	}

	public void setMondayTo(String mondayTo) {
		this.mondayTo = mondayTo;
	}

	public String getTuesdayFrom() {
		return tuesdayFrom;
	}

	public void setTuesdayFrom(String tuesdayFrom) {
		this.tuesdayFrom = tuesdayFrom;
	}

	public String getTuesDayTo() {
		return tuesDayTo;
	}

	public void setTuesDayTo(String tuesDayTo) {
		this.tuesDayTo = tuesDayTo;
	}

	public String getWednesdayFrom() {
		return wednesdayFrom;
	}

	public void setWednesdayFrom(String wednesdayFrom) {
		this.wednesdayFrom = wednesdayFrom;
	}

	public String getWednesdayTo() {
		return wednesdayTo;
	}

	public void setWednesdayTo(String wednesdayTo) {
		this.wednesdayTo = wednesdayTo;
	}

	public String getThursdayFrom() {
		return thursdayFrom;
	}

	public void setThursdayFrom(String thursdayFrom) {
		this.thursdayFrom = thursdayFrom;
	}

	public String getThursdayTo() {
		return thursdayTo;
	}

	public void setThursdayTo(String thursdayTo) {
		this.thursdayTo = thursdayTo;
	}

	public String getFridayFrom() {
		return fridayFrom;
	}

	public void setFridayFrom(String fridayFrom) {
		this.fridayFrom = fridayFrom;
	}

	public String getFridayTo() {
		return fridayTo;
	}

	public void setFridayTo(String fridayTo) {
		this.fridayTo = fridayTo;
	}

	public String getSaturdayFrom() {
		return saturdayFrom;
	}

	public void setSaturdayFrom(String saturdayFrom) {
		this.saturdayFrom = saturdayFrom;
	}

	public String getSaturdayTo() {
		return saturdayTo;
	}

	public void setSaturdayTo(String saturdayTo) {
		this.saturdayTo = saturdayTo;
	}
}
