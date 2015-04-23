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

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import utilities.Client;

/**
 * 
 * The customer search screen, searches by search term alaphabetically
 * 
 * @author Andres
 *
 */
public class CustomerSearchScreen extends JFrame {

	// title
	private static final String TITLE = "Search By Customer";
	DatabaseConnectivity dbc = null;

	List<Client> clients;

	private JPopupMenu rightClickMenu;
	private JMenuItem deleteClientItem;
	private static String searchTerm;
	private ClientListModel cLM;
	JButton backToMainButton, addCustomerButton, generateInvoiceButton;
	JList clientsList;
	JScrollPane jobs;

	/**
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public CustomerSearchScreen() throws ClassNotFoundException, SQLException {

		rightClickMenu = new JPopupMenu();
		deleteClientItem = new JMenu("Delete Client");

		rightClickMenu.add(deleteClientItem);

		setBackground(new Color(129, 159, 252));

		
		// database connectivity singleton
		dbc = DatabaseConnectivity.getInstance();

		clients = new ArrayList<Client>();

		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		WindowListener exitListener = new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int confirm = JOptionPane.showOptionDialog(null,
						"Are You Sure to Close Application?",
						"Exit Confirmation", JOptionPane.YES_NO_OPTION,
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
		addCustomerButton = new JButton("Add Customer");
		generateInvoiceButton = new JButton("Generate Invoice");
		backToMainButton.setBackground(new Color(59, 89, 182));
		addCustomerButton.setBackground(new Color(59, 89, 182));
		generateInvoiceButton.setBackground(new Color(59, 89, 182));

		backToMainButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					backToMain();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SQLException e) {
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
					e.printStackTrace();
				}
			}
		});

		buttonsPanel.add(backToMainButton);
		buttonsPanel.add(addCustomerButton);
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
		topContainer.setBackground(new Color(129, 159, 252));
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
		topLevelCont.setBackground(new Color(129, 159, 252));
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

		if (clients.size() > 0) {
			cLM = new ClientListModel(clients);

			clientsList = new JList(cLM);
			clientsList.setFont(new Font("Serif", Font.BOLD, 20));
			clientsList.setCellRenderer(new ClientCellRenderer());
			clientsList.setVisibleRowCount(8);

			
			//Feautre not fully implemented
			/*
			clientsList.addMouseListener(new MouseAdapter() {
				public void MousePressed(MouseEvent e) {
					if (e.isPopupTrigger()) {
						deleteClient(((Client) clientsList.getSelectedValue())
								.getClientId().toString(),
								((Client) clientsList.getSelectedValue())
										.toString());
					}
				}


			});
			*/

			return new JScrollPane(clientsList,
					JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
					JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		} else {
			return new JScrollPane(new JLabel("NO RECORDS FOUND"),
					JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
					JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		}

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
			temp.setVehicle(customerInfo.vehicles);

			dbc.addClient(temp);

			cLM.add(temp);
		}

	}

	public void generateInvoice() throws ClassNotFoundException, SQLException {

		if (clientsList.getSelectedIndex() >= 0) {
			Client temp = clients.get(clientsList.getSelectedIndex());

			GenerateInvoiceScreen newInstance = new GenerateInvoiceScreen(temp,
					null);
			setVisible(false);
			dispose();
		} else {
			JOptionPane.showMessageDialog(this, "Please select a Client!");
		}
	}

	public class ClientListModel extends AbstractListModel<Client> {

		private List<Client> clients;

		public ClientListModel(List<Client> clients) {
			this.clients = clients;
		}

		public void add(Client c) {
			if (clients.add(c)) {
				fireContentsChanged(this, 0, getSize());
			}
		}

		@Override
		public Client getElementAt(int index) {
			return clients.get(index);
		}

		@Override
		public int getSize() {
			return clients.size();
		}

	}

	public void deleteClient(String client_id, String name) {

		int result = JOptionPane.showConfirmDialog(null,
				"Are you sure you want to delete " + name
						+ "\n THIS ACTION CANNOT BE UNDONE", "DELETE CLIENT",
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);

		if (result == JOptionPane.YES_OPTION) {
			// client should be deleted but not yet because it might lose
			// previous invoices, we need to get in touch with the client to
			// change this
			// The fucnion Exists in DatabaseConnectivity
		}

	}
}
