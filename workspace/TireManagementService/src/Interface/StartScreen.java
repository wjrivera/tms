package Interface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;
import java.awt.Dimension;
import java.awt.Image;

import java.util.Date;
import java.io.*;
import java.io.File.*;

import javax.imageio.ImageIO;
import javax.swing.*;

public class StartScreen extends JFrame {

	public static final String TITLE = "Tire Management System";

	JMenuBar menuBar;
	JMenu menu, submenu;
	JMenuItem menuItem;
	JRadioButtonMenuItem rbMenuItem;
	JCheckBoxMenuItem cbMenuItem;

	//hello
	JPanel screenLayout;
	JPanel buttonsLayout;
	JPanel centerPanel;

	JLabel titleLabel;

	JTextField searchField;

	JButton searchByDateButton, searchByCustomerButton, optionsButton,
			generateInvoiceButton;

	public StartScreen() {

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		screenLayout = new JPanel();
		screenLayout.setLayout(new BorderLayout());
		screenLayout.setBackground(new Color(129, 159, 252));
		

		File fn = new File("logo.png");
		if(fn.exists()){
			System.out.println("File Exists");
		}

		titleLabel = new JLabel(TITLE, SwingConstants.CENTER);
		titleLabel.setFont(new Font("Comic Sans MS Bold", Font.BOLD, 85));

		JPanel searchFieldPanel = new JPanel();
		searchFieldPanel.setBackground(new Color(129, 159, 252));
		
		searchFieldPanel.setLayout(new FlowLayout());
		searchField = new JTextField();
		searchField = new JTextField(
				"Search here                                                                      ");
		
		searchField.setFont(new Font("Comic Sans MS Bold", Font.PLAIN, 20));
		searchField.setBackground(new Color(59, 89, 182));
		searchField.setForeground(Color.WHITE);

		centerPanel = new JPanel();
		centerPanel.setBackground(new Color(129, 159, 252));
		centerPanel.setLayout(new GridLayout(2, 1));
		buttonsLayout = new JPanel();
		buttonsLayout.setBackground(new Color(129, 159, 252));
		buttonsLayout.setLayout(new GridLayout(2, 2, 15, 15));

		JPanel holder = new JPanel();
		holder.setLayout(new BorderLayout());
		//holder.setBackground(new Color(59, 89, 182));
		holder.setBackground(new Color(129, 159, 252));

		searchFieldPanel.add(searchField);
		holder.add(searchFieldPanel, BorderLayout.PAGE_END);
		
		
		
		
		ImageIcon logoIcon = new ImageIcon("logo.png");	
		Image image = logoIcon.getImage();
		Image newImage = image.getScaledInstance(1200, 350, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newLogo = new ImageIcon(newImage);
		
		JLabel logo = new JLabel(newLogo);
		logo.setPreferredSize(new Dimension(650, 500));
		
		//holder.add(titleLabel, BorderLayout.CENTER);
		holder.add(logo);
		
		
		


		centerPanel.add(holder);

		searchByDateButton = new JButton("Search by Date");
		searchByCustomerButton = new JButton("Search by Customer");
		optionsButton = new JButton("Options");
		generateInvoiceButton = new JButton("Generate Invoice");
		
		searchByDateButton.setBackground(new Color(59, 89, 182));
		searchByDateButton.setForeground(Color.WHITE);
		searchByCustomerButton.setBackground(new Color(59, 89, 182));
		searchByCustomerButton.setForeground(Color.WHITE);
		optionsButton.setBackground(new Color(59, 89, 182));
		optionsButton.setForeground(Color.WHITE);
		generateInvoiceButton.setBackground(new Color(59, 89, 182));
		generateInvoiceButton.setForeground(Color.WHITE);
		
		searchByDateButton.setFont(new Font("Comic Sans MS Bold", Font.PLAIN, 60));
		searchByCustomerButton.setFont(new Font("Comic Sans MS Bold", Font.PLAIN, 60));
		optionsButton.setFont(new Font("Comic Sans MS Bold", Font.PLAIN, 60));
		generateInvoiceButton.setFont(new Font("Comic Sans MS Bold", Font.PLAIN, 60));
		
		searchByDateButton.setToolTipText("Click here to search the workorders by date going from today, yesterday, last week, etc.");
		searchByCustomerButton.setToolTipText("Click here to search the workorders by customer names arranged in alphabetical order.");
		optionsButton.setToolTipText("Click here to change settings like store information, currency used, payment information and inventory management");
		generateInvoiceButton.setToolTipText("Click here to automaticall generate the invoice currently in use.");
		searchField.setToolTipText("Click here to search for customers, tires, services, etc.");

		// adding the listeners
		searchByDateButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				searchByDate(null);
			}

		});
		searchByCustomerButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				searchByCustomer(searchField.getText());
			}

		});
		optionsButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				options();
			}

		});
		generateInvoiceButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				generateInvoice();
			}

		});
		
		searchField.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                searchField.setText("");
        		searchField.setBackground(new Color(255, 255, 255));
            }
        });

		buttonsLayout.add(searchByDateButton);
		buttonsLayout.add(searchByCustomerButton);
		buttonsLayout.add(optionsButton);
		buttonsLayout.add(generateInvoiceButton);

		centerPanel.add(buttonsLayout);

		// fillers
		screenLayout.add(new JLabel("         "), BorderLayout.LINE_START);
		screenLayout.add(new JLabel("         "), BorderLayout.LINE_END);
		// end fillers
		screenLayout.add(centerPanel, BorderLayout.CENTER);

		this.add(screenLayout);

		setResizable(false);

		//setSize(700, 450);
		setSize(1400, 900);
		setLocationRelativeTo(null);
		setVisible(true);

	}

	public void searchByDate(Date d) {
		DateSearchScreen newInstance = new DateSearchScreen();
		setVisible(false);
		dispose();
	}

	public void searchByCustomer(String cust) {
		CustomerSearchScreen newInstance = new CustomerSearchScreen();
		setVisible(false);
		dispose();
	}

	public void options() {
		OptionsScreen newInstance = new OptionsScreen();
		setVisible(false);
		dispose();
	}

	public void generateInvoice() {
		GenerateInvoiceScreen newInstance = new GenerateInvoiceScreen();
		setVisible(false);
		dispose();
	}

	public static void main(String[] args) {
		StartScreen start = new StartScreen();
	}

}
