package de.nullpointerexception.racetaurant.restaurant.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity @Table(name = "restaurantsOpeningTimes") public class OpeningTimes {
	@Id @GeneratedValue private Long id;
	private static final String CLOSED = "closed";

	@NotNull @Pattern(regexp = "^(([01]\\d|2[0-3]):([0-5]\\d)|closed)$", message = "Invalid time format for 'mondayFrom'.") private String mondayFrom = CLOSED;

	@NotNull @Pattern(regexp = "^(([01]\\d|2[0-3]):([0-5]\\d)|closed)$", message = "Invalid time format for 'mondayTo'.") private String mondayTo = CLOSED;

	@NotNull @Pattern(regexp = "^(([01]\\d|2[0-3]):([0-5]\\d)|closed)$", message = "Invalid time format for 'tuesdayFrom'.") private String tuesdayFrom = CLOSED;

	@NotNull @Pattern(regexp = "^(([01]\\d|2[0-3]):([0-5]\\d)|closed)$", message = "Invalid time format for 'tuesdayTo'.") private String tuesDayTo = CLOSED;
	@NotNull @Pattern(regexp = "^(([01]\\d|2[0-3]):([0-5]\\d)|closed)$", message = "Invalid time format for 'wednesdayFrom'.") private String wednesdayFrom = CLOSED;
	@NotNull @Pattern(regexp = "^(([01]\\d|2[0-3]):([0-5]\\d)|closed)$", message = "Invalid time format for 'wednesdayTo'.") private String wednesdayTo = CLOSED;
	@NotNull @Pattern(regexp = "^(([01]\\d|2[0-3]):([0-5]\\d)|closed)$", message = "Invalid time format for 'thursdayFrom'.") private String thursdayFrom = CLOSED;
	@NotNull @Pattern(regexp = "^(([01]\\d|2[0-3]):([0-5]\\d)|closed)$", message = "Invalid time format for 'thursdayTo'.") private String thursdayTo = CLOSED;

	@NotNull @Pattern(regexp = "^(([01]\\d|2[0-3]):([0-5]\\d)|closed)$", message = "Invalid time format for 'fridayFrom'.") private String fridayFrom = CLOSED;
	@NotNull @Pattern(regexp = "^(([01]\\d|2[0-3]):([0-5]\\d)|closed)$", message = "Invalid time format for 'fridayTo'.") private String fridayTo = CLOSED;

	@NotNull @Pattern(regexp = "^(([01]\\d|2[0-3]):([0-5]\\d)|closed)$", message = "Invalid time format for 'saturdayFrom'.") private String saturdayFrom = CLOSED;
	@NotNull @Pattern(regexp = "^(([01]\\d|2[0-3]):([0-5]\\d)|closed)$", message = "Invalid time format for 'saturdayTo'.") private String saturdayTo = CLOSED;

	@NotNull @Pattern(regexp = "^(([01]\\d|2[0-3]):([0-5]\\d)|closed)$", message = "Invalid time format for 'sundayFrom'.") private String sundayFrom = CLOSED;
	@NotNull @Pattern(regexp = "^(([01]\\d|2[0-3]):([0-5]\\d)|closed)$", message = "Invalid time format for 'sundayTo'.") private String sundayTo = CLOSED;

	public OpeningTimes() {

	}

	public OpeningTimes(String mondayFrom, String mondayTo, String tuesdayFrom, String tuesDayTo, String wednesdayFrom,
			String wednesdayTo, String thursdayFrom, String thursdayTo, String fridayFrom, String fridayTo,
			String saturdayFrom, String saturdayTo, String sundayFrom, String sundayTo) {
		setMondayFrom(mondayFrom);
		setMondayTo(mondayTo);

		setTuesdayFrom(tuesdayFrom);
		setTuesDayTo(tuesDayTo);

		setWednesdayFrom(wednesdayFrom);
		setWednesdayTo(wednesdayTo);

		setThursdayFrom(thursdayFrom);
		setThursdayTo(thursdayTo);

		setFridayFrom(fridayFrom);
		setFridayTo(fridayTo);

		setSaturdayFrom(saturdayFrom);
		setSaturdayTo(saturdayTo);

		setSundayFrom(sundayFrom);
		setSundayTo(sundayTo);
	}

	public Long getId() {
		return id;
	}

	public String getMondayFrom() {
		return mondayFrom;
	}

	public void setMondayFrom(String mondayFrom) {
		if (mondayFrom == null)
			mondayFrom = CLOSED;
		this.mondayFrom = mondayFrom;
	}

	public String getMondayTo() {
		return mondayTo;
	}

	public void setMondayTo(String mondayTo) {
		if (mondayTo == null)
			mondayTo = CLOSED;
		this.mondayTo = mondayTo;
	}

	public String getTuesdayFrom() {
		return tuesdayFrom;
	}

	public void setTuesdayFrom(String tuesdayFrom) {
		if (tuesdayFrom == null)
			tuesdayFrom = CLOSED;
		this.tuesdayFrom = tuesdayFrom;
	}

	public String getTuesDayTo() {
		return tuesDayTo;
	}

	public void setTuesDayTo(String tuesDayTo) {
		if (tuesDayTo == null)
			tuesDayTo = CLOSED;
		this.tuesDayTo = tuesDayTo;
	}

	public String getWednesdayFrom() {
		return wednesdayFrom;
	}

	public void setWednesdayFrom(String wednesdayFrom) {
		if (wednesdayFrom == null)
			wednesdayFrom = CLOSED;
		this.wednesdayFrom = wednesdayFrom;
	}

	public String getWednesdayTo() {
		return wednesdayTo;
	}

	public void setWednesdayTo(String wednesdayTo) {
		if (wednesdayTo == null)
			wednesdayTo = CLOSED;
		this.wednesdayTo = wednesdayTo;
	}

	public String getThursdayFrom() {
		return thursdayFrom;
	}

	public void setThursdayFrom(String thursdayFrom) {
		if (thursdayFrom == null)
			thursdayFrom = CLOSED;
		this.thursdayFrom = thursdayFrom;
	}

	public String getThursdayTo() {
		return thursdayTo;
	}

	public void setThursdayTo(String thursdayTo) {
		if (thursdayTo == null)
			thursdayTo = CLOSED;
		this.thursdayTo = thursdayTo;
	}

	public String getFridayFrom() {
		return fridayFrom;
	}

	public void setFridayFrom(String fridayFrom) {
		if (fridayFrom == null)
			fridayFrom = CLOSED;
		this.fridayFrom = fridayFrom;
	}

	public String getFridayTo() {
		return fridayTo;
	}

	public void setFridayTo(String fridayTo) {
		if (fridayTo == null)
			fridayTo = CLOSED;
		this.fridayTo = fridayTo;
	}

	public String getSaturdayFrom() {
		return saturdayFrom;
	}

	public void setSaturdayFrom(String saturdayFrom) {
		if (saturdayFrom == null)
			saturdayFrom = CLOSED;
		this.saturdayFrom = saturdayFrom;
	}

	public String getSaturdayTo() {
		return saturdayTo;
	}

	public void setSaturdayTo(String saturdayTo) {
		if (saturdayTo == null)
			saturdayTo = CLOSED;
		this.saturdayTo = saturdayTo;
	}

	public String getSundayTo() {
		return sundayTo;
	}

	public void setSundayTo(String sundayTo) {
		if (sundayTo == null)
			sundayTo = CLOSED;
		this.sundayTo = sundayTo;
	}

	public String getSundayFrom() {
		return sundayFrom;
	}

	public void setSundayFrom(String sundayFrom) {
		if (sundayFrom == null)
			sundayFrom = CLOSED;
		this.sundayFrom = sundayFrom;
	}
}
