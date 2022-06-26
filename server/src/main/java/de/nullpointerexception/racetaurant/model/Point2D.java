package de.nullpointerexception.racetaurant.model;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable public class Point2D {
	@NotNull private double x;
	@NotNull private double y;

	public Point2D(double x, double y) {
		this.x = x;
		this.y = y;
	}

	protected Point2D() {

	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
}
