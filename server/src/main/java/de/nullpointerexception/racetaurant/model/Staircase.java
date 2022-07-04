package de.nullpointerexception.racetaurant.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
@DiscriminatorValue("staircase")
public class Staircase extends ShapedLayoutObject {
	@NotNull
	private int targetLevel;

	public Staircase(Shape shape, int targetLevel) {
		super(shape, LayoutObjectType.STAIRCASE);
		this.targetLevel = targetLevel;
	}

	protected Staircase() {

	}

	public int getTargetLevel() {
		return targetLevel;
	}

	public void setTargetLevel(int targetLevel) {
		this.targetLevel = targetLevel;
	}
}
