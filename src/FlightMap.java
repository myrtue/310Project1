import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FlightMap {
	
	private Routes routesObject;
	public String originCity;
	public HashMap<String, City> cities;
	
	//Sets the map to the Routes object with all of the data
	public FlightMap() {
		cities = new HashMap<String, City>();
	}
	
	public void printGraph() {
//		for(String key : cities.keySet()) {
//			System.out.println("Key: " + key);
//		}
		
		for(Map.Entry<String, City> e: cities.entrySet()) {
			String key = e.getKey();
			City c = e.getValue();
			System.out.println("City: " + key);
			System.out.print("Destinations: ");
			for(Flight f: c.connections) {
				System.out.print(f.destination);
			}
			System.out.println("");
		}
	}
}
