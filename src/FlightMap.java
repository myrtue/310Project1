import java.io.FileWriter;
import java.io.IOException;
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
		this.outputFile = outputFile;
		cities = new HashMap<String, City>();
		parents = new HashMap<String, String>();
		parents.put(originCity, "!");
		
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
	
	public void printResults() throws IOException {
		FileWriter fw = new FileWriter(outputFile);
		String resultsString = "";
		resultsString += "Destination "+ "\t" + "Flight Route from "+ originCity + "\t" + "Total Cost";
		resultsString += "\n";
		
		for (String key : parents.keySet()) {
			if(parents.get(key) != "!") {
				String path = getPath(key);
				String cost = getCost(key);
				String spacer ="";
				for(int i =0 ; i < 21 - path.length(); i++) {
					spacer +=" ";
				}
				String newLine = key + "\t"+ "\t" + "\t" + path + spacer + cost;
				resultsString += newLine;
				resultsString += "\n";
			}
		}
		fw.write(resultsString);
		fw.close();
		
	}
	
	public String getPath(String c) {
		ArrayList<String> resultPath = new ArrayList<String>();
		String current = c;
		while(current != "!") {
			resultPath.add(current);
			current = parents.get(current);
		}
		
		String result = "";
		for(int i = resultPath.size()-1; i >0; i--) {
			result += resultPath.get(i) + ", ";
		}
		if(resultPath.size() > 0) {
			result += resultPath.get(0);
		}
		System.out.println(result);
		return result;
	}
	
	public String getCost(String c) {
		int totalCost = 0;
		String current = c;
		while(parents.get(current) != "!") {
			String parent = parents.get(current);
			for(Flight f : cities.get(parent).connections) {
				if(f.destination == current) {
					totalCost += f.cost;
					break;
				}
			}
			current = parents.get(current);
		}
		String result = Integer.toString(totalCost);
		return result;
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
