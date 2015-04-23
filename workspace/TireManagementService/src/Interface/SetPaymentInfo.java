//This Class is to edit the Store Information
//It needs access to the database
//Please modify as soon as possible
//This is a message from Eclipse
package Interface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import utilities.StoreInfo;

public class SetPaymentInfo extends JFrame {

	private static final String TITLE = "Set Payment Information";

	JButton backToMainButton, applyButton;

	JTextField bankNameTextField, addressTextField, cityTextField,
			stateTextField, zipTextField, phoneTextField, faxTextField,
			emailTextField, accountNumberTextField, routingTextField,
			payPalTextField, payPalPasswordTextField;

	public SetPaymentInfo() {

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		GridLayout gridLayout = new GridLayout(0, 4);

		// set up the panels
		JPanel buttonsPanel = new JPanel();
		JPanel titleAndButtonCont = new JPanel();
		JPanel topContainer = new JPanel();
		JPanel botButtonsPanel = new JPanel();
		JPanel topLevelCont = new JPanel();
		JPanel panel = new JPanel(gridLayout);

		buttonsPanel.setBackground(new Color(129, 159, 252));
		titleAndButtonCont.setBackground(new Color(129, 159, 252));
		topContainer.setBackground(new Color(129, 159, 252));
		botButtonsPanel.setBackground(new Color(129, 159, 252));
		topLevelCont.setBackground(new Color(129, 159, 252));
		panel.setBackground(new Color(129, 159, 252));

		// set the layouts
		buttonsPanel.setLayout(new GridLayout(1, 3, 15, 15));
		titleAndButtonCont.setLayout(new GridLayout(2, 1, 15, 15));
		topContainer.setLayout(new BorderLayout());
		botButtonsPanel.setLayout(new GridLayout(2, 2, 15, 15));
		topLevelCont.setLayout(new GridLayout(2, 1));

		// set the buttons and labels
		backToMainButton = new JButton("Back To Main Screen");
		backToMainButton.setBackground(new Color(59, 89, 182));
		backToMainButton.setForeground(Color.WHITE);
		backToMainButton.setFont(new Font("Serif", Font.PLAIN, 14));

		applyButton = new JButton("Apply Information");
		applyButton.setBackground(new Color(59, 89, 182));
		applyButton.setForeground(Color.WHITE);
		applyButton.setFont(new Font("Comic Sans MS Bold", Font.PLAIN, 18));

		JLabel titleLabel = new JLabel(TITLE, SwingConstants.CENTER);
		titleLabel.setFont(new Font("Comic Sans MS Bold", Font.BOLD, 20));

		JLabel bankNameLabel = new JLabel("     Bank Name: ");
		bankNameLabel.setFont(new Font("Comic Sans MS Bold", Font.PLAIN, 14));
		bankNameLabel.setBackground(new Color(59, 89, 182));
		bankNameLabel.setForeground(Color.BLACK);
		bankNameTextField = new JTextField();

		JLabel addressLabel = new JLabel("     Bank Address: ");
		addressLabel.setFont(new Font("Comic Sans MS Bold", Font.PLAIN, 14));
		addressLabel.setBackground(new Color(59, 89, 182));
		addressLabel.setForeground(Color.BLACK);
		addressTextField = new JTextField();

		JLabel cityLabel = new JLabel("     City: ");
		cityLabel.setFont(new Font("Comic Sans MS Bold", Font.PLAIN, 14));
		cityLabel.setBackground(new Color(59, 89, 182));
		cityLabel.setForeground(Color.BLACK);
		cityTextField = new JTextField();

		JLabel stateLabel = new JLabel("     State: ");
		stateLabel.setFont(new Font("Comic Sans MS Bold", Font.PLAIN, 14));
		stateLabel.setBackground(new Color(59, 89, 182));
		stateLabel.setForeground(Color.BLACK);
		stateTextField = new JTextField();

		JLabel zipLabel = new JLabel("     Zip Code: ");
		zipLabel.setFont(new Font("Comic Sans MS Bold", Font.PLAIN, 14));
		zipLabel.setBackground(new Color(59, 89, 182));
		zipLabel.setForeground(Color.BLACK);
		zipTextField = new JTextField();

		JLabel phoneLabel = new JLabel("     Bank Phone Number: ");
		phoneLabel.setFont(new Font("Comic Sans MS Bold", Font.PLAIN, 14));
		phoneLabel.setBackground(new Color(59, 89, 182));
		phoneLabel.setForeground(Color.BLACK);
		phoneTextField = new JTextField();

		JLabel faxLabel = new JLabel("     Bank Fax Number: ");
		faxLabel.setFont(new Font("Comic Sans MS Bold", Font.PLAIN, 14));
		faxLabel.setBackground(new Color(59, 89, 182));
		faxLabel.setForeground(Color.BLACK);
		faxTextField = new JTextField();

		JLabel emailLabel = new JLabel("     Bank Email Address: ");
		emailLabel.setFont(new Font("Comic Sans MS Bold", Font.PLAIN, 14));
		emailLabel.setBackground(new Color(59, 89, 182));
		emailLabel.setForeground(Color.BLACK);
		emailTextField = new JTextField();

		JLabel accountNumberLabel = new JLabel("     Account #: ");
		accountNumberLabel.setFont(new Font("Comic Sans MS Bold", Font.PLAIN,
				14));
		accountNumberLabel.setBackground(new Color(59, 89, 182));
		accountNumberLabel.setForeground(Color.BLACK);
		accountNumberTextField = new JTextField();

		JLabel routingLabel = new JLabel("     Routing #: ");
		routingLabel.setFont(new Font("Comic Sans MS Bold", Font.PLAIN, 14));
		routingLabel.setBackground(new Color(59, 89, 182));
		routingLabel.setForeground(Color.BLACK);
		routingTextField = new JTextField();

		JLabel payPalLabel = new JLabel("     PayPal Account #: ");
		payPalLabel.setFont(new Font("Comic Sans MS Bold", Font.PLAIN, 14));
		// payPalLabel.setBackground(new Color(59, 89, 182));
		// payPalLabel.setForeground(Color.BLACK);
		payPalTextField = new JTextField();

		JLabel payPalPasswordLabel = new JLabel("     PayPal Password #: ");
		payPalPasswordLabel.setFont(new Font("Comic Sans MS Bold", Font.PLAIN,
				14));
		payPalPasswordLabel.setBackground(new Color(59, 89, 182));
		payPalPasswordLabel.setForeground(Color.BLACK);
		payPalPasswordTextField = new JTextField();

		// adding the listeners
		backToMainButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				backToMain();
			}
		});

		applyButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				options();
			}

		});

		// Add buttons and labels to panels
		panel.add(bankNameLabel, BorderLayout.WEST);
		panel.add(bankNameTextField, BorderLayout.CENTER);
		panel.add(phoneLabel, BorderLayout.WEST);
		panel.add(phoneTextField, BorderLayout.EAST);

		panel.add(addressLabel, BorderLayout.WEST);
		panel.add(addressTextField, BorderLayout.EAST);
		panel.add(faxLabel, BorderLayout.WEST);
		panel.add(faxTextField, BorderLayout.EAST);

		panel.add(cityLabel, BorderLayout.WEST);
		panel.add(cityTextField, BorderLayout.EAST);
		panel.add(accountNumberLabel, BorderLayout.WEST);
		panel.add(accountNumberTextField, BorderLayout.EAST);

		panel.add(stateLabel, BorderLayout.WEST);
		panel.add(stateTextField, BorderLayout.EAST);
		panel.add(routingLabel, BorderLayout.WEST);
		panel.add(routingTextField, BorderLayout.EAST);

		panel.add(zipLabel, BorderLayout.WEST);
		panel.add(zipTextField, BorderLayout.CENTER);
		panel.add(payPalLabel, BorderLayout.WEST);
		panel.add(payPalTextField, BorderLayout.CENTER);

		panel.add(emailLabel, BorderLayout.WEST);
		panel.add(emailTextField, BorderLayout.EAST);
		panel.add(payPalPasswordLabel, BorderLayout.WEST);
		panel.add(payPalPasswordTextField, BorderLayout.CENTER);

		titleAndButtonCont.add(titleLabel); // adding title label to top panel
		titleAndButtonCont.add(buttonsPanel); // adding buttonsPanel to top
												// panel
		JPanel empty1 = new JPanel();
		JPanel empty2 = new JPanel();
		empty1.setBackground(new Color(129, 159, 252));
		empty2.setBackground(new Color(129, 159, 252));
		buttonsPanel.add(empty1);
		buttonsPanel.add(backToMainButton);
		buttonsPanel.add(empty2);

		topContainer.add(new JLabel(" "), BorderLayout.PAGE_START);
		topContainer.add(new JLabel("      "), BorderLayout.LINE_START);
		topContainer.add(new JLabel("      "), BorderLayout.LINE_END);
		topContainer.add(new JLabel(" "), BorderLayout.PAGE_END);
		topContainer.add(titleAndButtonCont, BorderLayout.CENTER);

		botButtonsPanel.add(panel);
		botButtonsPanel.add(applyButton, BorderLayout.SOUTH);

		// Adding the top container and bottom container
		topLevelCont.add(topContainer);
		topLevelCont.add(botButtonsPanel);
		add(topLevelCont);

		// Setting the main panel
		setResizable(false);
		setSize(700, 450);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public void backToMain() {
		// close the current window()
		try {
			StartScreen back = new StartScreen();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setVisible(false);
		dispose();
	}

	public void options() {
		try {
			OptionsScreen newInstance = new OptionsScreen();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setVisible(false);
		dispose();
	}

}