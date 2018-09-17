import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FlightMap {
	
	//private Routes routesObject;
	public String originCity;
	public HashMap<String, City> cities;
	private String outputFile;
	
	private HashMap<String, String> parents;
	
	//Sets the map to the Routes object with all of the data
	public FlightMap(String outputFile, String originCity) {
		this.originCity = originCity;
		cities = new HashMap<String, City>();
		parents = new HashMap<String, String>();
		parents.put(originCity, "!");
		this.outputFile = outputFile;
	}
	
	public void searchGraph() {
		City start = cities.get(originCity);
		DFS(start);
		
	}
	
	public void DFS(City c) {
		c.visited = true;
		ArrayList<Flight> edges = c.connections;
		for(Flight f: edges) {
			String dest = f.destination;
			City found = cities.get(dest);
			if(!found.visited) {
				parents.put(dest, c.name);
				DFS(found);
			}
		}
	}
	
	public void printResults() {
		
	}
	
	public void printGraph() {
		for(Map.Entry<String, City> e: cities.entrySet()) {
			String key = e.getKey();
			City c = e.getValue();
			System.out.print("City: " + key + " --- ");
			System.out.print("Destinations: ");
			for(Flight f: c.connections) {
				System.out.print(f.destination);
			}
			System.out.println("");
		}
	}
	
	public void printParents() {
		for(Map.Entry<String, String> e: parents.entrySet()) {
			String key = e.getKey();
			String value = e.getValue();
			System.out.println("City: " + key + " -- Parent: " + value);
			
		}
	}
}
