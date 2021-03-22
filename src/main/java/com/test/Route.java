package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Route {


	private static Route route;
	List<ArrayList<String>> paths;

	public Route() {
	}

	/**
	 * Return Class instance if already present
	 * @return
	 */
	public static Route getInstance() {
		if(route == null) {
			route = new Route();
		}
		return route;
	}

	/**
	 * Helper method to build all flight connections
	 * and retrieve the paths between any 2 given airports
	 * @param flights
	 * @param from
	 * @param to
	 * @return
	 */
	List<ArrayList<String>> flightHelper(List<Flight> flights, String from, String to) {
		FlightMap fMap = new FlightMap();
		Flight flight = null;
		Iterator<Flight> iter = flights.iterator();
		while (iter.hasNext()) {
			flight = iter.next();
			//setup the flight map
			fMap.addConnection(flight.getFromAirport(), flight.getToAirport());
		}		

		paths = new ArrayList<ArrayList<String>>();

		LinkedList<String> visited = new LinkedList<String>();
		visited.add(from);

		new Route().findAllPaths(fMap, visited, paths, from,to);
		return paths;
	}

	/**
	 * Use the Depth First Search algorithm to find all the paths 
	 * between 2 airports
	 * @param graph
	 * @param visited
	 * @param paths
	 * @param from
	 * @param to
	 */
	private void findAllPaths(FlightMap graph, LinkedList<String> visited, List<ArrayList<String>> paths, String from, String to) {        
		if (from!=null && from.equals(to)) { 
			paths.add(new ArrayList(Arrays.asList(visited.toArray())));
			return;
		}
		else {
			LinkedList<String> nodes = graph.adjacentNodes(from);    
			for (String node : nodes) {
				if (visited.contains(node)) {
					continue;
				} 
				LinkedList<String> temp = new LinkedList<String>();
				temp.addAll(visited);
				temp.add(node);          
				findAllPaths(graph, temp, paths, node, to);
			}
		}

	}
	
	/**
	 * Get number of available routes between 2 given airports
	 * @param flights
	 * @param from
	 * @param to
	 * @return
	 */
	public int getNumberOfAvailableRoutes(List<Flight> flights, String from, String to) {
		paths = this.flightHelper(flights,from, to);
		return paths.size();
	}

	/**
	 * Get Route with fewest stops between 2 given airports
	 * @param flights
	 * @param from
	 * @param to
	 * @return
	 */
	public String getRouteWithFewestStops(List<Flight> flights, String from, String to) {
		paths = this.flightHelper(flights, from, to);
		ArrayList<String> shortest = new ArrayList<String>();
		
		//No paths means no route
		if(paths.size() == 0) {
			return null;
		}
		
		// TO begin with point the shortest route to 
		// the 1st  one in the list
		shortest = paths.get(0);

		// if list contains only one route, 
		// that is the shortest
		if(paths.size() == 1) {
			return shortest.toString();
		}

		// If there is more than 1 route
		// Compare with the shortest route and return.
		if(paths.size()>1) {
			for(ArrayList<String> path: paths) {
				if(path.size() < shortest.size()) {
					shortest = path;
				}
				return path.toString();
			}
		}
		return null;
	}
	
	/**
	 * Get the number of routes with a given Layover
	 * @param flights
	 * @param from
	 * @param to
	 * @param layover
	 * @return
	 */
	public int getNumberOfRoutesWithLayoverAt(List<Flight> flights, String from, String to, String layover) {
		paths = this.flightHelper(flights, from, to);
		int num = 0;
		// Fetch all the paths and check 
		//if they contain the layover
		for(ArrayList<String>path : paths) {
			if(path.contains(layover)) {
				num++;
			}
		}
		return num;
	}
	

}

