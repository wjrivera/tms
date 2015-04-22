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

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

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
		backToMainButton
				.setFont(new Font("Comic Sans MS Bold", Font.PLAIN, 14));

		applyButton = new JButton("Apply Information");
		applyButton.setBackground(new Color(59, 89, 182));
		applyButton.setForeground(Color.WHITE);
		applyButton.setFont(new Font("Comic Sans MS Bold", Font.PLAIN, 14));

		JLabel titleLabel = new JLabel(TITLE, SwingConstants.CENTER);
		titleLabel.setFont(new Font("Comic Sans MS Bold", Font.BOLD, 20));
		// JLabel companyLabel = new JLabel("     Company Name: ");
		// JTextField companyTextField = new JTextField();
		// JLabel addressLabel = new JLabel("     Address: ");
		// JTextField addressTextField = new JTextField();
		// JLabel cityLabel = new JLabel("     City: ");
		// JTextField cityTextField = new JTextField();
		// JLabel stateLabel = new JLabel("     State: ");
		// JTextField stateTextField = new JTextField();
		// JLabel zipLabel = new JLabel("     Zip Code: ");
		// JTextField zipTextField = new JTextField();
		// JLabel phoneLabel = new JLabel("     Phone Number: ");
		// JTextField phoneTextField = new JTextField();
		// JLabel faxLabel = new JLabel("     Fax Number: ");
		// JTextField faxTextField = new JTextField();
		// JLabel emailLabel = new JLabel("     Email Address: ");
		// JTextField emailTextField = new JTextField();
		// JLabel countyLabel = new JLabel("     County: ");
		// JTextField countyTextField = new JTextField();
		// JLabel taxLabel = new JLabel("     Tax ID#: ");
		// JTextField taxTextField = new JTextField();

		JRadioButton usd = new JRadioButton("   USD");
		usd.setBackground(new Color(129, 159, 252));
		JRadioButton chf = new JRadioButton("   CHF");
		chf.setBackground(new Color(129, 159, 252));
		JRadioButton zar = new JRadioButton("   ZAR");
		zar.setBackground(new Color(129, 159, 252));
		JRadioButton eur = new JRadioButton("   EUR");
		eur.setBackground(new Color(129, 159, 252));
		JRadioButton cad = new JRadioButton("   CAD");
		cad.setBackground(new Color(129, 159, 252));
		JRadioButton hkd = new JRadioButton("   HKD");
		hkd.setBackground(new Color(129, 159, 252));
		JRadioButton jpy = new JRadioButton("   JPY");
		jpy.setBackground(new Color(129, 159, 252));
		JRadioButton aud = new JRadioButton("   AUD");
		aud.setBackground(new Color(129, 159, 252));
		JRadioButton inr = new JRadioButton("   INR");
		inr.setBackground(new Color(129, 159, 252));
		JRadioButton gbp = new JRadioButton("   GBP");
		gbp.setBackground(new Color(129, 159, 252));
		JRadioButton nzd = new JRadioButton("   NZD");
		nzd.setBackground(new Color(129, 159, 252));
		JRadioButton twd = new JRadioButton("   TWD");
		twd.setBackground(new Color(129, 159, 252));

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

		// panel.add(buttonGroup);
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

		// panel.add(buttonGroup);
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