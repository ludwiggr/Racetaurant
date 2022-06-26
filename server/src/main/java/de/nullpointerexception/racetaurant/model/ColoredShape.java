package de.nullpointerexception.racetaurant.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity @DiscriminatorValue("colored-shape") public class ColoredShape extends ShapedLayoutObject {
	@NotNull private LayoutColor color;

	public ColoredShape(LayoutColor color, Shape shape) {
		super(shape, LayoutObjectType.COLORED_SHAPE);
		this.color = color;
	}

	protected ColoredShape() {

	}

	public void setColor(LayoutColor color) {
		this.color = color;
	}

	public LayoutColor getColor() {
		return color;
	}

}
