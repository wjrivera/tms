package utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Client {

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

	public Client() {
		clientId = UUID.randomUUID();
		vehicle = new ArrayList<Vehicle>();
	}

	public Client(String id) {
		clientId = UUID.fromString(id);
		vehicle = new ArrayList<Vehicle>();
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public void setClientId(String id) {
		clientId = UUID.fromString(id);
	}

	public UUID getClientId() {
		return clientId;

	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

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
