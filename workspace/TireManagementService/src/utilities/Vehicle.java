package utilities;

import java.util.UUID;

public class Vehicle {

	private UUID id;
	private int year;
	private String make;
	private String model;
	private String notes;

	public Vehicle(int y, String mak, String mod) {
		year = y;
		make = mak;
		model = mod;
		id = UUID.randomUUID();
	}

	public Vehicle(int y, String mak, String mod, UUID id) {
		year = y;
		make = mak;
		model = mod;
		this.id = id;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public UUID getId() {
		return id;
	}

	public String toString() {

		return year + " " + make + " " + model;
	}

}
