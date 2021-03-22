package com.test;

import java.time.Duration;

public class Flight {


	private String flightNumber; 
    private String fromAirport;
    private String toAirport;
    private Duration duration;
    private int cost; 

	public Flight() {
		
	}
	
	/**
	 * Overloaded constructor
	 * @param string
	 * @param from
	 * @param to
	 * @param duration
	 * @param cost
	 */
	public Flight(String flightNumber, String from, String to, Duration duration, int cost) {
		this.setFlightNumber(flightNumber);
		this.setFromAirport(from);
		this.setToAirport(to);
		this.setDuration(duration);
		this.setCost(cost);
	}

    public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String string) {
		this.flightNumber = string;
	}


	public Duration getDuration() {
		return duration;
	}

	public void setDuration(Duration duration2) {
		this.duration = duration2;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public String getFromAirport() {
		return fromAirport;
	}

	public void setFromAirport(String fromAirport) {
		this.fromAirport = fromAirport;
	}

	public String getToAirport() {
		return toAirport;
	}

	public void setToAirport(String toAirport) {
		this.toAirport = toAirport;
	}

}
