package utilities;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Invoice {

	//class variables
	public static Integer NextInvoiceNumber = 1000;
	private Integer invoiceNumber;
	private Client client;
	private UUID clientId;
	private List<Job> jobs;
	private Date date;
	private Vehicle vehicle;
	private String billTo;

	//Invoice constructors with exisiting Invoicing or New Invoice created
	public Invoice(Client c, UUID id, Date d, Vehicle v, List<Job> js, String bt) {
		invoiceNumber = NextInvoiceNumber++;
		client = c;
		clientId = id;
		date = d;
		vehicle = v;
		jobs = js;
		billTo = bt;
	}

	public Invoice(int i, Client c, UUID id, Date d, Vehicle v, List<Job> js, String bt) {
		invoiceNumber = i;
		client = c;
		clientId = id;
		date = d;
		vehicle = v;
		jobs = js;
		billTo = bt;
	}
	
	//the following are setters and getters.
	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Invoice(int invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public UUID getClientId() {
		return clientId;
	}

	public void setClientId(UUID clientId) {
		this.clientId = clientId;
	}

	public List<Job> getJobs() {
		return jobs;
	}

	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(Integer invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public String getBillTo() {
		return billTo;
	}

	public void setBillTo(String billTo) {
		this.billTo = billTo;
	}

}
