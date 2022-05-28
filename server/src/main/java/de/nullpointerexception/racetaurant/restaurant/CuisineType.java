package de.nullpointerexception.racetaurant.restaurant;

public enum CuisineType {
	BALKAN("balkan"), ASIAN("asian"), ITALIAN("italian"), GERMAN("german"), INDIAN("indian"), TURKISH("turkish"),
	GREEK("greek"), AMERICAN("american");

	private final String id;

	CuisineType(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public CuisineType parse(String cuisine){
		for(CuisineType type : CuisineType.values()){
			if(type.getId().equals(cuisine)){
				return type;
			}
		}
		throw new IllegalArgumentException("Invalid cuisine!");
	}
}
