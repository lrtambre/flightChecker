package com.test;

import java.util.Iterator;
import java.util.List;

import java.time.Duration;
import java.util.ArrayList;


public class Flights {

	/**
	 * Iterate through the list of flights ; 
	 * get unique airports by considering from
	 * and to elements.
	 * 
	 * @param flights
	 * @return
	 */
	public int getNumberOfUniqueAirports(List<Flight> flights) {
		int numberUniqueFlights = 0;
		// String[] listofAirports

		if (flights == null || flights.size() == 0) {
			return 0;
		}

		numberUniqueFlights = getListOfUniqueAirports(flights).size();

		return numberUniqueFlights;
	}

	/**
	 * Get list of unique airports
	 * @param flights
	 * @return
	 */
	public List<String> getListOfUniqueAirports(List<Flight> flights) {
		// add all unique airports to an array and return it.
		List<String> airports = new ArrayList<String>();
		
		// use Iterator to loop through provided list 
		//and add any airports not present in the unique List
		if(flights!=null) {
			Iterator<Flight> iter = flights.iterator();
			while (iter.hasNext()) {
				Flight flight = iter.next();
				if (!airports.contains(flight.getToAirport())) {
					airports.add(flight.getToAirport());
				}
				if (!airports.contains(flight.getFromAirport())) {
					airports.add(flight.getFromAirport());
				}
			}	
		}else
			return null;
		
		return airports;
	}

	/**
	 * Enumerate through the provided flights db, and count the number of flights
	 * that leave from a designated airport.
	 * 
	 * @param flights
	 * @param from
	 * @return
	 */
	public int getNumberOfFlightsThatLeave(List<Flight> flights, String from) {
		List<String> flightNumbers = new ArrayList<String>();
		int numberOfFlights = 0;
		Iterator<Flight> iter = flights.iterator();
		while (iter.hasNext()) {
			Flight flight = iter.next();
			if (flight.getFromAirport() == from && !flightNumbers.contains(flight.getFlightNumber())) {
				numberOfFlights++;
			}
		}
		return numberOfFlights;
	}

	/**
	 * Enumerate through the provided flights db, and count the number of flights
	 * that fly to the designated airport.
	 * 
	 * @param flights
	 * @param to
	 * @return
	 */
	public int getNumberOfFlightsThatGoTo(List<Flight> flights, String to) {
		List<String> flightNumbers = new ArrayList<String>();
		int numberOfFlights = 0;
		Iterator<Flight> iter = flights.iterator();
		while (iter.hasNext()) {
			Flight flight = iter.next();
			if (flight.getToAirport() == to && !flightNumbers.contains(flight.getFlightNumber())) {
				numberOfFlights++;
			}
		}
		return numberOfFlights;
	}

	/**
	 * Enumerate through the provided flights db, and count the number of flights
	 * that fly to OR from the designated airport.
	 * 
	 * @param flights
	 * @param airport
	 * @return
	 */
	public int getNumberOfFlightsThatLeaveOrGoTo(List<Flight> flights, String airport) {

		int numberOfFlights = 0;
		Iterator<Flight> iter = flights.iterator();
		while (iter.hasNext()) {
			Flight flight = iter.next();
			if (flight.getToAirport().equals(airport) || flight.getFromAirport().equals(airport)) {
				numberOfFlights++;
			}
		}
		return numberOfFlights;
	}

	/**
	 * Count the total number of possible routes that can get your from one airport
	 * to another without going back to the same airports If there is no possible
	 * routes, return 0
	 * 
	 * @param flights
	 * @param from
	 * @param to
	 * @return
	 */
	public int getNumberOfAvailableRoutes(List<Flight> flights, String from, String to) {
		if(flights!=null && from != null && from!= "" && to!=null && to!="")
			return Route.getInstance().getNumberOfAvailableRoutes(flights, from, to);
		else return 0;
	}

	
	/**
	 * Determine the Route between 2 airports with the fewest number of
	 * stops
	 * 
	 * @param flights
	 * @param from
	 * @param to
	 * @return
	 */
	public String getRouteWithFewestStops(List<Flight> flights, String from, String to) {
		if(flights!=null && from != null && from!= "" && to!=null && to!="")
			return Route.getInstance().getRouteWithFewestStops(flights, from, to);
		else
			return null;
	}

