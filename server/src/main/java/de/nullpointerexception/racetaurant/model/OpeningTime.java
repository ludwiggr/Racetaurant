package de.nullpointerexception.racetaurant.model;

import com.fasterxml.jackson.annotation.JsonValue;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.HashMap;
import java.util.Objects;

@Embeddable public class OpeningTime {
	private static final String CLOSED = "closed";

	@NotNull @Pattern(regexp = "^(([01]\\d|2[0-3]):([0-5]\\d)|closed)$", message = "Invalid time format for 'from'.") private String from = CLOSED;

	@NotNull @Pattern(regexp = "^(([01]\\d|2[0-3]):([0-5]\\d)|closed)$", message = "Invalid time format for 'to'.") private String to = CLOSED;

	public OpeningTime() {
		this.from = CLOSED;
		this.to = CLOSED;
	}

	public OpeningTime(String from, String to) {
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

	@JsonValue public Object getJSONValue() {
		if (Objects.equals(from, CLOSED) || Objects.equals(to, CLOSED)) {
			return "closed";
		} else {
			HashMap<String, String> result = new HashMap<>();
			result.put("from", this.from);
			result.put("to", this.to);
			return result;
		}
	}
}
