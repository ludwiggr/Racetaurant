package de.nullpointerexception.racetaurant.service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import de.nullpointerexception.racetaurant.controller.errors.RestaurantNotFoundException;
import de.nullpointerexception.racetaurant.model.Floor;
import de.nullpointerexception.racetaurant.model.LayoutObjectType;
import de.nullpointerexception.racetaurant.model.RestaurantLayout;
import de.nullpointerexception.racetaurant.model.StaticLayoutObject;
import de.nullpointerexception.racetaurant.repository.RestaurantLayoutRepository;

@Service
public class RestaurantLayoutService {
	private final RestaurantLayoutRepository restaurantLayoutRepository;

	@PersistenceContext
	public EntityManager em;

	public RestaurantLayoutService(RestaurantLayoutRepository restaurantLayoutRepository) {
		this.restaurantLayoutRepository = restaurantLayoutRepository;
	}

	public RestaurantLayout getRestaurantLayoutWithFilter(UUID restaurantId, LayoutObjectType[] objectTypes) {
		RestaurantLayout layout = restaurantLayoutRepository.findByRestaurantId(restaurantId);

		if (layout == null) {
			throw new RestaurantNotFoundException(restaurantId, HttpStatus.NOT_FOUND);
		}

		boolean objectTypesFilter = objectTypes != null && objectTypes.length != 0;

		// TODO: Filter object types using SQL (currently done using streams)
		if (objectTypesFilter) {
			filterLayoutObjects(layout, objectTypes);
		}

		return layout;
	}

	private void filterLayoutObjects(RestaurantLayout layout, LayoutObjectType[] objectTypes) {
		for (Floor floor : layout.getFloors()) {
			List<StaticLayoutObject> objects = floor.getObjects();
			List<StaticLayoutObject> filteredObjects = objects.stream().filter((object) -> {
				for (LayoutObjectType objectType : objectTypes) {
					if (Objects.equals(objectType, object.getType())) {
						return true;
					}
				}
				return false;
			}).toList();
			floor.setObjects(filteredObjects);
		}
	}
}
