package Interface;

import java.awt.BorderLayout;
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
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import utilities.Client;
import utilities.Invoice;

public class DateSearchScreen extends JFrame {

	public static final String TITLE = "Search By Date";
	DatabaseConnectivity dbc = null;
	
	List<Invoice> invoices;

	JButton backToMainButton, addCustomerButton, generateInvoiceButton;
	JList invoicesList;
	JScrollPane jobs;

	public DateSearchScreen() throws ClassNotFoundException, SQLException {

		dbc = DatabaseConnectivity.getInstance();

		invoices = new ArrayList<Invoice>();
		
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		WindowListener exitListener = new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e){
				int confirm = JOptionPane.showOptionDialog(null, "Are You Sure to Close TMS?", "Exit Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
				if(confirm == 0){
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
		JPanel jobContainer = new JPanel();
		jobs = new JScrollPane(jobContainer,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

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

	private JScrollPane getScrollPane() throws SQLException {

		invoices = dbc.getInvoicesByDate();

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

			jobs = getScrollPane();
		}
	}

	public void generateInvoice() throws ClassNotFoundException, SQLException {
		GenerateInvoiceScreen newInstance = new GenerateInvoiceScreen(null);
		setVisible(false);
		dispose();
	}
}
