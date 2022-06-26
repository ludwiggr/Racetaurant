package de.nullpointerexception.racetaurant.samples;

import de.nullpointerexception.racetaurant.model.*;
import org.springframework.data.util.Pair;

import java.util.*;

public class RestaurantLayoutFactory {
	private static final Random RANDOM = new Random(231);
	private static final int MIN_FLOOR_COUNT = 1;
	private static final int MAX_FLOOR_COUNT = 12;
	private static final String[] floorNames = { "Entry Hall", "Roof", "Main Floor", "Ground Floor", "Party Rooms",
			"Private Rooms", "Lobby", "Cafee", "Bar Lounge", "Christmas Floor", "Dance Floor", "Bar Floor" };
	private static final Shape[] floorShapes = { new Rectangle(0, 0, 100, 120, 0), new Rectangle(0, 0, 100, 100, 45),
			new Polygon(List.of(new Point2D(0, 0), new Point2D(100, 0), new Point2D(125, 50), new Point2D(100, 100),
					new Point2D(0, 100)), false), new Circle(150, 75, 75) };
	private static final String[] simpleLayoutImageURLs = {
			"https://images.unsplash.com/photo-1489710437720-ebb67ec84dd2?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8N3x8aGFwcHl8ZW58MHx8MHx8&auto=format&fit=crop&w=600&q=60" + "https://images.unsplash.com/photo-1656183566876-18dcdb90db8d?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxlZGl0b3JpYWwtZmVlZHwxOXx8fGVufDB8fHx8&auto=format&fit=crop&w=600&q=60",
			"https://images.unsplash.com/photo-1573865526739-10659fec78a5?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8Y2F0fGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=600&q=60" };
	private static final Pair<String, String>[] layoutImageURLs = new Pair[] {
			Pair.of("https://images.unsplash.com/photo-1590698933947-a202b069a861?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8OHx8aGFwcHl8ZW58MHx8MHx8&auto=format&fit=crop&w=600&q=60",
					"https://images.unsplash.com/photo-1607688387751-c1e95ae09a42?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8c2FkfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=600&q=60") };
	private static final String[] layoutTexts = { "Nice Spot", "Deadly Zone", "Corona Test Center" };

	public static RestaurantLayout create(Restaurant restaurant) {
		int floorCount = RANDOM.nextInt(MIN_FLOOR_COUNT, MAX_FLOOR_COUNT + 1);
		List<Floor> floors = generateFloors(floorCount);
		return new RestaurantLayout(floors, restaurant, RANDOM.nextInt(floorCount));
	}

	private static List<Floor> generateFloors(int floorCount) {
		Set<String> selectedFloorNames = selectRandomUniqueFloorNames(floorCount);
		return selectedFloorNames.stream()
				.map((name) -> new Floor(name, randomFloorShape(), randomLayoutObjects(floorCount))).toList();
	}

	private static Set<String> selectRandomUniqueFloorNames(int floorCount) {
		if (floorCount > floorNames.length) {
			throw new IllegalArgumentException(
					"The floor factory only allows to generate unique floors. More floor names are needed!");
		}

		Set<String> selectedFloorNames = new LinkedHashSet<>();
		while (selectedFloorNames.size() < floorCount) {
			selectedFloorNames.add(floorNames[RANDOM.nextInt(floorNames.length)]);
		}

		return selectedFloorNames;
	}

	private static Shape randomFloorShape() {
		return floorShapes[RANDOM.nextInt(floorShapes.length)].clone();
	}

	private static StaticLayoutObject randomLayoutObject(int staircaseBound) {
		LayoutObjectType[] types = LayoutObjectType.values();
		LayoutObjectType selectedType = types[RANDOM.nextInt(types.length)];
		return switch (selectedType) {
			case TABLE -> new RestaurantTable(randomShape(), RANDOM.nextInt(2, 12));
			case COLORED_SHAPE -> new ColoredShape(randomColor(), randomShape());
			case IMAGE -> {
				boolean simpleLayoutImage = RANDOM.nextBoolean();
				if (simpleLayoutImage) {
					String selectedUrl = simpleLayoutImageURLs[RANDOM.nextInt(simpleLayoutImageURLs.length)];
					yield new SimpleLayoutImage(randomShape(), selectedUrl);
				} else {
					Pair<String, String> selectedImages = layoutImageURLs[RANDOM.nextInt(layoutImageURLs.length)];
					yield new LayoutImage(randomShape(), selectedImages.getFirst(), selectedImages.getSecond());
				}
			}
			case TEXT -> new LayoutText(layoutTexts[RANDOM.nextInt(layoutImageURLs.length)], RANDOM.nextDouble(0, 100),
					RANDOM.nextDouble(0, 100), RANDOM.nextInt(5, 20), randomColor());
			case STAIRCASE -> new Staircase(RANDOM.nextInt(staircaseBound));
			default -> new ColoredShape(randomColor(), randomShape());
		};
	}

	private static LayoutColor randomColor() {
		LayoutColor[] colors = LayoutColor.values();
		return colors[RANDOM.nextInt(colors.length)];
	}

	private static Shape randomShape() {
		ShapeType[] types = ShapeType.values();
		ShapeType selectedType = types[RANDOM.nextInt(types.length)];
		return switch (selectedType) {
			case circle -> new Circle(RANDOM.nextDouble(0, 100), RANDOM.nextDouble(0, 100), RANDOM.nextDouble(1, 10));
			case rectangle -> new Rectangle(RANDOM.nextDouble(0, 100), RANDOM.nextDouble(0, 100),
					RANDOM.nextDouble(1, 10), RANDOM.nextDouble(1, 10), RANDOM.nextDouble(0, 2 * Math.PI));
			case polygon -> {
				double offsetX = RANDOM.nextDouble(-50, 50);
				double offsetY = RANDOM.nextDouble(-50, 50);
				boolean open = RANDOM.nextBoolean();
				yield new Polygon(
						List.of(new Point2D(50 + offsetX, 50 + offsetY), new Point2D(75 + offsetX, 50 + offsetY),
								new Point2D(80 + offsetX, 80 + offsetY), new Point2D(30 + offsetX, 90 + offsetY)),
						open);
			}
		};
	}

	private static List<StaticLayoutObject> randomLayoutObjects(int staircaseBound) {
		int count = RANDOM.nextInt(1, 20);
		List<StaticLayoutObject> objects = new ArrayList<>(count);
		for (int i = 0; i < count; i++) {
			objects.add(randomLayoutObject(staircaseBound));
		}
		return objects;
	}

}
