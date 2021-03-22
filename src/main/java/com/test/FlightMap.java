package com.test;



import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class FlightMap {
    private Map<String, LinkedHashSet<String>> map = new HashMap<String, LinkedHashSet<String>>();

    /**
     * Populate a hashset with all flight 
     * connections as provided in requirement
     * @param fromAirport
     * @param toAirport
     */
    public void addConnection(String fromAirport, String toAirport) {
        LinkedHashSet<String> adjacent = map.get(fromAirport);
        if(adjacent==null) {
            adjacent = new LinkedHashSet<String>();
            map.put(fromAirport, adjacent);
        }
        adjacent.add(toAirport);
    }

    /**
     * @param node1
     * @param node2
     */
    public void addTwoWayVertex(String node1, String node2) {
    	addConnection(node1, node2);
    	addConnection(node2, node1);
    }

    /**
     * Check if the 2 ports are connected
     * @param node1
     * @param node2
     * @return
     */
    public boolean isConnected(String node1, String node2) {
        Set<?> adjacent = map.get(node1);
        if(adjacent==null) {
            return false;
        }
        return adjacent.contains(node2);
    }

    /**
     * 
     * @param last
     * @return
     */
    public LinkedList<String> adjacentNodes(String last) {
        LinkedHashSet<String> adjacent = map.get(last);
        if(adjacent==null) {
            return new LinkedList<String>();
        }
        return new LinkedList<String>(adjacent);
    }
}
