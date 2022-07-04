package de.nullpointerexception.racetaurant.model;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Floor {
	@Id
	@GeneratedValue
	@JsonIgnore
	private Long id;

	private String name;

	@OneToOne(cascade = CascadeType.ALL)
	@NotNull
	private Shape bounds;

	@NotNull
	@OneToMany(cascade = CascadeType.ALL)
	@NotNull
	private List<StaticLayoutObject> objects;

	public Floor(String name, Shape bounds, List<StaticLayoutObject> objects) {
		this.name = name;
		this.bounds = bounds;
		this.objects = objects;
	}

	protected Floor() {

	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Shape getBounds() {
		return bounds;
	}

	public void setBounds(Shape bounds) {
		this.bounds = bounds;
	}

	public List<StaticLayoutObject> getObjects() {
		return objects;
	}

	public void setObjects(List<StaticLayoutObject> objects) {
		this.objects = objects;
	}
}
