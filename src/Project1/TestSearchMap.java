package Project1;

import static org.junit.Assert.*;

import org.junit.Test;

import Project1.City;
import Project1.Flight;

public class TestSearchMap {

	/*
	 * Since only methods inside of SearchMap.java are main(), one that reads the file, and one that writes the file,
	 * there is no requirement for testing as of now. Sample createTestGraph() function will be called to create a 
	 * test on if needed
	 */
	@Test
	public void defaultTest() {
		//shouldn't be anything here, just here for compilation purposes
	}
	
	public static City createTestGraph() {
		City test = new City("testCity");
		Flight testConnection1 = new Flight ("testCity", "destTest", 1000);
		Flight testConnection2 = new Flight ("testCity", "destTest2", 2000);
		Flight testConnection3 = new Flight ("testCity", "destTest3", 3000);
		test.addConnection(testConnection1);
		test.addConnection(testConnection2);
		test.addConnection(testConnection3);
		
		return test;
	}

}
