package de.nullpointerexception.racetaurant.model;

import java.util.UUID;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@DiscriminatorValue("restaurant")
public class RestaurantTable extends ShapedLayoutObject {
	@NotNull
	@Min(1)
	private int places;

	public RestaurantTable(Shape shape, int places) {
		super(shape, LayoutObjectType.TABLE);
		this.places = places;
	}

	protected RestaurantTable() {

	}

	public void setPlaces(int places) {
		this.places = places;
	}

	public int getPlaces() {
		return places;
	}

	@JsonIgnore(false)
	@Override
	public UUID getId() {
		return super.getId();
	}
}
