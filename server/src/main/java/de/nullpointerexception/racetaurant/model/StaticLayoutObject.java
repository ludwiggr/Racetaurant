package de.nullpointerexception.racetaurant.model;

import java.util.UUID;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "objectType")
public abstract class StaticLayoutObject {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", insertable = false, updatable = false, nullable = false)
	private UUID id;

	@NotNull
	private LayoutObjectType type;

	public StaticLayoutObject(LayoutObjectType type) {
		this.type = type;
	}

	protected StaticLayoutObject() {

	}

	@JsonIgnore
	public UUID getId() {
		return id;
	}

	public LayoutObjectType getType() {
		return type;
	}

}
