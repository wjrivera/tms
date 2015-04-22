package Interface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import utilities.Invoice;

public class OptionsScreen extends JFrame {

	private static final String TITLE = "Options";

	JButton backToMainButton, editStoreButton, editCurrencyButton,
			setPaymentButton, addInventoryButton;

	DatabaseConnectivity dbc;

	public OptionsScreen() throws ClassNotFoundException, SQLException {

		dbc = DatabaseConnectivity.getInstance();

		setBackground(new Color(129, 159, 252));

		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		WindowListener exitListener = new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int confirm = JOptionPane.showOptionDialog(null,
						"Are You Sure to Close TMS?", "Exit Confirmation",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE, null, null, null);
				if (confirm == 0) {
					try {
						dbc.saveLastState(Invoice.NextInvoiceNumber);
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
		buttonsPanel.setBackground(new Color(129, 159, 252));
		buttonsPanel.setLayout(new GridLayout(1, 3, 15, 15));

		backToMainButton = new JButton("Back To Main Screen");

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

		JPanel filler = new JPanel();
		filler.setBackground(new Color(129, 159, 252));
		JPanel filler2 = new JPanel();
		filler2.setBackground(new Color(129, 159, 252));

		buttonsPanel.add(filler);
		buttonsPanel.add(backToMainButton);
		buttonsPanel.add(filler2);

		// set up the title
		JLabel titleLabel = new JLabel(TITLE, SwingConstants.CENTER);
		titleLabel.setFont(new Font("Serif", Font.BOLD, 45));

		// container for title and buttons
		JPanel titleAndButtonCont = new JPanel();
		titleAndButtonCont.setBackground(new Color(129, 159, 252));
		titleAndButtonCont.setLayout(new GridLayout(2, 1, 15, 15));
		titleAndButtonCont.add(titleLabel);
		titleAndButtonCont.add(buttonsPanel);

		// borderlayout to organize top half
		JPanel topContainer = new JPanel();
		topContainer.setBackground(new Color(129, 159, 252));
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
		botButtonsPanel.setBackground(new Color(129, 159, 252));
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

		pack();
		setResizable(false);
		setLocationRelativeTo(null);
		setSize(700, 450);
		setVisible(true);
	}

	public void backToMain() throws ClassNotFoundException, SQLException {
		// close the current window()
		StartScreen back = new StartScreen();
		setVisible(false);
		dispose();
	}

	public void editStoreInfo() {
		// close the current window()
		EditStoreInfo editStoreInfo = new EditStoreInfo();
		setVisible(false);
		dispose();

	}

	public void editCurrency() {
		// close the current window()
		EditCurrency editCurrency = new EditCurrency();
		setVisible(false);
		dispose();

	}

	public void setPaymentInfo() {
		// close the current window()
		SetPaymentInfo setPaymentInfo = new SetPaymentInfo();
		setVisible(false);
		dispose();

	}

	public void addInventory() {
		// close the current window()
		AddInventory addInventory = new AddInventory();
		setVisible(false);
		dispose();

	}
}
