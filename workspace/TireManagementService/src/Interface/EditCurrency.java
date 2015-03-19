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

public class EditCurrency extends JFrame {

	private static final String TITLE = "Edit Currency";

	JButton backToMainButton, applyButton;

	public EditCurrency() {

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		GridLayout gridLayout = new GridLayout(0, 3);

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
//		JLabel companyLabel = new JLabel("     Company Name: ");
//		JTextField companyTextField = new JTextField();
//		JLabel addressLabel = new JLabel("     Address: ");
//		JTextField addressTextField = new JTextField();
//		JLabel cityLabel = new JLabel("     City: ");
//		JTextField cityTextField = new JTextField();
//		JLabel stateLabel = new JLabel("     State: ");
//		JTextField stateTextField = new JTextField();
//		JLabel zipLabel = new JLabel("     Zip Code: ");
//		JTextField zipTextField = new JTextField();
//		JLabel phoneLabel = new JLabel("     Phone Number: ");
//		JTextField phoneTextField = new JTextField();
//		JLabel faxLabel = new JLabel("     Fax Number: ");
//		JTextField faxTextField = new JTextField();
//		JLabel emailLabel = new JLabel("     Email Address: ");
//		JTextField emailTextField = new JTextField();
//		JLabel countyLabel = new JLabel("     County: ");
//		JTextField countyTextField = new JTextField();
//		JLabel taxLabel = new JLabel("     Tax ID#: ");
//		JTextField taxTextField = new JTextField();
		
		JRadioButton usd = new JRadioButton("   USD");
		JRadioButton chf = new JRadioButton("   CHF");
		JRadioButton zar = new JRadioButton("   ZAR");
		JRadioButton eur = new JRadioButton("   EUR");
		JRadioButton cad = new JRadioButton("   CAD");
		JRadioButton hkd = new JRadioButton("   HKD");
		JRadioButton jpy = new JRadioButton("   JPY");
		JRadioButton aud = new JRadioButton("   AUD");
		JRadioButton inr = new JRadioButton("   INR");
		JRadioButton gbp = new JRadioButton("   GBP");
		JRadioButton nzd = new JRadioButton("   NZD");
		JRadioButton twd = new JRadioButton("   TWD");

		usd.setHorizontalAlignment(AbstractButton.CENTER);
		chf.setHorizontalAlignment(AbstractButton.CENTER);
		zar.setHorizontalAlignment(AbstractButton.CENTER);
		eur.setHorizontalAlignment(AbstractButton.CENTER);
		cad.setHorizontalAlignment(AbstractButton.CENTER);
		hkd.setHorizontalAlignment(AbstractButton.CENTER);
		jpy.setHorizontalAlignment(AbstractButton.CENTER);
		aud.setHorizontalAlignment(AbstractButton.CENTER);
		inr.setHorizontalAlignment(AbstractButton.CENTER);
		gbp.setHorizontalAlignment(AbstractButton.CENTER);
		nzd.setHorizontalAlignment(AbstractButton.CENTER);
		twd.setHorizontalAlignment(AbstractButton.CENTER);
		panel.add(usd);
		panel.add(chf);
		panel.add(zar);
		panel.add(eur);
		panel.add(cad);
		panel.add(hkd);
		panel.add(jpy);
		panel.add(aud);
		panel.add(inr);
		panel.add(gbp);
		panel.add(nzd);
		panel.add(twd);


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
//		panel.add(companyLabel,BorderLayout.WEST);
//		panel.add(companyTextField,BorderLayout.CENTER);
//		panel.add(phoneLabel,BorderLayout.WEST);
//		panel.add(phoneTextField,BorderLayout.EAST);
//		
//		panel.add(addressLabel,BorderLayout.WEST);
//		panel.add(addressTextField,BorderLayout.EAST);
//		panel.add(faxLabel,BorderLayout.WEST);
//		panel.add(faxTextField,BorderLayout.EAST);
//		
//		
//		panel.add(cityLabel,BorderLayout.WEST);
//		panel.add(cityTextField,BorderLayout.EAST);
//		panel.add(emailLabel,BorderLayout.WEST);
//		panel.add(emailTextField,BorderLayout.EAST);
//		
//		panel.add(stateLabel,BorderLayout.WEST);
//		panel.add(stateTextField,BorderLayout.EAST);
//		panel.add(countyLabel,BorderLayout.WEST);
//		panel.add(countyTextField,BorderLayout.EAST);
//		
//		panel.add(zipLabel,BorderLayout.WEST);
//		panel.add(zipTextField,BorderLayout.CENTER);
//
//
//		panel.add(taxLabel,BorderLayout.WEST);
//		panel.add(taxTextField,BorderLayout.EAST);
		
		//panel.add(buttonGroup);
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
		
		//panel.add(buttonGroup);
		botButtonsPanel.add(panel);
		botButtonsPanel.add(applyButton, BorderLayout.SOUTH);
		
		//Adding the top container and bottom container
		topLevelCont.add(topContainer);
		topLevelCont.add(botButtonsPanel);
		add(topLevelCont);

		//Setting the main panel
		setResizable(false);
		setSize(700, 450);
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

