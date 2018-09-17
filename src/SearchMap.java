import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SearchMap {
	
	public static void main(String args[]) throws IOException {
		System.out.println("Hello World!");
		
		//String inputFile = args[1];
		//String outputFile = args[2];
		
		FileReader fr;
		BufferedReader br;
		
		try {
			//have it as inputFile for now, must change later to get user input
			fr = new FileReader("inputFile.txt");
			br = new BufferedReader(fr);
			readFile(br);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	private static void readFile(BufferedReader br) throws IOException {
		
		//Declare the FlightMap object as graph that will store all of the data from the file
		
		
		
		String originCity;
		originCity = br.readLine();
		FlightMap graph = new FlightMap("outputFile.txt", originCity);
		
		System.out.println(originCity);
		
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
		graph.printGraph();
		interpretData(graph);
	}
	
	private static void interpretData(FlightMap fm) throws IOException {
		fm.searchGraph();
		fm.printParents();
		fm.printResults();
	}
}
