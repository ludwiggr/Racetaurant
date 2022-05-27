package de.nullpointerexception.racetaurant.restaurant;

public class OpeningTimes {
	private Time monday;
	private Time tuesday;
	private Time wednesday;
	private Time thursday;
	private Time friday;
	private Time saturday;
	private Time sunday;

	OpeningTimes(){

	}

	public OpeningTimes(Time monday, Time tuesday, Time wednesday, Time thursday, Time friday, Time saturday,
			Time sunday) {
		this.monday = monday;
		this.tuesday = tuesday;
		this.wednesday = wednesday;
		this.thursday = thursday;
		this.friday = friday;
		this.saturday = saturday;
		this.sunday = sunday;
	}

	public Time getMonday() {
		return monday;
	}

	private void setMonday(Time monday) {
		this.monday = monday;
	}

	public Time getTuesday() {
		return tuesday;
	}

	private void setTuesday(Time tuesday) {
		this.tuesday = tuesday;
	}

	public Time getWednesday() {
		return wednesday;
	}

	private void setWednesday(Time wednesday) {
		this.wednesday = wednesday;
	}

	public Time getThursday() {
		return thursday;
	}

	private void setThursday(Time thursday) {
		this.thursday = thursday;
	}

	public Time getFriday() {
		return friday;
	}

	private void setFriday(Time friday) {
		this.friday = friday;
	}

	public Time getSaturday() {
		return saturday;
	}

	private void setSaturday(Time saturday) {
		this.saturday = saturday;
	}

	public Time getSunday() {
		return sunday;
	}

	private void setSunday(Time sunday) {
		this.sunday = sunday;
	}

	public static class Time {
		private String from;
		private String to;
		private boolean closed;

		public Time(String from, String to) {
			this.from = from;
			this.to = to;
		}

		Time(){

		}

		public String getFrom() {
			return from;
		}

		private void setFrom(String from) {
			this.from = from;
		}

		public String getTo() {
			return to;
		}

		private void setTo(String to) {
			this.to = to;
		}

		public boolean isClosed() {
			return closed;
		}

		private void setClosed(boolean closed) {
			this.closed = closed;
		}

		@Override
		public String toString() {
			if (closed)
				return "closed";
			return from + " - " + to;
		}
	}

}
