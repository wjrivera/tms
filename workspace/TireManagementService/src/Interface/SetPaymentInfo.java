//This Class is to edit the Store Information
//It needs access to the database
//Please modify as soon as possible
//This is a message from Eclipse
package Interface;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.*;

public class SetPaymentInfo extends JFrame {

	private static final String TITLE = "Set Payment Information";

	JButton backToMainButton, applyButton;

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
		
		// set the layouts
		buttonsPanel.setLayout(new GridLayout(1, 3, 15, 15));
		titleAndButtonCont.setLayout(new GridLayout(2, 1, 15, 15));
		topContainer.setLayout(new BorderLayout());
		botButtonsPanel.setLayout(new GridLayout(2, 2, 15, 15));
		topLevelCont.setLayout(new GridLayout(2, 1));
		
		
		// set the buttons and labels
		backToMainButton = new JButton("Back To Main Screen");
		applyButton = new JButton("Apply Information");
		JLabel titleLabel = new JLabel(TITLE, SwingConstants.CENTER);
		titleLabel.setFont(new Font("Serif", Font.BOLD, 35));		
		JLabel bankNameLabel = new JLabel("     Bank Name: ");
		JTextField bankNameTextField = new JTextField();
		JLabel addressLabel = new JLabel("     Bank Address: ");
		JTextField addressTextField = new JTextField();
		JLabel cityLabel = new JLabel("     City: ");
		JTextField cityTextField = new JTextField();
		JLabel stateLabel = new JLabel("     State: ");
		JTextField stateTextField = new JTextField();
		JLabel zipLabel = new JLabel("     Zip Code: ");
		JTextField zipTextField = new JTextField();
		JLabel phoneLabel = new JLabel("     Bank Phone Number: ");
		JTextField phoneTextField = new JTextField();
		JLabel faxLabel = new JLabel("     Bank Fax Number: ");
		JTextField faxTextField = new JTextField();
		JLabel emailLabel = new JLabel("     Bank Email Address: ");
		JTextField emailTextField = new JTextField();
		JLabel accountNumberLabel = new JLabel("     Account #: ");
		JTextField accountNumberTextField = new JTextField();
		JLabel routingLabel = new JLabel("     Routing #: ");
		JTextField routingTextField = new JTextField();

		JLabel payPalLabel = new JLabel("     PayPal Account #: ");
		JTextField payPalTextField = new JTextField();
		JLabel payPalPasswordLabel = new JLabel("     PayPal Password #: ");
		JTextField payPalPasswordTextField = new JTextField();

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
		panel.add(bankNameLabel,BorderLayout.WEST);
		panel.add(bankNameTextField,BorderLayout.CENTER);
		panel.add(phoneLabel,BorderLayout.WEST);
		panel.add(phoneTextField,BorderLayout.EAST);
		
		panel.add(addressLabel,BorderLayout.WEST);
		panel.add(addressTextField,BorderLayout.EAST);
		panel.add(faxLabel,BorderLayout.WEST);
		panel.add(faxTextField,BorderLayout.EAST);
		
		
		panel.add(cityLabel,BorderLayout.WEST);
		panel.add(cityTextField,BorderLayout.EAST);		
		panel.add(accountNumberLabel,BorderLayout.WEST);
		panel.add(accountNumberTextField,BorderLayout.EAST);
		
		

		
		panel.add(stateLabel,BorderLayout.WEST);
		panel.add(stateTextField,BorderLayout.EAST);
		panel.add(routingLabel,BorderLayout.WEST);
		panel.add(routingTextField,BorderLayout.EAST);

		
		panel.add(zipLabel,BorderLayout.WEST);
		panel.add(zipTextField,BorderLayout.CENTER);
		panel.add(payPalLabel,BorderLayout.WEST);
		panel.add(payPalTextField, BorderLayout.CENTER);

		panel.add(emailLabel,BorderLayout.WEST);
		panel.add(emailTextField,BorderLayout.EAST);
		panel.add(payPalPasswordLabel,BorderLayout.WEST);
		panel.add(payPalPasswordTextField, BorderLayout.CENTER);

		titleAndButtonCont.add(titleLabel);			//adding title label to top panel
		titleAndButtonCont.add(buttonsPanel);		//adding buttonsPanel to top panel		
		buttonsPanel.add(new JPanel());				//left side of button
		buttonsPanel.add(backToMainButton);			//adding button to buttons panel
		buttonsPanel.add(new JPanel());				//right side of button
		

		topContainer.add(new JLabel(" "), BorderLayout.PAGE_START);
		topContainer.add(new JLabel("      "), BorderLayout.LINE_START);
		topContainer.add(new JLabel("      "), BorderLayout.LINE_END);
		topContainer.add(new JLabel(" "), BorderLayout.PAGE_END);
		topContainer.add(titleAndButtonCont, BorderLayout.CENTER);
		
		botButtonsPanel.add(panel);
		botButtonsPanel.add(applyButton, BorderLayout.SOUTH);
		
		//Adding the top container and bottom container
		topLevelCont.add(topContainer);
		topLevelCont.add(botButtonsPanel);
		add(topLevelCont);

		//Setting the main panel
		setResizable(false);
		//setSize(700, 450);
		setSize(1400, 900);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public void backToMain() {
		// close the current window()
		StartScreen back = new StartScreen();
		setVisible(false);
		dispose();
	}

	public void options() {
		OptionsScreen newInstance = new OptionsScreen();
		setVisible(false);
		dispose();
	}

}

