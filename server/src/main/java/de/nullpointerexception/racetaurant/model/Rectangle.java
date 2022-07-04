package de.nullpointerexception.racetaurant.model;

import javax.persistence.Entity;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class Rectangle extends Shape {
	@NotNull
	private double x;
	@NotNull
	private double y;
	@NotNull
	@Min(0)
	private double width;
	@NotNull
	@Min(0)
	private double height;
	@NotNull
	private double rotation;

	public Rectangle(double x, double y, double width, double height, double rotation) {
		super(ShapeType.rectangle);
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.rotation = rotation;
	}

	protected Rectangle() {

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

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getRotation() {
		return rotation;
	}

	public void setRotation(double rotation) {
		this.rotation = rotation;
	}

	@Override
	public Rectangle clone() {
		return new Rectangle(x, y, width, height, rotation);
	}
}
