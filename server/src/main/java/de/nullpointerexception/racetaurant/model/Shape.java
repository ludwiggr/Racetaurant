package de.nullpointerexception.racetaurant.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity @Inheritance(strategy = InheritanceType.JOINED) public abstract class Shape {
	@Id @GeneratedValue @JsonIgnore private Long id;

	private ShapeType type;

	public Shape(ShapeType type) {
		this.type = type;
	}

	protected Shape() {

	}

	public Long getId() {
		return id;
	}

	public ShapeType getType() {
		return type;
	}

	@Override public abstract Shape clone();
}
