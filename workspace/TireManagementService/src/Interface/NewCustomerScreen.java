package Interface;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import utilities.Vehicle;

public class NewCustomerScreen extends JPanel {

	public static final String TITLE = "Add New Customer";
	public JTextField firstName, lastName, email, phoneNumber, address, city,
			state, zip;
	private JLabel f, l, e, p, a, c, s, z;
	private VehicleListModel vLM;
	public List<Vehicle> vehicles;
	private JList vehiclesList;
	private JScrollPane vehicleSP;
	private JButton addVehicle, removeVehicle;

	public NewCustomerScreen() {
	
		setBackground(new Color(129, 159, 252));
		
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

		vehicles = new ArrayList<Vehicle>();

		JPanel vehiclesPane = new JPanel();
		vehiclesPane.setBackground(new Color(129, 159, 252));
		vehiclesPane.setLayout(new GridLayout(1, 2, 15, 15));

		f = new JLabel("First Name");
		l = new JLabel("Last Name");
		e = new JLabel("e-mail");
		p = new JLabel("Phone Number");
		a = new JLabel("Address");
		c = new JLabel("City");
		s = new JLabel("State");
		z = new JLabel("Zip Code");

		firstName = new JTextField();
		lastName = new JTextField();
		email = new JTextField();
		phoneNumber = new JTextField();
		address = new JTextField();
		city = new JTextField();
		state = new JTextField();
		zip = new JTextField();

		vehicleSP = getScrollPane();

		addVehicle = new JButton("Add New Vehicle");
		removeVehicle = new JButton("Remove Vehicle");

		addVehicle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				addVehicle();
			}
		});

		removeVehicle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				removeVehicle();
			}
		});

		JPanel infoPanel = new JPanel();
		infoPanel.setBackground(new Color(129, 159, 252));
		infoPanel.setLayout(new GridLayout(9, 2, 15, 15));

		// Adding the Fields
		infoPanel.add(f);
		infoPanel.add(firstName);
		infoPanel.add(l);
		infoPanel.add(lastName);
		infoPanel.add(e);
		infoPanel.add(email);
		infoPanel.add(p);
		infoPanel.add(phoneNumber);
		infoPanel.add(a);
		infoPanel.add(address);
		infoPanel.add(c);
		infoPanel.add(city);
		infoPanel.add(s);
		infoPanel.add(state);
		infoPanel.add(z);
		infoPanel.add(zip);
		infoPanel.add(addVehicle);
		infoPanel.add(removeVehicle);

		add(infoPanel);
		add(vehicleSP);

		setVisible(true);
	}

	private JScrollPane getScrollPane() {

		vLM = new VehicleListModel(vehicles);

		vehiclesList = new JList(vLM);
		vehiclesList.setFont(new Font("Serif", Font.PLAIN, 13));
		vehiclesList.setCellRenderer(new DefaultListCellRenderer());
		vehiclesList.setVisibleRowCount(3);

		return new JScrollPane(vehiclesList,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

	}

	private void addVehicle() {

		NewVehicleScreen vehicleInfo = new NewVehicleScreen();

		int result = JOptionPane.showConfirmDialog(null, vehicleInfo,
				NewVehicleScreen.TITLE, JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.PLAIN_MESSAGE);

		if (result == JOptionPane.OK_OPTION) {
			Vehicle temp = new Vehicle(Integer.parseInt(vehicleInfo.year
					.getText()), vehicleInfo.make.getText(),
					vehicleInfo.model.getText());

			vehicles.add(temp);
			vLM.add(temp);
		}
	}

	private void removeVehicle() {

		vLM.remove(vehiclesList.getSelectedIndex());
		vehicles.remove(vehiclesList.getSelectedIndex());

	}

	class NewVehicleScreen extends JPanel {

		public static final String TITLE = "Add New Vehicle";
		public JTextField year, make, model;
		private JLabel y, mak, mod;

		public NewVehicleScreen() {

			setBackground(new Color(129, 159, 252));
			
			setLayout(new GridLayout(3, 2, 15, 15));

			year = new JTextField();
			make = new JTextField();
			model = new JTextField();

			y = new JLabel("Year");
			mak = new JLabel("Make");
			mod = new JLabel("Model");

			add(y);
			add(year);
			add(mak);
			add(make);
			add(mod);
			add(model);

			setVisible(true);

		}
	}
}
