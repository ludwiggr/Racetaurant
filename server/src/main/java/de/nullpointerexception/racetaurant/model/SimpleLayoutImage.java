package de.nullpointerexception.racetaurant.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.URL;

@Entity
@DiscriminatorValue("simple-image")
public class SimpleLayoutImage extends ShapedLayoutObject {
	@NotNull
	@URL
	@Column(length = 400)
	private String url;

	public SimpleLayoutImage(Shape shape, String url) {
		super(shape, LayoutObjectType.IMAGE);
		this.url = url;
	}

	protected SimpleLayoutImage() {

	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUrl() {
		return url;
	}
}
