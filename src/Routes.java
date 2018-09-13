import java.util.ArrayList;

/*This class contains an array containing "Flight" objects, which store the associated origin, destination, and 
 * cost of each flight in the input file along with the city we are originating from 
 */
public class Routes {
	private ArrayList<Flight> routes;
	private String originCity;
	
	public Routes() {
		routes = new ArrayList<Flight>();
	}

	public void addFlight(Flight flight) {
		routes.add(flight);
	}
	
	public void setOrigin(String origin) {
		originCity = origin;
	}
	
	public String getOrigin() {
		return originCity;
	}
}
