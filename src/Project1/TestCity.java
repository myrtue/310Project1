package Project1;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCity {

	@Test
	public void testCityConstructor() {
		City test = new City("testCity");
		
		assertEquals("testCity", test.name);
	}
	
	@Test
	public void testAddConnection() {
		City test = new City("testCity");
		Flight f = new Flight("o", "d", 1000);
		test.addConnection(f);
		
		assertEquals("o", test.connections.get(0).origin);
		assertEquals("d", test.connections.get(0).destination);
		assertEquals(1000, test.connections.get(0).cost);
		
	}

}