	/**
	 * Determine the number of routes between two airports that have a layover /
	 * stop at the designated airport
	 * 
	 * @param flights
	 * @param from
	 * @param to
	 * @param layover
	 * @return
	 */
	public int getNumberOfRoutesWithLayoverAt(List<Flight> flights, String from, String to, String layover) {
		if(flights!=null && from != null && from!= "" && to!=null && to!="")
			return Route.getInstance().getNumberOfRoutesWithLayoverAt(flights, from, to, layover);
		else return 0;
	}

	/**
	 * Build the list of flights that was provided as input
	 * 
	 * @return
	 */
	public static List<Flight> getListOfFlights() {
		List<Flight> flights = new ArrayList<Flight>();

		Flight f1 = new Flight("flt01", "ABC", "DEF", Duration.ofMinutes(84), 215);
		Flight f2 = new Flight("flt02", "ABC", "EFG", Duration.ofMinutes(92), 195);
		Flight f3 = new Flight("flt03", "DEF", "ABC", Duration.ofMinutes(113), 331);
		Flight f4 = new Flight("flt04", "EFG", "DEF", Duration.ofMinutes(76), 275);
		Flight f5 = new Flight("flt05", "EFG", "GHI", Duration.ofMinutes(61), 245);
		Flight f6 = new Flight("flt06", "GHI", "BCD", Duration.ofMinutes(81), 175);
		Flight f7 = new Flight("flt07", "BCD", "ABC", Duration.ofMinutes(79), 118);
		Flight f8 = new Flight("flt08", "CDE", "FGH", Duration.ofMinutes(84), 135);
		Flight f9 = new Flight("flt09", "EFG", "DEF", Duration.ofMinutes(79), 276);
		Flight f10 = new Flight("flt10", "ABC", "DEF", Duration.ofMinutes(72), 217);
		Flight f11 = new Flight("flt11", "ABC", "DEF", Duration.ofMinutes(88), 199);

		flights.add(f1);
		flights.add(f2);
		flights.add(f3);
		flights.add(f4);
		flights.add(f5);
		flights.add(f6);
		flights.add(f7);
		flights.add(f8);
		flights.add(f9);
		flights.add(f10);
		flights.add(f11);

		return flights;
	}
	

	public static void main(String[] args) {

		Flights flightOperations = new Flights();
		List<Flight> flights = getListOfFlights();

		System.out.println("getNumberOfUniqueAirports::" + flightOperations.getNumberOfUniqueAirports(flights));
		System.out.println(
				"getNumberOfFlightsThatLeave - ABC::" + flightOperations.getNumberOfFlightsThatLeave(flights, "ABC"));
		System.out.println(
				"getNumberOfFlightsThatGoTo - BCD::" + flightOperations.getNumberOfFlightsThatGoTo(flights, "BCD"));
		System.out.println("getNumberOfFlightsThatLeaveOrGoTo - EFG ::"
				+ flightOperations.getNumberOfFlightsThatLeaveOrGoTo(flights, "EFG"));
		System.out.println("getNumberOfAvailableRoutes between GHI & DEF::"
				+ flightOperations.getNumberOfAvailableRoutes(flights, "GHI", "DEF"));
		System.out.println("getRouteWithFewestStops between GHI and DEF::"
				+ flightOperations.getRouteWithFewestStops(flights, "GHI", "DEF"));
		System.out.println("getNumberOfRoutesWithLayoverAt from:GHI to:DEF layoverat:EFG ::"
				+ flightOperations.getNumberOfRoutesWithLayoverAt(flights, "GHI", "DEF", "EFG"));

	}


}
