package de.nullpointerexception.racetaurant.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
@DiscriminatorValue("circle")
public class Circle extends Shape {
	@NotNull
	private double x;
	@NotNull
	private double y;
	@NotNull
	private double radius;

	public Circle(double x, double y, double radius) {
		super(ShapeType.circle);
		this.x = x;
		this.y = y;
		this.radius = radius;
	}

	protected Circle() {

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

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	@Override
	public Circle clone() {
		return new Circle(x, y, radius);
	}
}
