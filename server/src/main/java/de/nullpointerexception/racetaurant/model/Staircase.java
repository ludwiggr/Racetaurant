package de.nullpointerexception.racetaurant.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity @DiscriminatorValue("staircase") public class Staircase extends StaticLayoutObject {
	@NotNull private int targetLevel;

	public Staircase(int targetLevel) {
		super(LayoutObjectType.STAIRCASE);
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
