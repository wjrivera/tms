//This Class is to edit the Store Information
//It needs access to the database
//Please modify asap now
package Interface;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class EditStoreInfo extends JFrame {

	private static final String TITLE = "Edit Store Information";

	JButton backToMainButton, editStoreButton, editCurrencyButton,
			setPaymentButton, addInventoryButton;

	public EditStoreInfo() {

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		// set up the buttons
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new GridLayout(1, 3, 15, 15));

		backToMainButton = new JButton("Back To Main Screen");

		backToMainButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				backToMain();
			}
		});

		buttonsPanel.add(new JPanel());
		buttonsPanel.add(backToMainButton);
		buttonsPanel.add(new JPanel());

		// set up the title
		JLabel titleLabel = new JLabel(TITLE, SwingConstants.CENTER);
		titleLabel.setFont(new Font("Serif", Font.BOLD, 35));

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

		// Bottom Panel with Buttons
		JPanel botButtonsPanel = new JPanel();
		botButtonsPanel.setLayout(new GridLayout(2, 2, 15, 15));

		editStoreButton = new JButton("Edit Store Info");
		editCurrencyButton = new JButton("Edit Currency");
		setPaymentButton = new JButton("Set Payment Info");
		addInventoryButton = new JButton("Add Inventory");

		// adding the listeners
		editStoreButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				editStoreInfo();
			}

		});
		editCurrencyButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				editCurrency();
			}

		});
		setPaymentButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setPaymentInfo();
			}

		});
		addInventoryButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				addInventory();
			}

		});

		botButtonsPanel.add(editStoreButton);
		botButtonsPanel.add(editCurrencyButton);
		botButtonsPanel.add(setPaymentButton);
		botButtonsPanel.add(addInventoryButton);

		// gridLayout for screen
		JPanel topLevelCont = new JPanel();
		topLevelCont.setLayout(new GridLayout(2, 1));

		topLevelCont.add(topContainer);
		topLevelCont.add(botButtonsPanel);

		add(topLevelCont);

		setResizable(false);
		setLocationRelativeTo(null);
		setSize(700, 450);
		setVisible(true);
	}

	public void backToMain() {
		// close the current window()
		StartScreen back = new StartScreen();
		setVisible(false);
		dispose();
	}

	public void editStoreInfo() {
		// close the current window()
		//EditStoreInfo editStoreInfo = new EditStoreInfo();
		setVisible(false);
		dispose();

	}

	public void editCurrency() {

	}

	public void setPaymentInfo() {

	}

	public void addInventory() {

	}
}

