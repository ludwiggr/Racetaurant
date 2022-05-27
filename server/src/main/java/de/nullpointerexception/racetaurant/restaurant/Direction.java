package de.nullpointerexception.racetaurant.restaurant;

public enum Direction {
	ASCENDING, DESCENDING;

	public static Direction parse(boolean asc){
		return asc ? ASCENDING : DESCENDING;
	}
}
