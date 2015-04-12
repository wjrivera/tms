package Interface;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utilities.Client;
import utilities.Invoice;

public class DatabaseConnectivity implements Serializable {

	private static DatabaseConnectivity instance;
	Connection conn;

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
				+ "client_id VARCHAR(50)," + "date DATE,"
				+ "CONSTRAINT pk_invoice PRIMARY KEY(invoice_num,"
				+ "client_id),"
				+ "CONSTRAINT fk_client_id FOREIGN KEY(client_id)"
				+ "REFERENCES client(id));"
				+ "CREATE TABLE IF NOT EXISTS jobs(" + "invoice_num INT,"
				+ "job_name VARCHAR(200)," + "price DECIMAL,"
				+ "CONSTRAINT pk_job_id PRIMARY KEY(invoice_num, job_name),"
				+ "CONSTRAINT fk_invoice_num FOREIGN KEY(invoice_num) "
				+ "REFERENCES invoice(invoice_num)" + ");";

		PreparedStatement createDBStatement = conn
				.prepareStatement(createDatabases);

		createDBStatement.executeUpdate();

	}

	public void addClient(Client c) throws SQLException {
		String addClient = "INSERT INTO client"
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

	}

	public void addInvoice(Invoice i) throws SQLException {
		String addInvoice = "";
	}

	public List<Client> getClientsByName(String name) throws SQLException {
		List<Client> returnList = new ArrayList<Client>();

		System.out.println(name);

		String retrieveSQL = "SELECT * FROM client "
				+ "WHERE CONCAT(firstName, ' ',lastName) LIKE ?";

		PreparedStatement retrieveClient = conn.prepareStatement(retrieveSQL);
		retrieveClient.setString(1, "%" + name + "%");

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

			returnList.add(temp);
		}

		return returnList;
	}

	public List<Client> getClientsByDate() {
		List<Client> returnList = new ArrayList<Client>();

		return returnList;
	}

	public static DatabaseConnectivity getInstance()
			throws ClassNotFoundException, SQLException {
		if (instance == null) {
			instance = new DatabaseConnectivity();
		}

		return instance;
	}

}
