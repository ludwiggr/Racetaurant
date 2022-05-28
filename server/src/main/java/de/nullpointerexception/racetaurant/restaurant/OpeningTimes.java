package de.nullpointerexception.racetaurant.restaurant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity @Table(name = "restaurantsOpeningTimes") public class OpeningTimes {
	@Id @GeneratedValue private Long id;

	private LocalDate mondayFrom;
	private LocalDate mondayTo;

	private LocalDate tuesdayFrom;
	private LocalDate tuesDayTo;

	private LocalDate wednesdayFrom;
	private LocalDate wednesdayTo;

	private LocalDate thursdayFrom;
	private LocalDate thursdayTo;

	private LocalDate fridayFrom;
	private LocalDate fridayTo;

	private LocalDate saturdayFrom;
	private LocalDate saturdayTo;

	public OpeningTimes() {

	}

	public OpeningTimes(LocalDate mondayFrom, LocalDate mondayTo, LocalDate tuesdayFrom, LocalDate tuesDayTo,
			LocalDate wednesdayFrom, LocalDate wednesdayTo, LocalDate thursdayFrom, LocalDate thursdayTo,
			LocalDate fridayFrom, LocalDate fridayTo, LocalDate saturdayFrom, LocalDate saturdayTo) {
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

	public LocalDate getMondayFrom() {
		return mondayFrom;
	}

	public void setMondayFrom(LocalDate mondayFrom) {
		this.mondayFrom = mondayFrom;
	}

	public LocalDate getMondayTo() {
		return mondayTo;
	}

	public void setMondayTo(LocalDate mondayTo) {
		this.mondayTo = mondayTo;
	}

	public LocalDate getTuesdayFrom() {
		return tuesdayFrom;
	}

	public void setTuesdayFrom(LocalDate tuesdayFrom) {
		this.tuesdayFrom = tuesdayFrom;
	}

	public LocalDate getTuesDayTo() {
		return tuesDayTo;
	}

	public void setTuesDayTo(LocalDate tuesDayTo) {
		this.tuesDayTo = tuesDayTo;
	}

	public LocalDate getWednesdayFrom() {
		return wednesdayFrom;
	}

	public void setWednesdayFrom(LocalDate wednesdayFrom) {
		this.wednesdayFrom = wednesdayFrom;
	}

	public LocalDate getWednesdayTo() {
		return wednesdayTo;
	}

	public void setWednesdayTo(LocalDate wednesdayTo) {
		this.wednesdayTo = wednesdayTo;
	}

	public LocalDate getThursdayFrom() {
		return thursdayFrom;
	}

	public void setThursdayFrom(LocalDate thursdayFrom) {
		this.thursdayFrom = thursdayFrom;
	}

	public LocalDate getThursdayTo() {
		return thursdayTo;
	}

	public void setThursdayTo(LocalDate thursdayTo) {
		this.thursdayTo = thursdayTo;
	}

	public LocalDate getFridayFrom() {
		return fridayFrom;
	}

	public void setFridayFrom(LocalDate fridayFrom) {
		this.fridayFrom = fridayFrom;
	}

	public LocalDate getFridayTo() {
		return fridayTo;
	}

	public void setFridayTo(LocalDate fridayTo) {
		this.fridayTo = fridayTo;
	}

	public LocalDate getSaturdayFrom() {
		return saturdayFrom;
	}

	public void setSaturdayFrom(LocalDate saturdayFrom) {
		this.saturdayFrom = saturdayFrom;
	}

	public LocalDate getSaturdayTo() {
		return saturdayTo;
	}

	public void setSaturdayTo(LocalDate saturdayTo) {
		this.saturdayTo = saturdayTo;
	}
}
