package de.nullpointerexception.racetaurant.model;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity @DiscriminatorValue("shaped-layout-object") public class ShapedLayoutObject extends StaticLayoutObject {
	@OneToOne(cascade = CascadeType.ALL) @NotNull private Shape shape;

	public ShapedLayoutObject(Shape shape, LayoutObjectType type) {
		super(type);
		this.shape = shape;
	}

	protected ShapedLayoutObject(LayoutObjectType type) {
		super(type);
	}

	protected ShapedLayoutObject() {

	}

	public Shape getShape() {
		return shape;
	}

	public void setShape(Shape shape) {
		this.shape = shape;
	}
}
