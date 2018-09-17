package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Project1.City;
import Project1.Flight;
import Project1.FlightMap;

class TestFlightMap {

	@Test
	void testFlightMapConstructor() {
		FlightMap test = new FlightMap("output.txt", "originTest");
		assertEquals("output.txt",test.outputFile);
		assertEquals("originTest", test.originCity);
		assertEquals("!" , test.parents.get("originTest"));
	}
	
	@Test
	void testSearchGraph() {
		FlightMap testFM = new FlightMap("output.txt", "testCity");
		City t1 = new City("destTest1");
		City t2 = new City("destTest2");
		City t3 = new City("destTest3");
		City test = createTestOriginCity();
		testFM.cities.put("testCity", test);
		testFM.cities.put("destTest1", t1);
		testFM.cities.put("destTest2", t2);
		testFM.cities.put("destTest3", t3);
		
		testFM.DFS(test);
		
		assertEquals("testCity", testFM.parents.get("destTest1"));
		assertEquals("!", testFM.parents.get("testCity"));
	}
	
	@Test
	void testDFS() {
		FlightMap test = createTestFlightMap();
		test.DFS(test.cities.get("testCity"));
		
		assertEquals("testCity", test.parents.get("destTest1"));
		assertEquals("testCity", test.parents.get("destTest2"));
		assertEquals("testCity", test.parents.get("destTest3"));
		assertEquals("!", test.parents.get("testCity"));
	}
	
	@Test
	void testGetPath() {
		FlightMap test = createTestFlightMap();
		test.DFS(test.cities.get("testCity"));
		
		assertEquals("testCity, destTest1",test.getPath("destTest1"));
		assertEquals("testCity, destTest2",test.getPath("destTest2"));
		assertEquals("testCity, destTest3",test.getPath("destTest3"));
	}
	
	@Test
	void testGetCost() {
		FlightMap test = createTestFlightMap();
		test.DFS(test.cities.get("testCity"));
		
		assertEquals(1000, Integer.parseInt(test.getCost("destTest1")));
		assertEquals(2000, Integer.parseInt(test.getCost("destTest2")));
		assertEquals(3000, Integer.parseInt(test.getCost("destTest3")));
		
	}
	
	public static City createTestOriginCity() {
		City test = new City("testCity");
		Flight testConnection1 = new Flight ("testCity", "destTest1", 1000);
		Flight testConnection2 = new Flight ("testCity", "destTest2", 2000);
		Flight testConnection3 = new Flight ("testCity", "destTest3", 3000);
		test.addConnection(testConnection1);
		test.addConnection(testConnection2);
		test.addConnection(testConnection3);
		
		return test;
	}
	
	public static FlightMap createTestFlightMap() {
		FlightMap testFM = new FlightMap("output.txt", "testCity");
		City t1 = new City("destTest1");
		City t2 = new City("destTest2");
		City t3 = new City("destTest3");
		City test = createTestOriginCity();
		testFM.cities.put("testCity", test);
		testFM.cities.put("destTest1", t1);
		testFM.cities.put("destTest2", t2);
		testFM.cities.put("destTest3", t3);
		
		return testFM;
	}

}
