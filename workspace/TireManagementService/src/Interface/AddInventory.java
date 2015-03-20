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
		
		JLabel manufacturerLabel = new JLabel("     Manufacturer: ");
		JTextField manufacturerTextField = new JTextField();
		JLabel partNumberLabel = new JLabel("     Part Number: ");
		JTextField partNumberTextField = new JTextField();
		JLabel tireTypeLabel = new JLabel("     Tire Type: ");
		JTextField tireTypeTextField = new JTextField();
		JLabel tireWidthLabel = new JLabel("     Tire Width: ");
		JTextField tireWidthTextField = new JTextField();
		JLabel aspectLabel = new JLabel("     Aspect Ratio: ");
		JTextField aspecTextField = new JTextField();
		JLabel constructionLabel = new JLabel("     Construction: ");
		JTextField constructionTextField = new JTextField();
		JLabel diameterLabel = new JLabel("     Wheel Diameter: ");
		JTextField diameterTextField = new JTextField();
		JLabel speedLabel = new JLabel("     Speed Rating: ");
		JTextField speedTextField = new JTextField();
		JLabel costabel = new JLabel("     Cost Price: ");
		JTextField costTextField = new JTextField();
		JLabel saleLabel = new JLabel("     Sale Price: ");
		JTextField saleTextField = new JTextField();

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
		panel.add(manufacturerLabel,BorderLayout.WEST);
		panel.add(manufacturerTextField,BorderLayout.CENTER);
		panel.add(partNumberLabel,BorderLayout.WEST);
		panel.add(partNumberTextField,BorderLayout.EAST);
		panel.add(tireTypeLabel,BorderLayout.WEST);
		panel.add(tireTypeTextField,BorderLayout.EAST);
		panel.add(tireWidthLabel,BorderLayout.WEST);
		panel.add(tireWidthTextField,BorderLayout.EAST);		
		panel.add(aspectLabel,BorderLayout.WEST);
		panel.add(aspecTextField,BorderLayout.CENTER);		
		panel.add(constructionLabel,BorderLayout.WEST);
		panel.add(constructionTextField,BorderLayout.EAST);
		panel.add(diameterLabel,BorderLayout.WEST);
		panel.add(diameterTextField,BorderLayout.EAST);
		panel.add(speedLabel,BorderLayout.WEST);
		panel.add(speedTextField,BorderLayout.EAST);
		panel.add(costabel,BorderLayout.WEST);
		panel.add(costTextField,BorderLayout.EAST);
		panel.add(saleLabel,BorderLayout.WEST);
		panel.add(saleTextField,BorderLayout.EAST);
		
		
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

