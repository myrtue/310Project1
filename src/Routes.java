import java.util.ArrayList;

/*This class contains an array containing "Flight" objects, which store the associated origin, destination, and 
 * cost of each flight in the input file along with the city we are originating from 
 */
public class Routes {
	private ArrayList<Flight> cities;
	private String originCity;
	
	public Routes() {
		cities = new ArrayList<Flight>();
	}

	public void addFlight(Flight flight) {
		cities.add(flight);
	}
	
	public void setOrigin(String origin) {
		originCity = origin;
	}
	
	public String getOrigin() {
		return originCity;
	}
	
	public void printData() {
		System.out.println("Printing data from Routes class.");
		System.out.println(originCity);
		for(int i = 0; i < cities.size(); i++) {
			System.out.print(cities.get(i).origin + " " + cities.get(i).destination + " " + cities.get(i).cost);
			System.out.println("");;
		}
	}
}
