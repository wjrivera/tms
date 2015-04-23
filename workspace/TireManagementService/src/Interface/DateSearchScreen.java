package Interface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

import utilities.Client;
import utilities.Invoice;

/**
 * Gets all Invoices belonging to the search term by date, then by invoice
 * number
 * 
 * @author Andres
 * 
 */
public class DateSearchScreen extends JFrame {

	public static final String TITLE = "Search By Date";
	DatabaseConnectivity dbc = null;

	List<Invoice> invoices;

	private JButton backToMainButton, editInvoiceButton, generateInvoiceButton;
	private JList invoicesList;
	private JScrollPane invoicesSP;
	private Client client;
	private String searchT = "%";

	public DateSearchScreen(String search) throws ClassNotFoundException,
			SQLException {

		setBackground(new Color(129, 159, 252));

		dbc = DatabaseConnectivity.getInstance();

		if (search != null) {
			searchT = search;
		}

		invoices = new ArrayList<Invoice>();

		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		WindowListener exitListener = new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int confirm = JOptionPane.showOptionDialog(null,
						"Are You Sure to Close TMS?", "Exit Confirmation",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE, null, null, null);
				if (confirm == 0) {
					try {
						dbc.saveLastState();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					System.exit(0);
				}
			}
		};

		addWindowListener(exitListener);

		// set up the buttons
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setBackground(new Color(129, 159, 252));
		buttonsPanel.setLayout(new GridLayout(1, 3, 15, 15));

		backToMainButton = new JButton("Back To Main Screen");
		editInvoiceButton = new JButton("Edit Selected Invoice");
		generateInvoiceButton = new JButton("Generate New Invoice");

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
		editInvoiceButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					editInvoice();
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
			}
		});
		generateInvoiceButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					generateInvoice();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		backToMainButton.setBackground(new Color(59, 89, 182));
		editInvoiceButton.setBackground(new Color(59, 89, 182));
		generateInvoiceButton.setBackground(new Color(59, 89, 182));

		buttonsPanel.add(backToMainButton);
		buttonsPanel.add(editInvoiceButton);
		buttonsPanel.add(generateInvoiceButton);

		// set up the title
		JLabel titleLabel = new JLabel(TITLE, SwingConstants.CENTER);
		titleLabel.setBackground(new Color(129, 159, 252));
		titleLabel.setFont(new Font("Serif", Font.BOLD, 45));

		// container for title and buttons
		JPanel titleAndButtonCont = new JPanel();
		titleAndButtonCont.setBackground(new Color(129, 159, 252));
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
		topContainer.setBackground(new Color(129, 159, 252));

		// ScrollBar
		JPanel jobContainer = new JPanel();
		jobContainer.setBackground(new Color(129, 159, 252));
		invoicesSP = getScrollPane();
		invoicesSP.getViewport().setBackground(Color.WHITE);

		// gridLayout for screen
		JPanel topLevelCont = new JPanel();
		topLevelCont.setLayout(new GridLayout(2, 1));

		topLevelCont.add(topContainer);
		topLevelCont.add(invoicesSP);

		add(topLevelCont);

		// pack();
		setResizable(false);
		setLocationRelativeTo(null);
		setSize(700, 450);
		setVisible(true);
	}

	private JScrollPane getScrollPane() throws SQLException {

		String searchTerm = "%";
		if (searchT != null) {
			searchTerm = searchT;
		}

		System.out.println("Search term is " + searchTerm);

		invoices = dbc.getInvoicesByDate(searchTerm);

		invoicesList = new JList(invoices.toArray());
		invoicesList.setFont(new Font("Serif", Font.BOLD, 20));
		invoicesList.setCellRenderer(new InvoiceCellRenderer());
		invoicesList.setVisibleRowCount(4);

		return new JScrollPane(invoicesList,
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
		}
	}

	public void generateInvoice() throws ClassNotFoundException, SQLException {

		UIManager UI = new UIManager();
		UI.put("OptionPane.background", new Color(129, 159, 252));
		UI.put("Panel.background", new Color(129, 159, 252));

		JTextField searchField = new JTextField("");

		int newCustomer = JOptionPane.showConfirmDialog(this,
				"Is this an existing client?");

		if (newCustomer == JOptionPane.YES_OPTION) {
			int searchTerm = JOptionPane.showConfirmDialog(null, searchField,
					"Enter Search Term", JOptionPane.OK_CANCEL_OPTION,
					JOptionPane.PLAIN_MESSAGE);

			if (searchTerm == JOptionPane.OK_OPTION) {
				try {
					// TODO the following line should be changed later
					CustomerSearchScreen.setSearchTerm(searchField.getText());
					CustomerSearchScreen newInstance = new CustomerSearchScreen();
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
				setVisible(false);
				dispose();
			}
		} else if (newCustomer == JOptionPane.CANCEL_OPTION) {
			// DO NOTHING;
		} else {

			NewCustomerScreen customerInfo = new NewCustomerScreen();

			Client temp = new Client();

			int result = JOptionPane.showConfirmDialog(null, customerInfo,
					NewCustomerScreen.TITLE, JOptionPane.OK_CANCEL_OPTION,
					JOptionPane.PLAIN_MESSAGE);

			if (result == JOptionPane.OK_OPTION) {

				temp.setFirstName(customerInfo.firstName.getText());
				temp.setLastName(customerInfo.lastName.getText());
				temp.setEmail(customerInfo.email.getText());
				temp.setPhoneNumber(customerInfo.phoneNumber.getText());
				temp.setAddress(customerInfo.address.getText());
				temp.setCity(customerInfo.city.getText());
				temp.setState(customerInfo.state.getText());
				temp.setZip(customerInfo.zip.getText());
				temp.setVehicle(customerInfo.vehicles);

				dbc.addClient(temp);

				GenerateInvoiceScreen newInstance = new GenerateInvoiceScreen(
						temp, null);
				setVisible(false);
				dispose();
			}
		}
	}

	public void editInvoice() throws ClassNotFoundException, SQLException {

		// TODO second parameter should not be null;
		if (invoicesList.getSelectedValue() != null) {
			GenerateInvoiceScreen newInstance = new GenerateInvoiceScreen(
					((Invoice) invoicesList.getSelectedValue()).getClient(),
					(Invoice) invoicesList.getSelectedValue());
			setVisible(false);
			dispose();
		} else {
			JOptionPane.showMessageDialog(null, "Please Select an Invoice!");
		}

	}
}
