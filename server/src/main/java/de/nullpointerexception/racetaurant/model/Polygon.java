package de.nullpointerexception.racetaurant.model;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class Polygon extends Shape {
	@ElementCollection
	@NotNull
	private List<Point2D> points;
	@NotNull
	private boolean open;

	public Polygon(List<Point2D> points, boolean open) {
		super(ShapeType.polygon);
		this.points = points;
		this.open = open;
	}

	protected Polygon() {

	}

	public List<Point2D> getPoints() {
		return points;
	}

	public void setPoints(List<Point2D> points) {
		this.points = points;
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	@Override
	public Polygon clone() {
		return new Polygon(List.copyOf(this.points), open);
	}
}
