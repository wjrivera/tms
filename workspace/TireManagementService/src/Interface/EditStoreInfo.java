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
import java.awt.*;

import javax.swing.*;

public class EditStoreInfo extends JFrame {

	private static final String TITLE = "Edit Store Information";

	JButton backToMainButton, applyButton;

	public EditStoreInfo() {

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
		
//		buttonsPanel.setBackground(new Color(240, 250, 240));
//		titleAndButtonCont.setBackground(new Color(0, 250, 240));
//		topContainer.setBackground(new Color(240, 0, 240));
//		botButtonsPanel.setBackground(new Color(240, 250, 0));
//		topLevelCont.setBackground(new Color(0, 255, 0));
		
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
		backToMainButton.setFont(new Font("Comic Sans MS Bold", Font.PLAIN, 30));
		
		applyButton = new JButton("Apply Information");
		applyButton.setBackground(new Color(59, 89, 182));
		applyButton.setForeground(Color.WHITE);
		applyButton.setFont(new Font("Comic Sans MS Bold", Font.PLAIN, 30));
		
		JLabel titleLabel = new JLabel(TITLE, SwingConstants.CENTER);
		titleLabel.setFont(new Font("Comic Sans MS Bold", Font.BOLD, 85));
		
		JLabel companyLabel = new JLabel("     Company Name: ");
		companyLabel.setFont(new Font("Comic Sans MS Bold", Font.PLAIN, 20));
		companyLabel.setBackground(new Color(59, 89, 182));
		companyLabel.setForeground(Color.BLACK);		
		JTextField companyTextField = new JTextField();
		
		JLabel addressLabel = new JLabel("     Address: ");
		addressLabel.setFont(new Font("Comic Sans MS Bold", Font.PLAIN, 20));
		addressLabel.setBackground(new Color(59, 89, 182));
		addressLabel.setForeground(Color.BLACK);
		JTextField addressTextField = new JTextField();
		
		JLabel cityLabel = new JLabel("     City: ");
		cityLabel.setFont(new Font("Comic Sans MS Bold", Font.PLAIN, 20));
		cityLabel.setBackground(new Color(59, 89, 182));
		cityLabel.setForeground(Color.BLACK);
		JTextField cityTextField = new JTextField();
		
		JLabel stateLabel = new JLabel("     State: ");
		stateLabel.setFont(new Font("Comic Sans MS Bold", Font.PLAIN, 20));
		stateLabel.setBackground(new Color(59, 89, 182));
		stateLabel.setForeground(Color.BLACK);
		JTextField stateTextField = new JTextField();
		
		JLabel zipLabel = new JLabel("     Zip Code: ");
		zipLabel.setFont(new Font("Comic Sans MS Bold", Font.PLAIN, 20));
		zipLabel.setBackground(new Color(59, 89, 182));
		zipLabel.setForeground(Color.BLACK);
		JTextField zipTextField = new JTextField();
		
		JLabel phoneLabel = new JLabel("     Phone Number: ");
		phoneLabel.setFont(new Font("Comic Sans MS Bold", Font.PLAIN, 20));
		phoneLabel.setBackground(new Color(59, 89, 182));
		phoneLabel.setForeground(Color.BLACK);
		JTextField phoneTextField = new JTextField();
		
		JLabel faxLabel = new JLabel("     Fax Number: ");
		faxLabel.setFont(new Font("Comic Sans MS Bold", Font.PLAIN, 20));
		faxLabel.setBackground(new Color(59, 89, 182));
		faxLabel.setForeground(Color.BLACK);
		JTextField faxTextField = new JTextField();
		
		JLabel emailLabel = new JLabel("     Email Address: ");
		emailLabel.setFont(new Font("Comic Sans MS Bold", Font.PLAIN, 20));
		emailLabel.setBackground(new Color(59, 89, 182));
		emailLabel.setForeground(Color.BLACK);
		JTextField emailTextField = new JTextField();
		
		JLabel countyLabel = new JLabel("     County: ");
		countyLabel.setFont(new Font("Comic Sans MS Bold", Font.PLAIN, 20));
		countyLabel.setBackground(new Color(59, 89, 182));
		countyLabel.setForeground(Color.BLACK);
		JTextField countyTextField = new JTextField();
		
		JLabel taxLabel = new JLabel("     Tax ID#: ");
		taxLabel.setFont(new Font("Comic Sans MS Bold", Font.PLAIN, 20));
		taxLabel.setBackground(new Color(59, 89, 182));
		taxLabel.setForeground(Color.BLACK);
		JTextField taxTextField = new JTextField();

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
		panel.add(companyLabel,BorderLayout.WEST);
		panel.add(companyTextField,BorderLayout.CENTER);
		panel.add(phoneLabel,BorderLayout.WEST);
		panel.add(phoneTextField,BorderLayout.EAST);
		
		panel.add(addressLabel,BorderLayout.WEST);
		panel.add(addressTextField,BorderLayout.EAST);
		panel.add(faxLabel,BorderLayout.WEST);
		panel.add(faxTextField,BorderLayout.EAST);
		
		
		panel.add(cityLabel,BorderLayout.WEST);
		panel.add(cityTextField,BorderLayout.EAST);
		panel.add(emailLabel,BorderLayout.WEST);
		panel.add(emailTextField,BorderLayout.EAST);
		
		panel.add(stateLabel,BorderLayout.WEST);
		panel.add(stateTextField,BorderLayout.EAST);
		panel.add(countyLabel,BorderLayout.WEST);
		panel.add(countyTextField,BorderLayout.EAST);
		
		panel.add(zipLabel,BorderLayout.WEST);
		panel.add(zipTextField,BorderLayout.CENTER);




		panel.add(taxLabel,BorderLayout.WEST);
		panel.add(taxTextField,BorderLayout.EAST);
		titleAndButtonCont.add(titleLabel);			//adding title label to top panel
		titleAndButtonCont.add(buttonsPanel);		//adding buttonsPanel to top panel		
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

