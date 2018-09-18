package Project1;

import static org.junit.Assert.*;

import org.junit.Test;

import Project1.Flight;

class TestFlight {

	@Test
	void testFlightConstructor() {
		Flight test = new Flight ("cityA", "cityB", 500);
		
		assertEquals("cityA", test.origin);
		assertEquals("cityB", test.destination);
		assertEquals(500, test.cost);
	}

}
