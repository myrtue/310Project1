import java.util.ArrayList;

public class City {
	public String name;
	public ArrayList<Flight> connections;
	public boolean visited = false;
	
	public City(String name) {
		this.name = name;
		connections = new ArrayList<Flight>();
	}
	
	public void addConnection(Flight f) {
		connections.add(f);
	}
	
}
