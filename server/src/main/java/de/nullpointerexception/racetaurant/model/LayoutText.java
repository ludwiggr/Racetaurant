package de.nullpointerexception.racetaurant.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity @DiscriminatorValue("text") public class LayoutText extends StaticLayoutObject {
	@NotNull private String text;
	@NotNull private double x;
	@NotNull private double y;
	@NotNull private int fontSize;
	@NotNull private LayoutColor color;

	public LayoutText(String text, double x, double y, int fontSize, LayoutColor color) {
		super(LayoutObjectType.TEXT);
		this.text = text;
		this.x = x;
		this.y = y;
		this.fontSize = fontSize;
		this.color = color;
	}

	protected LayoutText() {

	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public double getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getFontSize() {
		return fontSize;
	}

	public void setFontSize(int fontSize) {
		this.fontSize = fontSize;
	}

	public LayoutColor getColor() {
		return color;
	}

	public void setColor(LayoutColor color) {
		this.color = color;
	}
}
