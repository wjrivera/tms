package Interface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import utilities.Client;

public class CustomerSearchScreen extends JFrame {

	private static final String TITLE = "Search By Customer";
	DatabaseConnectivity dbc = null;

	List<Client> clients;

	private static String searchTerm;
	JButton backToMainButton, addCustomerButton, generateInvoiceButton;
	JList clientsList;
	JScrollPane jobs;

	public CustomerSearchScreen() throws ClassNotFoundException, SQLException {

		dbc = DatabaseConnectivity.getInstance();

		clients = new ArrayList<Client>();

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		// set up the buttons
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new GridLayout(1, 3, 15, 15));

		backToMainButton = new JButton("Back To Main Screen");
		addCustomerButton = new JButton("Add Customer");
		generateInvoiceButton = new JButton("Generate Invoice");

		backToMainButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					backToMain();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		addCustomerButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					addCustomer();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		generateInvoiceButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				generateInvoice();
			}
		});

		buttonsPanel.add(backToMainButton);
		buttonsPanel.add(addCustomerButton);
		buttonsPanel.add(generateInvoiceButton);

		// set up the title
		JLabel titleLabel = new JLabel(TITLE, SwingConstants.CENTER);
		titleLabel.setFont(new Font("Serif", Font.BOLD, 45));

		// container for title and buttons
		JPanel titleAndButtonCont = new JPanel();
		titleAndButtonCont.setLayout(new GridLayout(2, 1, 15, 15));
		titleAndButtonCont.add(titleLabel);
		titleAndButtonCont.add(buttonsPanel);

		// borderlayout to organize top half
		JPanel topContainer = new JPanel();
		topContainer.setLayout(new BorderLayout());

		// fillers
		topContainer.add(new JLabel(" "), BorderLayout.PAGE_START);
		topContainer.add(new JLabel("      "), BorderLayout.LINE_START);
		topContainer.add(new JLabel("      "), BorderLayout.LINE_END);
		topContainer.add(new JLabel(" "), BorderLayout.PAGE_END);
		// actual one
		topContainer.add(titleAndButtonCont, BorderLayout.CENTER);

		// ScrollBar
		jobs = getScrollPane();
		jobs.getViewport().setBackground(Color.WHITE);

		// gridLayout for screen
		JPanel topLevelCont = new JPanel();
		topLevelCont.setLayout(new GridLayout(2, 1));

		topLevelCont.add(topContainer);
		topLevelCont.add(jobs);

		add(topLevelCont);

		pack();
		setResizable(false);
		setLocationRelativeTo(null);
		setSize(700, 450);
		setVisible(true);

	}

	public static void setSearchTerm(String sT) {

		searchTerm = sT;
	}

	private JScrollPane getScrollPane() throws SQLException {

		clients = dbc.getClientsByName(searchTerm);

		clientsList = new JList(clients.toArray());
		clientsList.setFont(new Font("Serif", Font.BOLD, 20));
		clientsList.setCellRenderer(new ClientCellRenderer());
		clientsList.setVisibleRowCount(8);

		return new JScrollPane(clientsList,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

	}

	public void backToMain() throws ClassNotFoundException, SQLException {
		// close the current window()
		StartScreen back = new StartScreen();
		setVisible(false);
		dispose();
	}

	public void addCustomer() throws SQLException {

		NewCustomerScreen customerInfo = new NewCustomerScreen();

		int result = JOptionPane.showConfirmDialog(null, customerInfo,
				NewCustomerScreen.TITLE, JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.PLAIN_MESSAGE);

		if (result == JOptionPane.OK_OPTION) {
			Client temp = new Client();

			temp.setFirstName(customerInfo.firstName.getText());
			temp.setLastName(customerInfo.lastName.getText());
			temp.setEmail(customerInfo.email.getText());
			temp.setPhoneNumber(customerInfo.phoneNumber.getText());
			temp.setAddress(customerInfo.address.getText());
			temp.setCity(customerInfo.city.getText());
			temp.setState(customerInfo.state.getText());
			temp.setZip(customerInfo.zip.getText());

			dbc.addClient(temp);

			jobs = getScrollPane();
		}

	}

	public void generateInvoice() {
		GenerateInvoiceScreen newInstance = new GenerateInvoiceScreen();
		setVisible(false);
		dispose();
	}

}
