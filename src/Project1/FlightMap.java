package Project1;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FlightMap {
	
	//private Routes routesObject;
	public String originCity;
	public HashMap<String, City> cities;
	public String outputFile;
	public HashMap<String, String> parents;
	
	
	/**Constructor for FlightMap class
	 * 
	 * @param outputFile File the user wants to write to 
	 * @param originCity Origin city the search is from
	 */
	public FlightMap(String outputFile, String originCity) {
		this.originCity = originCity;
		this.outputFile = outputFile;
		cities = new HashMap<String, City>();
		parents = new HashMap<String, String>();
		parents.put(originCity, "!");
		
	}
	
	/**This method starts the DFS process
	 * 
	 */
	public void searchGraph() {
		City start = cities.get(originCity);
		DFS(start);
		
	}
	
	/**DFS function recursively searches the graph, looking for unexplored nodes
	 * 
	 * @param c City node that is passed into DFS function each time
	 */
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
	
	/**The function compiles the results of the search into strings so that they can be written to the file
	 * 
	 * @throws IOException handles filewriting related exceptions
	 */
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
	
	/**This function uses the parents HashMap to construct the path backwards
	 * 
	 * @param c City node you want the path to
	 * @return return a string that represents the path
	 */
	
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
		//System.out.println(result);
		return result;
	}
	
	/**This method returns the cost of the path to the city
	 * 
	 * @param c The city you want the cost of getting to 
	 * @return returnt the cost of the path to get to the city in string form
	 */
	
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
	
	//print methods for testing purposes below, not necessary for final output
	
//	public void printGraph() {
//		for(Map.Entry<String, City> e: cities.entrySet()) {
//			String key = e.getKey();
//			City c = e.getValue();
//			System.out.print("City: " + key + " --- ");
//			System.out.print("Destinations: ");
//			for(Flight f: c.connections) {
//				System.out.print(f.destination);
//			}
//			System.out.println("");
//		}
//	}
//	
//	public void printParents() {
//		for(Map.Entry<String, String> e: parents.entrySet()) {
//			String key = e.getKey();
//			String value = e.getValue();
//			System.out.println("City: " + key + " -- Parent: " + value);
//			
//		}
//	}
}
