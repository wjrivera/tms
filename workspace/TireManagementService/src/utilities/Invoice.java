package utilities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Invoice {

	public static final Integer NextInvoiceNumber = 1000;
	private Integer invoiceNumber;
	private Client client;
	private UUID clientId;
	private List<Job> jobs = new ArrayList<Job>();
	private Date date;

	public Invoice(Client c, UUID id, Date d) {
		client = c;
		clientId = id;
		date = d;
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

}
