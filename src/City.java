import java.util.ArrayList;

public class City {
	public String name;
	public ArrayList<Flight> connections;
	public boolean visited = false;
	
	/**Constructs a city node
	 * 
	 * @param name String name of the city node
	 */
	
	public City(String name) {
		this.name = name;
		connections = new ArrayList<Flight>();
	}
	
	/**This method adds an edge to the graph
	 * 
	 * @param f Flight that corresponds to an edge in the graph
	 */
	public void addConnection(Flight f) {
		connections.add(f);
	}
	
}
