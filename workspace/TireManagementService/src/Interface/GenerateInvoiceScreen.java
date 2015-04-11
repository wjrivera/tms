package Interface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class GenerateInvoiceScreen extends JFrame {

	private static final String TITLE = "Generate Invoice";

	JButton backToMainButton;
	JScrollPane invoice;

	public GenerateInvoiceScreen() {

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		// set up the buttons
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setBackground(new Color(129, 159, 252));
		buttonsPanel.setLayout(new GridLayout(1, 3, 15, 15));

		backToMainButton = new JButton("Back To Main Screen");
		backToMainButton.setBackground(new Color(59, 89, 182));
		backToMainButton.setForeground(Color.WHITE);
		backToMainButton.setFont(new Font("Comic Sans MS Bold", Font.PLAIN, 30));

		backToMainButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				backToMain();
			}
		});

		JPanel empty1 = new JPanel();
		JPanel empty2 = new JPanel();
		empty1.setBackground(new Color(129, 159, 252));
		empty2.setBackground(new Color(129, 159, 252));
		buttonsPanel.add(empty1);
		buttonsPanel.add(backToMainButton);
		buttonsPanel.add(empty2);

		// set up the title
		JLabel titleLabel = new JLabel(TITLE, SwingConstants.CENTER);
		titleLabel.setFont(new Font("Comic Sans MS Bold", Font.BOLD, 85));

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

		// ScrollBar
		JPanel invoiceContainer = new JPanel();
		invoiceContainer.setBackground(new Color(129, 159, 252));
		invoice = new JScrollPane(invoiceContainer,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		// gridLayout for screen
		JPanel topLevelCont = new JPanel();
		topLevelCont.setBackground(new Color(129, 159, 252));
		topLevelCont.setLayout(new GridLayout(2, 1));

		topLevelCont.add(topContainer);
		topLevelCont.add(invoice);

		add(topLevelCont);

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

}
