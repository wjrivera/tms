package Interface;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import utilities.Client;

public class GenerateInvoiceScreen extends JFrame {

	private static final String TITLE = "Generate Invoice";

	JButton backToMainButton, addInvoice;
	JScrollPane invoice;
	NewInvoiceScreen screen;

	public GenerateInvoiceScreen(Client c) {

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		// set up the buttons
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new GridLayout(1, 5, 15, 15));

		backToMainButton = new JButton("Back To Main Screen");
		addInvoice = new JButton("Add Invoice");
		
		backToMainButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				backToMain();
			}
		});
		addInvoice.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				addInvoice();
			}
		});

		buttonsPanel.add(new JPanel());
		buttonsPanel.add(addInvoice);
		buttonsPanel.add(new JPanel());
		buttonsPanel.add(backToMainButton);
		buttonsPanel.add(new JPanel());

		// set up the title
		JLabel titleLabel = new JLabel(TITLE, SwingConstants.CENTER);
		titleLabel.setFont(new Font("Serif", Font.BOLD, 45));

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

		screen = new NewInvoiceScreen(c);
		// ScrollBar
		invoice = new JScrollPane(screen,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		invoice.setViewportBorder(BorderFactory.createEmptyBorder(10, 10, 10,
				10));

		// gridLayout for screen
		JPanel topLevelCont = new JPanel();
		topLevelCont.setLayout(new GridLayout(2, 1));

		topLevelCont.add(topContainer);
		topLevelCont.add(invoice);

		add(topLevelCont);

		pack();
		setResizable(false);
		setLocationRelativeTo(null);
		setSize(700, 450);
		setVisible(true);
	}
	
	public void addInvoice(){
		
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

}
