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

public class AddInventory extends JFrame {

	private static final String TITLE = "Add Inventory";

	JButton backToMainButton, applyButton;

	public AddInventory() {

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
		backToMainButton
				.setFont(new Font("Comic Sans MS Bold", Font.PLAIN, 14));

		applyButton = new JButton("Apply Information");
		applyButton.setBackground(new Color(59, 89, 182));
		applyButton.setForeground(Color.WHITE);
		applyButton.setFont(new Font("Comic Sans MS Bold", Font.PLAIN, 14));

		JLabel titleLabel = new JLabel(TITLE, SwingConstants.CENTER);
		titleLabel.setFont(new Font("Comic Sans MS Bold", Font.BOLD, 20));

		JLabel manufacturerLabel = new JLabel("     Manufacturer: ");
		manufacturerLabel
				.setFont(new Font("Comic Sans MS Bold", Font.PLAIN, 14));
		manufacturerLabel.setBackground(new Color(59, 89, 182));
		manufacturerLabel.setForeground(Color.BLACK);
		JTextField manufacturerTextField = new JTextField();

		JLabel partNumberLabel = new JLabel("     Part Number: ");
		partNumberLabel.setFont(new Font("Comic Sans MS Bold", Font.PLAIN, 14));
		partNumberLabel.setBackground(new Color(59, 89, 182));
		partNumberLabel.setForeground(Color.BLACK);
		JTextField partNumberTextField = new JTextField();

		JLabel tireTypeLabel = new JLabel("     Tire Type: ");
		tireTypeLabel.setFont(new Font("Comic Sans MS Bold", Font.PLAIN, 14));
		tireTypeLabel.setBackground(new Color(59, 89, 182));
		tireTypeLabel.setForeground(Color.BLACK);
		JTextField tireTypeTextField = new JTextField();

		JLabel tireWidthLabel = new JLabel("     Tire Width: ");
		tireWidthLabel.setFont(new Font("Comic Sans MS Bold", Font.PLAIN, 14));
		tireWidthLabel.setBackground(new Color(59, 89, 182));
		tireWidthLabel.setForeground(Color.BLACK);
		JTextField tireWidthTextField = new JTextField();

		JLabel aspectLabel = new JLabel("     Aspect Ratio: ");
		aspectLabel.setFont(new Font("Comic Sans MS Bold", Font.PLAIN, 14));
		aspectLabel.setBackground(new Color(59, 89, 182));
		aspectLabel.setForeground(Color.BLACK);
		JTextField aspecTextField = new JTextField();

		JLabel constructionLabel = new JLabel("     Construction: ");
		constructionLabel
				.setFont(new Font("Comic Sans MS Bold", Font.PLAIN, 14));
		constructionLabel.setBackground(new Color(59, 89, 182));
		constructionLabel.setForeground(Color.BLACK);
		JTextField constructionTextField = new JTextField();

		JLabel diameterLabel = new JLabel("     Wheel Diameter: ");
		diameterLabel.setFont(new Font("Comic Sans MS Bold", Font.PLAIN, 14));
		diameterLabel.setBackground(new Color(59, 89, 182));
		diameterLabel.setForeground(Color.BLACK);
		JTextField diameterTextField = new JTextField();

		JLabel speedLabel = new JLabel("     Speed Rating: ");
		speedLabel.setFont(new Font("Comic Sans MS Bold", Font.PLAIN, 14));
		speedLabel.setBackground(new Color(59, 89, 182));
		speedLabel.setForeground(Color.BLACK);
		JTextField speedTextField = new JTextField();

		JLabel costabel = new JLabel("     Cost Price: ");
		costabel.setFont(new Font("Comic Sans MS Bold", Font.PLAIN, 14));
		costabel.setBackground(new Color(59, 89, 182));
		costabel.setForeground(Color.BLACK);
		JTextField costTextField = new JTextField();

		JLabel saleLabel = new JLabel("     Sale Price: ");
		saleLabel.setFont(new Font("Comic Sans MS Bold", Font.PLAIN, 14));
		saleLabel.setBackground(new Color(59, 89, 182));
		saleLabel.setForeground(Color.BLACK);
		JTextField saleTextField = new JTextField();

		// adding the listeners
		backToMainButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					backToMain();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		applyButton.addActionListener(new ActionListener() {
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

		// Add buttons and labels to panels
		panel.add(manufacturerLabel, BorderLayout.WEST);
		panel.add(manufacturerTextField, BorderLayout.CENTER);
		panel.add(partNumberLabel, BorderLayout.WEST);
		panel.add(partNumberTextField, BorderLayout.EAST);
		panel.add(tireTypeLabel, BorderLayout.WEST);
		panel.add(tireTypeTextField, BorderLayout.EAST);
		panel.add(tireWidthLabel, BorderLayout.WEST);
		panel.add(tireWidthTextField, BorderLayout.EAST);
		panel.add(aspectLabel, BorderLayout.WEST);
		panel.add(aspecTextField, BorderLayout.CENTER);
		panel.add(constructionLabel, BorderLayout.WEST);
		panel.add(constructionTextField, BorderLayout.EAST);
		panel.add(diameterLabel, BorderLayout.WEST);
		panel.add(diameterTextField, BorderLayout.EAST);
		panel.add(speedLabel, BorderLayout.WEST);
		panel.add(speedTextField, BorderLayout.EAST);
		panel.add(costabel, BorderLayout.WEST);
		panel.add(costTextField, BorderLayout.EAST);
		panel.add(saleLabel, BorderLayout.WEST);
		panel.add(saleTextField, BorderLayout.EAST);

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

	public void backToMain() throws ClassNotFoundException, SQLException {
		// close the current window()
		StartScreen back = new StartScreen();
		setVisible(false);
		dispose();
	}

	public void options() throws ClassNotFoundException, SQLException {
		OptionsScreen newInstance = new OptionsScreen();
		setVisible(false);
		dispose();
	}

}
