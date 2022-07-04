package de.nullpointerexception.racetaurant.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.URL;

@Entity
@DiscriminatorValue("image")
public class LayoutImage extends ShapedLayoutObject {
	@URL
	@Column(length = 400)
	@NotNull
	private String light;

	@URL
	@Column(length = 400)
	@NotNull
	private String dark;

	public LayoutImage(Shape shape, String light, String dark) {
		super(shape, LayoutObjectType.IMAGE);
		this.light = light;
		this.dark = dark;
	}

	protected LayoutImage() {

	}

	public String getLight() {
		return light;
	}

	public void setLight(String light) {
		this.light = light;
	}

	public String getDark() {
		return dark;
	}

	public void setDark(String dark) {
		this.dark = dark;
	}
}
