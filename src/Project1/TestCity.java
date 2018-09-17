package Project1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestCity {

	@Test
	void testCityConstructor() {
		City test = new City("testCity");
		assertEquals("testCity", test.name);
	}
	
	@Test
	void testAddConnection() {
		City test = new City("testCity");
		Flight testConnection = new Flight ("originTest", "destTest", 1000);
		test.addConnection(testConnection);
		assertEquals("originTest", test.connections.get(0).origin);
		assertEquals("destTest", test.connections.get(0).destination);
		assertEquals(1000, test.connections.get(0).cost);
	}

}
