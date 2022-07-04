package de.nullpointerexception.racetaurant.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.URL;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;

@Entity
public class RestaurantImage {
	@Id
	@GeneratedValue
	@JsonIgnore
	private Long id;

	@NotNull
	@Column(length = 400)
	@URL
	private String url;

	protected RestaurantImage() {

	}

	public RestaurantImage(String url) {
		this.url = url;
	}

	@JsonValue
	public String getUrl() {
		return url;
	}

	public Long getId() {
		return id;
	}
}
