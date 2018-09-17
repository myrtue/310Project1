package Project1;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SearchMap {
	
	/**This class is the main method, it handles all user input from the command line
	 * 
	 * @param args handles user input
	 * @throws IOException handles exception from 
	 */
	private static String inputFile;
	private static String outputFile;
	
	public static void main(String args[]) throws IOException {
		
		inputFile = args[0];
		outputFile = args[1];
		
		FileReader fr;
		BufferedReader br;
		
		try {
			//have it as inputFile for now, must change later to get user input
			fr = new FileReader(inputFile);
			br = new BufferedReader(fr);
			readFile(br);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	/**This method reads the entire input file and constructs the corresponding graph
	 * 
	 * @param br BufferedReader is passed into function in order to read the input file
	 * @throws IOException handles exceptions related to reading file
	 */
	
	private static void readFile(BufferedReader br) throws IOException {
		
		//Declare the FlightMap object as graph that will store all of the data from the file
		
		
		
		String originCity;
		originCity = br.readLine();
		FlightMap graph = new FlightMap(outputFile, originCity);
		
		//System.out.println(originCity);
		
		String flight;
		
		//This for loop reads the file, loads each line into Flight object, and adds the flight object to Routes
		for(flight = br.readLine(); flight != null; flight = br.readLine()) {
			String[] parts = flight.split(" ");
			
			String origin;
			String destination;
			int cost;
			
			origin = parts[0];
			destination = parts[1];
			cost = Integer.parseInt(parts[2]);
			
			//create a new edge
			Flight newEdge = new Flight(origin, destination, cost);
			
			City fromNode = graph.cities.get(origin);
			//If this node has not been created, create it
			if(fromNode == null) {
				fromNode = new City(origin);
				graph.cities.put(origin, fromNode);
			}
			
			City toNode = graph.cities.get(destination);
			if(toNode == null) {
				toNode = new City(destination);
				graph.cities.put(destination, toNode);
			}
			fromNode.addConnection(newEdge);
			
		}
		//graph.printGraph();
		writeData(graph);
	}
	/**This function is passed in the FlightMap and calls the functions to search and print the results of the search
	 * 
	 * @param fm FlightMap object passed into this function in order to operate on it
	 * @throws IOException handles filewriting exceptions
	 */
	private static void writeData(FlightMap fm) throws IOException {
		fm.searchGraph();
		fm.printResults();
	}
}
