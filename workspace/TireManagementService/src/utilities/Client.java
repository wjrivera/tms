package utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Client {


	// Local class variable 
	private UUID clientId;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String address;
	private String city;
	private String state;
	private String zip;
	private List<Vehicle> vehicle;

	// Sets a clientId for the database if the user is instantiated without anything passed into the constructor.
	public Client() {
		clientId = UUID.randomUUID();
		vehicle = new ArrayList<Vehicle>();
	}

	//If id is passed in we use it in the following form
	public Client(String id) {
		clientId = UUID.fromString(id);
		vehicle = new ArrayList<Vehicle>();
	}

	//Gets city
	public String getCity() {
		return city;
	}
	
	//Sets city for client
	public void setCity(String city) {
		this.city = city;
	}
	//gets State information to the calling object
	public String getState() {
		return state;
	}

	//Sets the state information
	public void setState(String state) {
		this.state = state;
	}
	//Obtains the client zip code
	public String getZip() {
		return zip;
	}
	//Sets the client zip code
	public void setZip(String zip) {
		this.zip = zip;
	}
	//Sets a new client id 
	public void setClientId(String id) {
		clientId = UUID.fromString(id);
	}
	//Gets a client ID
	public UUID getClientId() {
		return clientId;

	}
	//Returns the first name of the client
	public String getFirstName() {
		return firstName;
	}
	//Sets the first name of the client
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	//Gets the last name of the client
	public String getLastName() {
		return lastName;
	}
	//Sets the last name 
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	//Gets client email
	public String getEmail() {
		return email;
	}
	//Sets email
	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String toString() {
		return lastName + ", " + firstName;
	}

	public List<Vehicle> getVehicle() {
		return vehicle;
	}

	public void setVehicle(List<Vehicle> vehicle) {
		this.vehicle = vehicle;
	}
	
	public void addVehicle(Vehicle v) {
		vehicle.add(v);
	}

}
