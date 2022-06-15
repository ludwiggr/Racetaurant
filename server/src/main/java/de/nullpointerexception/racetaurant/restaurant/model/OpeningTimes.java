package de.nullpointerexception.racetaurant.restaurant.model;

import javax.persistence.*;

@Embeddable
public class OpeningTimes {
	private static final String CLOSED = "closed";

	@AttributeOverride(name = "from", column = @Column(name = "MONDAY_FROM"))
	@AttributeOverride(name = "to", column = @Column(name = "MONDAY_TO"))
	@Embedded
	private OpeningTime monday;

	@AttributeOverride(name = "from", column = @Column(name = "TUESDAY_FROM"))
	@AttributeOverride(name = "to", column = @Column(name = "TUESDAY_TO"))
	@Embedded
	private OpeningTime tuesday;

	@AttributeOverride(name = "from", column = @Column(name = "WEDNESDAY_FROM"))
	@AttributeOverride(name = "to", column = @Column(name = "WEDNESDAY_TO"))
	@Embedded
	private OpeningTime wednesday;

	@AttributeOverride(name = "from", column = @Column(name = "THURSDAY_FROM"))
	@AttributeOverride(name = "to", column = @Column(name = "THURSDAY_TO"))
	@Embedded
	private OpeningTime thursday;

	@AttributeOverride(name = "from", column = @Column(name = "FRIDAY_FROM"))
	@AttributeOverride(name = "to", column = @Column(name = "FRIDAY_TO"))
	@Embedded
	private OpeningTime friday;

	@AttributeOverride(name = "from", column = @Column(name = "SATURDAY_FROM"))
	@AttributeOverride(name = "to", column = @Column(name = "SATURDAY_TO"))
	@Embedded
	private OpeningTime saturday;

	@AttributeOverride(name = "from", column = @Column(name = "SUNDAY_FROM"))
	@AttributeOverride(name = "to", column = @Column(name = "SUNDAY_TO"))
	@Embedded
	private OpeningTime sunday;

	public OpeningTimes() {
		setMonday(null);
		setTuesday(null);
		setWednesday(null);
		setThursday(null);
		setFriday(null);
		setSaturday(null);
		setSunday(null);
	}

	public OpeningTimes(OpeningTime monday, OpeningTime tuesday, OpeningTime wednesday, OpeningTime thursday,
			OpeningTime friday, OpeningTime saturday, OpeningTime sunday) {
		setMonday(monday);
		setTuesday(tuesday);
		setWednesday(wednesday);
		setThursday(thursday);
		setFriday(friday);
		setSaturday(saturday);
		setSunday(sunday);
	}

	public OpeningTime getMonday() {
		return monday;
	}

	public void setMonday(OpeningTime monday) {
		if (monday == null) {
			this.monday = new OpeningTime();
		} else {
			this.monday = monday;
		}
	}

	public OpeningTime getTuesday() {
		return tuesday;
	}

	public void setTuesday(OpeningTime tuesday) {
		if (tuesday == null) {
			this.tuesday = new OpeningTime();
		} else {
			this.tuesday = tuesday;
		}
	}

	public OpeningTime getWednesday() {
		return wednesday;
	}

	public void setWednesday(OpeningTime wednesday) {
		if (wednesday == null) {
			this.wednesday = new OpeningTime();
		} else {
			this.wednesday = wednesday;
		}
	}

	public OpeningTime getThursday() {
		return thursday;
	}

	public void setThursday(OpeningTime thursday) {
		if (thursday == null) {
			this.thursday = new OpeningTime();
		} else {
			this.thursday = thursday;
		}
	}

	public OpeningTime getFriday() {
		return friday;
	}

	public void setFriday(OpeningTime friday) {
		if (friday == null) {
			this.friday = new OpeningTime();
		} else {
			this.friday = friday;
		}
	}

	public OpeningTime getSaturday() {
		return saturday;
	}

	public void setSaturday(OpeningTime saturday) {
		if (saturday == null) {
			this.saturday = new OpeningTime();
		} else {
			this.saturday = saturday;
		}
	}

	public OpeningTime getSunday() {
		return sunday;
	}

	public void setSunday(OpeningTime sunday) {
		if (sunday == null) {
			this.sunday = new OpeningTime();
		} else {
			this.sunday = sunday;
		}
	}
}
