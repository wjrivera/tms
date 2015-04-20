package Interface;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import utilities.Client;
import utilities.Invoice;

public class StartScreen extends JFrame {

	public static final String TITLE = "Tire Management System";
	public static boolean fresh = true;
	
	JMenuBar menuBar;
	JMenu menu, submenu;
	JMenuItem menuItem;
	JRadioButtonMenuItem rbMenuItem;
	JCheckBoxMenuItem cbMenuItem;

	ImageIcon logo;

	JPanel screenLayout;
	JPanel buttonsLayout;
	JPanel centerPanel;

	JLabel titleLabel;

	JTextField searchField;

	JButton searchByDateButton, searchByCustomerButton, optionsButton,
			generateInvoiceButton;

	DatabaseConnectivity dbc = DatabaseConnectivity.getInstance();

	public StartScreen() throws ClassNotFoundException, SQLException {

		if(fresh){
		try {
			dbc.setInvoiceCount();
			fresh = false;
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		}

		logo = new ImageIcon(System.getProperty("user.dir")
				+ "\\resources\\logo.png");

		final DatabaseConnectivity dbc = DatabaseConnectivity.getInstance();

		screenLayout = new JPanel();
		screenLayout.setLayout(new BorderLayout());

		// titleLabel = new JLabel(TITLE, SwingConstants.CENTER);
		// titleLabel.setFont(new Font("Serif", Font.BOLD, 45));

		titleLabel = new JLabel(logo, SwingConstants.CENTER);

		JPanel searchFieldPanel = new JPanel();
		searchFieldPanel.setLayout(new FlowLayout());
		searchField = new JTextField(
				"Search here                                                                      ");

		centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(2, 1));
		buttonsLayout = new JPanel();
		buttonsLayout.setLayout(new GridLayout(2, 2, 15, 15));

		JPanel holder = new JPanel();
		holder.setLayout(new BorderLayout());

		searchFieldPanel.add(searchField);
		holder.add(searchFieldPanel, BorderLayout.PAGE_END);
		holder.add(titleLabel, BorderLayout.CENTER);

		centerPanel.add(holder);

		searchByDateButton = new JButton("Search by Date");
		searchByCustomerButton = new JButton("Search by Customer");
		optionsButton = new JButton("Options");
		generateInvoiceButton = new JButton("Generate Invoice");

		searchField.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent arg0) {
				searchField.setText("");
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				searchField.setText(searchField.getText());
			}
		});

		// adding the listeners
		searchByDateButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					searchByDate(null);
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});
		searchByCustomerButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				searchByCustomer(searchField.getText());
			}

		});
		optionsButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					options();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});
		generateInvoiceButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					generateInvoice();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});

		buttonsLayout.add(searchByDateButton);
		buttonsLayout.add(searchByCustomerButton);
		buttonsLayout.add(optionsButton);
		buttonsLayout.add(generateInvoiceButton);

		centerPanel.add(buttonsLayout);

		// fillers
		screenLayout.add(new JLabel("         "), BorderLayout.LINE_START);
		screenLayout.add(new JLabel("         "), BorderLayout.LINE_END);
		// end fillers
		screenLayout.add(centerPanel, BorderLayout.CENTER);

		this.add(screenLayout);

		pack();
		setResizable(false);
		setLocationRelativeTo(null);
		setSize(700, 450);
		setVisible(true);

		optionsButton.requestFocus();

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
						dbc.saveInvoiceCount(Invoice.NextInvoiceNumber);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					System.exit(0);
				}
			}
		};

		addWindowListener(exitListener);

	}

	public void searchByDate(Date d) throws ClassNotFoundException,
			SQLException {
		DateSearchScreen newInstance = new DateSearchScreen();
		setVisible(false);
		dispose();
	}

	public void searchByCustomer(String cust) {
		try {
			// TODO the follwing line should be changed later
			CustomerSearchScreen.setSearchTerm(searchField.getText());
			CustomerSearchScreen newInstance = new CustomerSearchScreen();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		setVisible(false);
		dispose();
	}

	public void options() throws ClassNotFoundException, SQLException {
		OptionsScreen newInstance = new OptionsScreen();
		setVisible(false);
		dispose();
	}

	public void generateInvoice() throws SQLException, ClassNotFoundException {

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

			GenerateInvoiceScreen newInstance = new GenerateInvoiceScreen(temp);
			setVisible(false);
			dispose();
		}
	}

	public static void main(String[] args) throws ClassNotFoundException,
			SQLException {

		StartScreen start = new StartScreen();

	}

}
