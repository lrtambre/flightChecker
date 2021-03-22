package com.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class FlightsTest {

	
	public FlightsTest() {
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


	/**
	 * Tests for getNumberOfUniqueAirports()
	 */
	@Test
	public void test_Valid_NumberOfUniqueAirports() {
		Flights f = new Flights();

		assertEquals(7, f.getNumberOfUniqueAirports(getListOfFlights()));
	}
	@Test
	public void test_inValid_NumberOfUniqueAirports() {
		Flights f = new Flights();

		assertEquals(0, f.getNumberOfUniqueAirports(null));
	}

	/**
	 * TESTS FOR getNumberOfFlightsThatLeave
	 */
	@Test
	public void test_Valid_NumberOfFlightsThatLeave() {
		Flights f = new Flights();

		assertEquals(4, f.getNumberOfFlightsThatLeave(getListOfFlights(),"ABC"));
	}
	
	@Test
	public void test_Valid_NumberOfFlightsThatLeave1() {
		Flights f = new Flights();

		assertEquals(1, f.getNumberOfFlightsThatLeave(getListOfFlights(),"CDE"));
	}
	@Test
	public void test_Valid_NumberOfFlightsThatLeave2() {
		Flights f = new Flights();

		assertEquals(0, f.getNumberOfFlightsThatLeave(getListOfFlights(),"FGH"));
	}
	@Test
	public void test_inValid_NumberOfFlightsThatLeave1() {
		Flights f = new Flights();

		assertEquals(0, f.getNumberOfFlightsThatLeave(getListOfFlights(),"XXX"));
	}
		
	@Test
	public void test_inValid_NumberOfFlightsThatLeave2() {
		Flights f = new Flights();

		assertEquals(0, f.getNumberOfFlightsThatLeave(getListOfFlights(),null));
	}
	
	/**
	 * TESTS FOR getNumberOfFlightsThatGoTo
	 */
	@Test
	public void test_inValid_getNumberOfFlightsThatGoTo() {
		Flights f = new Flights();

		assertEquals(0, f.getNumberOfFlightsThatGoTo(getListOfFlights(),null));
	}
	
	@Test
	public void test_Valid_getNumberOfFlightsThatGoTo2() {
		Flights f = new Flights();

		assertEquals(1, f.getNumberOfFlightsThatGoTo(getListOfFlights(),"FGH"));
	}

	@Test
	public void test_Valid_getNumberOfFlightsThatGoTo3() {
		Flights f = new Flights();

		assertEquals(5, f.getNumberOfFlightsThatGoTo(getListOfFlights(),"DEF"));
	}
	
	@Test
	public void test_inValid_getNumberOfFlightsThatGoTo1() {
		Flights f = new Flights();

		assertEquals(0, f.getNumberOfFlightsThatGoTo(getListOfFlights(),""));
	}

	
	@Test
	public void test_inValid_getNumberOfFlightsThatGoTo2() {
		Flights f = new Flights();

		assertEquals(0, f.getNumberOfFlightsThatGoTo(getListOfFlights(),""));
	}

	/**
	 * TESTS FOR getNumberOfFlightsThatLeaveOrGoTo
	 */

	@Test
	public void test_Valid_getNumberOfFlightsThatLeaveOrGoTo() {
		Flights f = new Flights();

		assertEquals(6, f.getNumberOfFlightsThatLeaveOrGoTo(getListOfFlights(),"ABC"));
	}
	
	@Test
	public void test_Valid_getNumberOfFlightsThatLeaveOrGoTo1() {
		Flights f = new Flights();

		assertEquals(2, f.getNumberOfFlightsThatLeaveOrGoTo(getListOfFlights(),"GHI"));
	}
	
	@Test
	public void test_inValid_getNumberOfFlightsThatLeaveOrGoTo1() {
		Flights f = new Flights();

		assertEquals(0, f.getNumberOfFlightsThatLeaveOrGoTo(getListOfFlights(),null));
	}	
	
	@Test
	public void test_inValid_getNumberOfFlightsThatLeaveOrGoTo2() {
		Flights f = new Flights();

		assertEquals(0, f.getNumberOfFlightsThatLeaveOrGoTo(getListOfFlights(),""));
	}
	
	@Test
	public void test_inValid_getNumberOfFlightsThatLeaveOrGoTo3() {
		Flights f = new Flights();

		assertEquals(0, f.getNumberOfFlightsThatLeaveOrGoTo(getListOfFlights(),"123123"));
	}
	
	/**
	 * TESTS FOR getNumberOfAvailableRoutes
	 */
	
	@Test
	public void test_Valid_getNumberOfAvailableRoutes1() {
		Flights f = new Flights();

		assertEquals(1, f.getNumberOfAvailableRoutes(getListOfFlights(),"CDE","FGH"));
	}	

	@Test
	public void test_Valid_getNumberOfAvailableRoutes2() {
		Flights f = new Flights();

		assertEquals(0, f.getNumberOfAvailableRoutes(getListOfFlights(),"CDE","EFG"));
	}	
	
	@Test
	public void test_Valid_getNumberOfAvailableRoutes3() {
		Flights f = new Flights();

		assertEquals(1, f.getNumberOfAvailableRoutes(getListOfFlights(),"BCD","EFG"));
	}	
	
	@Test
	public void test_inValid_getNumberOfAvailableRoutes1() {
		Flights f = new Flights();

		assertEquals(0, f.getNumberOfAvailableRoutes(getListOfFlights(),"","FGH"));
	}	

	@Test
	public void test_inValid_getNumberOfAvailableRoutes2() {
		Flights f = new Flights();

		assertEquals(0, f.getNumberOfAvailableRoutes(getListOfFlights(),"",null));
	}	
	
	
	@Test
	public void test_inValid_getNumberOfAvailableRoutes3() {
		Flights f = new Flights();

		assertEquals(0, f.getNumberOfAvailableRoutes(getListOfFlights(),"",""));
	}	
	
	@Test
	public void test_inValid_getNumberOfAvailableRoutes4() {
		Flights f = new Flights();

		assertEquals(0, f.getNumberOfAvailableRoutes(getListOfFlights(),"aCDE","AFGH"));
	}	
	
	@Test
	public void test_inValid_getNumberOfAvailableRoutes5() {
		Flights f = new Flights();

		assertEquals(0, f.getNumberOfAvailableRoutes(getListOfFlights(),null,null));
	}	
	
	
	/**
	 * TESTS FOR getRouteWithFewestStops
	 */
	

	@Test
	public void test_Valid_getRouteWithFewestStops1() {
		Flights f = new Flights();

		assertEquals("[GHI, BCD, ABC, DEF]", f.getRouteWithFewestStops(getListOfFlights(),"GHI","DEF"));
	}	

	@Test
	public void test_Valid_getRouteWithFewestStops2() {
		Flights f = new Flights();

		assertEquals("[CDE, FGH]", f.getRouteWithFewestStops(getListOfFlights(),"CDE","FGH"));
	}	
	
	@Test
	public void test_Valid_getRouteWithFewestStops3() {
		Flights f = new Flights();

		assertEquals("[BCD, ABC, EFG]", f.getRouteWithFewestStops(getListOfFlights(),"BCD","EFG"));
	}	
	
	@Test
	public void test_inValid_getRouteWithFewestStops1() {
		Flights f = new Flights();

		assertEquals(null, f.getRouteWithFewestStops(getListOfFlights(),"","FGH"));
	}	

	@Test
	public void test_inValid_getRouteWithFewestStops2() {
		Flights f = new Flights();

		assertEquals(null, f.getRouteWithFewestStops(getListOfFlights(),"",null));
	}	
	
	
	@Test
	public void test_inValid_getRouteWithFewestStops3() {
		Flights f = new Flights();

		assertEquals(null, f.getRouteWithFewestStops(getListOfFlights(),"",""));
	}	
	
	@Test
	public void test_inValid_getRouteWithFewestStops4() {
		Flights f = new Flights();

		assertEquals(null, f.getRouteWithFewestStops(getListOfFlights(),"aCDE","AFGH"));
	}	
	
	@Test
	public void test_inValid_getRouteWithFewestStops5() {
		Flights f = new Flights();

		assertEquals(null, f.getRouteWithFewestStops(getListOfFlights(),null,null));
	}	
	
	

	/**
	 * TESTS FOR getNumberOfRoutesWithLayoverAt
	 */
	
	@Test
	public void test_Valid_getNumberOfRoutesWithLayoverAt1() {
		Flights f = new Flights();

		assertEquals(1, f.getNumberOfRoutesWithLayoverAt(getListOfFlights(),"GHI","ABC","BCD"));
	}	

	@Test
	public void test_Valid_getNumberOfRoutesWithLayoverAt2() {
		Flights f = new Flights();

		assertEquals(0, f.getNumberOfRoutesWithLayoverAt(getListOfFlights(),"ABC","BCD","FGH"));
	}	

	@Test
	public void test_inValid_getNumberOfRoutesWithLayoverAt1() {
		Flights f = new Flights();

		assertEquals(0, f.getNumberOfRoutesWithLayoverAt(getListOfFlights(),null,null,null));
	}	
	
	@Test
	public void test_inValid_getNumberOfRoutesWithLayoverAt2() {
		Flights f = new Flights();

		assertEquals(0, f.getNumberOfRoutesWithLayoverAt(getListOfFlights(),"","",""));
	}	



}
