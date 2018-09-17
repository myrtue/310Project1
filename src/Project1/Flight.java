package Project1;

public class Flight {
	
	public String origin;
	public String destination;
	public int cost;
	
	/** Creates the Flight object containing all relevant info for a flight
	 * 
	 * @param origin string containing the origin
	 * @param destination string containing the destination
	 * @param cost double containing the cost
	 * 
	 */
	
	public Flight (String origin, String destination, int cost) {
		this.origin = origin;
		this.destination = destination;
		this.cost = cost;
	}
}
