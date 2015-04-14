package Interface;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class StartScreen extends JFrame {

	public static final String TITLE = "Tire Management System";

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

	public StartScreen() throws ClassNotFoundException, SQLException {

		logo = new ImageIcon(System.getProperty("user.dir")
				+ "\\resources\\logo.png");

		DatabaseConnectivity dbc = DatabaseConnectivity.getInstance();

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
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
				options();
			}

		});
		generateInvoiceButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				generateInvoice();
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

	public void options() {
		OptionsScreen newInstance = new OptionsScreen();
		setVisible(false);
		dispose();
	}

	public void generateInvoice() {
		GenerateInvoiceScreen newInstance = new GenerateInvoiceScreen();
		setVisible(false);
		dispose();
	}

	public static void main(String[] args) throws ClassNotFoundException,
			SQLException {

		StartScreen start = new StartScreen();

	}

}
