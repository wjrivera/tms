package Interface;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import utilities.Client;
import utilities.Vehicle;

public class NewInvoiceScreen extends JPanel {

	public static final String TITLE = "Add Invoice";

	public JButton addVehicle, removeVehicle, addNewClient, addJob, removeJob;
	public JTextField name, email, phoneNumber, address, city, state, zip;
	private JLabel n, e, p, a, c, s, z, selectedVehicle;
	private JScrollPane vehiclesScroll;
	private VehicleListModel vLM;
	private JList vehiclesList;
	private Client client;
	private NewCustomerScreen newCust;

	public NewInvoiceScreen(Client cl) {

		client = cl;

		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

		n = new JLabel("Bill To");
		e = new JLabel("E-Mail");
		p = new JLabel("Phone Number");
		a = new JLabel("Address");
		c = new JLabel("City");
		s = new JLabel("State");
		z = new JLabel("zip");

		selectedVehicle = new JLabel("Selected Vehicle: ");

		if (client != null) {

			for (Vehicle v : client.getVehicle()) {
				System.out.println(v);
			}
			name = new JTextField(client.toString());
			email = new JTextField(client.getEmail());
			phoneNumber = new JTextField(client.getPhoneNumber());
			address = new JTextField(client.getAddress());
			city = new JTextField(client.getCity());
			state = new JTextField(client.getState());
			zip = new JTextField(client.getZip());
		} else {
			name = new JTextField();
			email = new JTextField();
			phoneNumber = new JTextField();
			address = new JTextField();
			city = new JTextField();
			state = new JTextField();
			zip = new JTextField();
		}

		addVehicle = new JButton("Add New Vehicle");
		removeVehicle = new JButton("Remove Vehicle");
		addJob = new JButton("Add Job");
		removeJob = new JButton("Remove Job");
		
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

		vehiclesScroll = getScrollPane();

		JPanel infoPanel = new JPanel();
		infoPanel.setLayout(new GridLayout(9, 2, 15, 15));

		infoPanel.add(n);
		infoPanel.add(name);
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
		add(vehiclesScroll);
		add(selectedVehicle);

	}

	private JScrollPane getScrollPane() {

		JScrollPane temp;

		vLM = new VehicleListModel(client.getVehicle());

		vehiclesList = new JList(vLM);
		vehiclesList.setFont(new Font("Serif", Font.PLAIN, 13));
		vehiclesList.setCellRenderer(new DefaultListCellRenderer());
		vehiclesList.setVisibleRowCount(3);

		vehiclesList.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent lse) {
				if (!lse.getValueIsAdjusting()) {
					selectedVehicle.setText("Selected Vehicle: "
							+ vehiclesList.getSelectedValue().toString());
				}
			}
		});

		temp = new JScrollPane(vehiclesList,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		return temp;

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
			vLM.add(temp);
		}

		// TODO Add vehicles to client
	}

	private void removeVehicle() {

		// TODO Remove vehicles from client
		vLM.remove(vehiclesList.getSelectedIndex());
	}

	class NewVehicleScreen extends JPanel {

		public static final String TITLE = "Add New Vehicle";
		public JTextField year, make, model;
		private JLabel y, mak, mod;

		public NewVehicleScreen() {

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
