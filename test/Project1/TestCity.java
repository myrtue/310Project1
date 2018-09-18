package Project1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestCity {

	@Test
	
	void testFlightConstructor() {
		Flight test = new Flight ("cityA,", "cityB", 500);
		
		assertEquals("cityA", test.origin);
		assertEquals("cityB", test.destination);
		assertEquals(500, test.cost);
	}

	

}
