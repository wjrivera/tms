package Interface;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import utilities.Client;
import utilities.Invoice;
import utilities.Job;
import utilities.StoreInfo;
import utilities.Vehicle;
/**
 * Singleton class, mostly because we only need one instance of it at all times
 * Used to handle all the connections between database
 * 
 * @author Andres
 *
 */
public class DatabaseConnectivity implements Serializable {

	private static DatabaseConnectivity instance;
	public static final String SAVESTATE = "TireManagementSystem.tmscf",
			directory = "\\TMS\\Data\\";
	Connection conn;

	
	/**
	 * private constructor to get only one instance
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	private DatabaseConnectivity() throws ClassNotFoundException, SQLException {
		Class.forName("org.h2.Driver");
		conn = DriverManager.getConnection(
				"jdbc:h2:" + System.getProperty("user.home")
						+ "\\tms;mv_store=false", "sa", "");
		System.out.println("jdbc:h2:" + System.getProperty("user.home")
				+ "\\tms;mv_store=false");

		createDatabase();
	}

	public void loadDatabase() {

	}

	public void createDatabase() throws SQLException {
		String createDatabases = "CREATE TABLE IF NOT EXISTS client("
				+ "id VARCHAR(50)," + "firstName VARCHAR(50),"
				+ "lastName VARCHAR(50)," + "email VARCHAR(100),"
				+ "phone_number VARCHAR(20)," + "address VARCHAR(100),"
				+ "city VARCHAR(25)," + "state VARCHAR(20),"
				+ "zip VARCHAR(15)," + "CONSTRAINT pk_id PRIMARY KEY(id));"
				+ "CREATE TABLE IF NOT EXISTS invoice(" + "invoice_num INT,"
				+ "client_id VARCHAR(50)," + "vehicle_id VARCHAR(50),"
				+ "bill_to VARCHAR(50)," + "date DATE,"
				+ "CONSTRAINT pk_invoice PRIMARY KEY(invoice_num,"
				+ "client_id),"
				+ "CONSTRAINT fk_client_id FOREIGN KEY(client_id)"
				+ "REFERENCES client(id));"
				+ "CREATE TABLE IF NOT EXISTS jobs(" + "invoice_num INT,"
				+ "job_name VARCHAR(200)," + "price DECIMAL,"
				+ "CONSTRAINT pk_job_id PRIMARY KEY(invoice_num, job_name),"
				+ "CONSTRAINT fk_invoice_num FOREIGN KEY(invoice_num) "
				+ "REFERENCES invoice(invoice_num)" + ");"
				+ "CREATE TABLE IF NOT EXISTS vehicle(" + "id VARCHAR(50),"
				+ "client_id VARCHAR(50)," + "make VARCHAR(25),"
				+ "model VARCHAR(25)," + "year INT,"
				+ "CONSTRAINT pk_vehicle PRIMARY KEY(id, client_id));";

		PreparedStatement createDBStatement = conn
				.prepareStatement(createDatabases);

		createDBStatement.executeUpdate();

	}

	public Client getClientFromId(UUID clientId) throws SQLException {

		Client c = new Client();

		String getClient = "SELECT * FROM client " + "WHERE id LIKE ?;";

		PreparedStatement getStatement = conn.prepareStatement(getClient);
		getStatement.setString(1, clientId.toString());
		ResultSet rs = getStatement.executeQuery();

		while (rs.next()) {
			c = new Client(rs.getString("id"));
			c.setFirstName(rs.getString("firstName"));
			c.setLastName(rs.getString("lastName"));
			c.setEmail(rs.getString("email"));
			c.setPhoneNumber(rs.getString("phone_number"));
			c.setAddress(rs.getString("address"));
			c.setCity(rs.getString("city"));
			c.setState(rs.getString("state"));
			c.setZip(rs.getString("zip"));
			c.setVehicle(getVehiclesFromClientId(c.getClientId().toString()));
		}

		return c;
	}

	public List<Vehicle> getVehiclesFromClientId(String id) throws SQLException {
		List<Vehicle> ret = new ArrayList<Vehicle>();

		final String getVehicles = "SELECT * FROM vehicle "
				+ "WHERE client_id LIKE ?;";

		PreparedStatement getStatement = conn.prepareStatement(getVehicles);
		getStatement.setString(1, id);
		ResultSet rs = getStatement.executeQuery();

		while (rs.next()) {
			ret.add(new Vehicle(rs.getInt("year"), rs.getString("make"), rs
					.getString("model"), UUID.fromString(rs.getString("id"))));
		}

		return ret;

	}

	public void addVehicle(Vehicle v, String clientId) throws SQLException {

		final String addVehicle = "MERGE INTO vehicle"
				+ "(id, client_id, year, make, model)" + "VALUES (?,?,?,?,?);";

		PreparedStatement addVehicleStatement = conn
				.prepareStatement(addVehicle);
		addVehicleStatement.setString(1, v.getId().toString());
		addVehicleStatement.setString(2, clientId);
		addVehicleStatement.setInt(3, v.getYear());
		addVehicleStatement.setString(4, v.getMake());
		addVehicleStatement.setString(5, v.getModel());

		addVehicleStatement.executeUpdate();
	}

	public void addVehicles(List<Vehicle> vehicles, String clientId)
			throws SQLException {

		final String addVehicles = "MERGE INTO vehicle"
				+ "(id, client_id, year, make, model)" + "VALUES (?,?,?,?,?);";

		for (Vehicle v : vehicles) {
			PreparedStatement addVehiclesStatement = conn
					.prepareStatement(addVehicles);
			addVehiclesStatement.setString(1, v.getId().toString());
			addVehiclesStatement.setString(2, clientId);
			addVehiclesStatement.setInt(3, v.getYear());
			addVehiclesStatement.setString(4, v.getMake());
			addVehiclesStatement.setString(5, v.getModel());

			addVehiclesStatement.executeUpdate();
		}
	}

	public String getClientNameFromId(UUID clientId) throws SQLException {
		String name = "";

		final String getClient = "SELECT CONCAT(firstName, ' ', lastName) AS name "
				+ "FROM client WHERE id LIKE ?;";

		PreparedStatement getStatement = conn.prepareStatement(getClient);
		getStatement.setString(1, clientId.toString());
		ResultSet rs = getStatement.executeQuery();

		while (rs.next()) {
			name = rs.getString("name");

		}

		System.out.println(name);

		return name;
	}

	public void addClient(Client c) throws SQLException {
		final String addClient = "MERGE INTO client"
				+ "(id, firstName, lastName, email, phone_number, address, city, state, zip)"
				+ "VALUES(?,?,?,?,?,?,?,?,?);";

		PreparedStatement addClientStatement = conn.prepareStatement(addClient);
		addClientStatement.setString(1, c.getClientId().toString());
		addClientStatement.setString(2, c.getFirstName());
		addClientStatement.setString(3, c.getLastName());
		addClientStatement.setString(4, c.getEmail());
		addClientStatement.setString(5, c.getPhoneNumber());
		addClientStatement.setString(6, c.getAddress());
		addClientStatement.setString(7, c.getCity());
		addClientStatement.setString(8, c.getState());
		addClientStatement.setString(9, c.getZip());

		addClientStatement.executeUpdate();

		addVehicles(c.getVehicle(), c.getClientId().toString());

	}

	public void deleteRecordsForClient(String clientId) throws SQLException {

		List<Invoice> clinetInvoices = getInvoicesByDate(clientId);

		final String deleteClient = "DELETE FROM client"
				+ "WHERE clientId LIKE ? ;";

		PreparedStatement addClientStatement = conn
				.prepareStatement(deleteClient);

		addClientStatement.setString(1, clientId);

		addClientStatement.executeUpdate();

	}

	public void addInvoice(Invoice i) throws SQLException {
		String addInvoice = "MERGE INTO invoice"
				+ "(invoice_num, client_id, vehicle_id, bill_to, date)"
				+ "VALUES (?,?,?,?,?);";

		PreparedStatement addInvoiceStatement = conn
				.prepareStatement(addInvoice);
		addInvoiceStatement.setInt(1, i.getInvoiceNumber());
		addInvoiceStatement.setString(2, i.getClientId().toString());
		addInvoiceStatement.setString(3, i.getVehicle().getId().toString());
		addInvoiceStatement.setString(4, i.getBillTo());
		addInvoiceStatement
				.setDate(5, new java.sql.Date(i.getDate().getTime()));

		addInvoiceStatement.executeUpdate();

		addJobs(i.getJobs(), i.getInvoiceNumber());

	}

	public String getClientIdByName(String name) throws SQLException {

		String clientId = "<>?";

		String retrieveSQL = "SELECT id FROM client "
				+ "WHERE CONCAT(firstName, ' ',lastName) LIKE ?;";

		PreparedStatement retrieveClientId = conn.prepareStatement(retrieveSQL);
		retrieveClientId.setString(1, "%" + name + "%");

		ResultSet rs = retrieveClientId.executeQuery();

		while (rs.next()) {
			clientId = rs.getString("id");
		}

		System.out.println(name + "'s id is " + clientId);

		return clientId;

	}

	public List<Client> getClientsByName(String name) throws SQLException {
		List<Client> returnList = new ArrayList<Client>();

		String retrieveSQL = "SELECT * FROM client "
				+ "WHERE UPPER(CONCAT(firstName, ' ',lastName)) LIKE ? ORDER BY lastName";

		PreparedStatement retrieveClient = conn.prepareStatement(retrieveSQL);
		retrieveClient.setString(1, "%" + name.toUpperCase() + "%");

		ResultSet rs = retrieveClient.executeQuery();

		while (rs.next()) {

			Client temp = new Client(rs.getString("id"));
			temp.setFirstName(rs.getString("firstName"));
			temp.setLastName(rs.getString("lastName"));
			temp.setEmail(rs.getString("email"));
			temp.setPhoneNumber(rs.getString("phone_number"));
			temp.setAddress(rs.getString("address"));
			temp.setCity(rs.getString("city"));
			temp.setState(rs.getString("state"));
			temp.setZip(rs.getString("zip"));

			List<Vehicle> tempV = getVehiclesFromClientId(temp.getClientId()
					.toString());

			temp.setVehicle(tempV);

			returnList.add(temp);

		}

		return returnList;
	}

	public static DatabaseConnectivity getInstance()
			throws ClassNotFoundException, SQLException {
		if (instance == null) {
			instance = new DatabaseConnectivity();
		}

		return instance;
	}

	public List<Invoice> getInvoicesByDate(String clientId) throws SQLException {
		List<Invoice> returnList = new ArrayList<Invoice>();

		String cId = "";

		if (clientId != null || clientId != "" || clientId != " ") {
			cId = clientId;
		}

		String retrieveSQL = "SELECT * FROM invoice "
				+ "WHERE client_id LIKE ? "
				+ "ORDER BY date DESC, invoice_num DESC";

		PreparedStatement retrieveInvoices = conn.prepareStatement(retrieveSQL);

		System.out.println("length of search is " + cId.length());

		if (cId.length() <= 1) {
			retrieveInvoices.setString(1, "%");
		} else {
			retrieveInvoices.setString(1, "%" + getClientIdByName(cId) + "%");
		}
		ResultSet rs = retrieveInvoices.executeQuery();

		while (rs.next()) {
			Invoice temp = new Invoice(Integer.parseInt(rs
					.getString("invoice_num")));
			Client c = getClientFromId(UUID.fromString(rs
					.getString("client_id")));
			temp.setBillTo(rs.getString("bill_to"));
			temp.setVehicle(getVehicleFromId(rs.getString("vehicle_id")));
			temp.setClient(c);
			temp.setDate(rs.getDate("date"));

			temp.setJobs(getJobsFromInvNum(temp.getInvoiceNumber()));

			returnList.add(temp);
		}

		return returnList;
	}

	public List<Job> getJobsFromInvNum(int invNum) throws SQLException {

		List<Job> jobs = new ArrayList<Job>();

		String retrieveSQL = "SELECT * FROM jobs "
				+ "WHERE invoice_num LIKE ? ;";

		PreparedStatement retrieveJobs = conn.prepareStatement(retrieveSQL);

		retrieveJobs.setInt(1, invNum);

		ResultSet rs = retrieveJobs.executeQuery();

		while (rs.next()) {

			Job temp = new Job(rs.getString("job_name"), rs.getDouble("price"));

			jobs.add(temp);

		}

		return jobs;

	}

	public void addJobs(List<Job> jobs, int invNum) throws SQLException {
		final String addJobs = "MERGE INTO jobs"
				+ "(invoice_num, job_name, price)" + "VALUES(?,?,?);";

		for (Job j : jobs) {

			PreparedStatement addJobStatement = conn.prepareStatement(addJobs);
			addJobStatement.setInt(1, invNum);
			addJobStatement.setString(2, j.getTitle());
			addJobStatement.setDouble(3, j.getPrice());

			addJobStatement.executeUpdate();
		}
	}

	public Vehicle getVehicleFromId(String veh_id) throws SQLException {

		Vehicle temp = null;

		String retrieveSQL = "SELECT * FROM vehicle " + "WHERE id LIKE ?;";

		PreparedStatement retrieveVehicle = conn.prepareStatement(retrieveSQL);

		retrieveVehicle.setString(1, veh_id);

		ResultSet rs = retrieveVehicle.executeQuery();

		while (rs.next()) {
			temp = new Vehicle(rs.getInt("year"), rs.getString("make"),
					rs.getString("model"), UUID.fromString(veh_id));
		}

		return temp;

	}

	public void saveLastState() throws IOException {

		String content = "" + Invoice.NextInvoiceNumber + "\n"
				+ StoreInfo.getAddress() + "\n" + StoreInfo.getCity() + "\n"
				+ StoreInfo.getState() + "\n" + StoreInfo.getZip() + "\n"
				+ StoreInfo.getStoreName() + "\n" + StoreInfo.getPhoneNumber()
				+ "\n" + StoreInfo.getFaxNumber() + "\n" + StoreInfo.getEmail()
				+ "\n" + StoreInfo.getCounty() + "\n" + StoreInfo.getTaxId();

		boolean dirCreation = new File(directory).mkdirs();

		System.out.println("saving info");
		StoreInfo.printInfo();

		File file = new File(System.getProperty("user.home") + "\\" + directory
				+ SAVESTATE);

		if (!file.exists()) {
			file.createNewFile();
		}

		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(content);

		System.out.println("Info saved\n");

		bw.close();
	}

	public void getLastState() throws IOException {

		System.out.println("Extracting info");

		Scanner scanner = new Scanner(new File(System.getProperty("user.home")
				+ "\\" + directory + SAVESTATE));

		Invoice.NextInvoiceNumber = Integer.parseInt(scanner.nextLine());
		StoreInfo.setAddress(scanner.nextLine());
		StoreInfo.setCity(scanner.nextLine());
		StoreInfo.setState(scanner.nextLine());
		StoreInfo.setZip(scanner.nextLine());
		StoreInfo.setStoreName(scanner.nextLine());
		StoreInfo.setPhoneNumber(scanner.nextLine());
		StoreInfo.setFaxNumber(scanner.nextLine());
		StoreInfo.setEmail(scanner.nextLine());
		StoreInfo.setCounty(scanner.nextLine());
		StoreInfo.setTaxId(scanner.nextLine());

		System.out.println("Last state retrieved");
		StoreInfo.printInfo();

		// TODO get the stored store information and place it on the StoreInfo
		// class;

		scanner.close();

	}
}
