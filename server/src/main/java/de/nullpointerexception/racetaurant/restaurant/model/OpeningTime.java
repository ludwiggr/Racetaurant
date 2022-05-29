package de.nullpointerexception.racetaurant.restaurant.model;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Embeddable public class OpeningTime {
	private static final String CLOSED = "closed";

	@NotNull @Pattern(regexp = "^(([01]\\d|2[0-3]):([0-5]\\d)|closed)$", message = "Invalid time format for 'mondayFrom'.") private String from = CLOSED;

	@NotNull @Pattern(regexp = "^(([01]\\d|2[0-3]):([0-5]\\d)|closed)$", message = "Invalid time format for 'mondayTo'.") private String to = CLOSED;

	public OpeningTime() {
		this.from = CLOSED;
		this.to = CLOSED;
	}

	public OpeningTime(String from, String closed) {
		setFrom(from);
		setTo(to);
	}

	public void setFrom(String from) {
		if (from == null) {
			this.from = CLOSED;
			this.to = CLOSED;
		} else {
			this.from = from;
		}
	}

	public String getFrom() {
		return from;
	}

	public void setTo(String to) {
		if (to == null) {
			this.from = CLOSED;
			this.to = CLOSED;
		} else {
			this.to = to;
		}
	}

	public String getTo() {
		return to;
	}
}
