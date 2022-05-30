package de.nullpointerexception.racetaurant.restaurant;

public record OpeningTimes(Time monday, Time tuesday, Time wednesday, Time thursday, Time friday, Time saturday,
		Time sunday) {

	public static record Time(String from, String to, boolean closed) {

		public Time(String from, String to) {
			this(from, to, false);
		}

		public Time() {
			this(null, null, true);
		}

		@Override
		public String toString() {
			if (closed)
				return "closed";
			return from + " - " + to;
		}
	}

}
