package Interface;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import utilities.Client;
import utilities.Invoice;
import utilities.Job;
import utilities.Tire;
import utilities.Vehicle;

/**
 * Class used to display JPanel information correctly
 * 
 * 
 */
public class NewInvoiceScreen extends JPanel {

	public static final String TITLE = "Add Invoice";
	public static final SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");

	public JButton addVehicle, removeVehicle, addNewClient, addJob, removeJob;
	public JTextField name, email, phoneNumber, address, city, state, zip,
			month, day, year;
	private JLabel n, e, p, a, c, s, z, selectedVehicle, jobsTotal, date;
	private JScrollPane vehiclesScroll, jobsScroll;
	private VehicleListModel vLM;
	public Vehicle currentVehicle;
	private JobsListModel jLM;
	private JList vehiclesList, jobsList;
	public Client client;
	private NewCustomerScreen newCust;
	public List<Job> jobs;
	public List<Tire> tires;
	public Invoice i;

	public NewInvoiceScreen(Client cl, Invoice in) {

		setBackground(Color.WHITE);

		client = cl;

		jobs = new ArrayList<Job>();

		if (in != null) {
			System.out.println("in is not null");
			i = in;
			jobs = in.getJobs();
		} else {
			System.out.println("in is null");
		}

		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

		n = new JLabel("Bill To");
		e = new JLabel("E-Mail");
		p = new JLabel("Phone Number");
		a = new JLabel("Address");
		c = new JLabel("City");
		s = new JLabel("State");
		z = new JLabel("Zip");
		date = new JLabel("Date (MM DD YY):");

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

		Calendar cal = Calendar.getInstance();
		month = new JTextField("" + (cal.get(Calendar.MONTH) + 1));
		day = new JTextField("" + cal.get(Calendar.DAY_OF_MONTH));
		year = new JTextField("" + cal.get(Calendar.YEAR));

		if (i != null) {

			cal.setTime(i.getDate());
			name.setText(i.getBillTo());
			month.setText("" + cal.get(Calendar.MONTH));
			day.setText("" + cal.get(Calendar.DAY_OF_MONTH));
			year.setText("" + cal.get(Calendar.YEAR));
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

		addJob.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				addJob();
			}
		});

		removeJob.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				removeJob();
			}
		});

		vehiclesScroll = getScrollPane();
		jobsScroll = getJobsPane();

		JLabel invoiceNumber;

		if (in == null) {
			invoiceNumber = new JLabel("Invoice Number "
					+ Invoice.NextInvoiceNumber);
		} else {
			invoiceNumber = new JLabel("Invoice Number " + i.getInvoiceNumber());
		}
		invoiceNumber.setFont(new Font("Serif", Font.BOLD, 20));

		JLabel billingInfo = new JLabel("Billing Information");
		billingInfo.setFont(new Font("Serif", Font.BOLD, 17));
		add(invoiceNumber);
		add(billingInfo);
		add(new JLabel(" "));

		JPanel datePanel = new JPanel(new GridLayout(1, 3, 15, 15));
		datePanel.add(month);
		datePanel.add(day);
		datePanel.add(year);

		JPanel infoPanel = new JPanel();
		infoPanel.setBackground(Color.WHITE);
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
		infoPanel.add(date);
		infoPanel.add(datePanel);

		JLabel vehicleLabel = new JLabel("Vehicle");
		vehicleLabel.setFont(new Font("Serif", Font.BOLD, 17));

		JPanel vehicleButtons = new JPanel(new GridLayout(1, 2, 15, 15));
		vehicleButtons.setBackground(Color.WHITE);
		vehicleButtons.add(addVehicle);
		vehicleButtons.add(removeVehicle);

		add(infoPanel);

		add(vehicleLabel);
		add(new JLabel(" "));
		add(vehicleButtons);

		add(vehiclesScroll);
		add(selectedVehicle);
		add(new JLabel(" "));

		JLabel jobsLabel = new JLabel("Jobs");
		jobsLabel.setFont(new Font("Serif", Font.BOLD, 17));
		add(jobsLabel);

		JPanel jobsPanel = new JPanel();
		jobsPanel.setBackground(Color.WHITE);
		JPanel jobButtons = new JPanel(new GridLayout(1, 2, 15, 15));
		jobButtons.add(addJob);
		jobButtons.add(removeJob);

		jobsPanel.add(jobButtons);
		add(jobsPanel);
		add(jobsScroll);

		jobsTotal = new JLabel("Jobs Total: $" + getJobsTotal());
		jobsTotal.setFont(new Font("Serif", Font.PLAIN, 17));

		add(jobsTotal);

	}

	private void updateTotals() {

		jobsTotal.setText("Jobs Total: $" + getJobsTotal());

	}

	private double getJobsTotal() {
		double tot = 0;

		for (Job j : jobs) {
			tot += j.getPrice();
		}

		return tot;
	}

	private double getTireTotal() {
		double tot = 0;

		// TODO get tires total

		return tot;
	}

	private JScrollPane getScrollPane() {

		JScrollPane temp;

		if (i != null) {
			vLM = new VehicleListModel(i.getClient().getVehicle());
		} else {
			vLM = new VehicleListModel(client.getVehicle());
		}

		vehiclesList = new JList(vLM);
		vehiclesList.setFont(new Font("Serif", Font.PLAIN, 15));
		vehiclesList.setCellRenderer(new DefaultListCellRenderer());
		vehiclesList.setVisibleRowCount(3);

		vehiclesList.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent lse) {
				if (!lse.getValueIsAdjusting()) {
					selectedVehicle.setText("Selected Vehicle: "
							+ vehiclesList.getSelectedValue().toString());
					currentVehicle = (Vehicle) vehiclesList.getSelectedValue();
					System.out.println("Currently is :"
							+ currentVehicle.toString());
				}
			}
		});

		temp = new JScrollPane(vehiclesList,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		return temp;
	}

	private JScrollPane getJobsPane() {

		JScrollPane temp;

		jLM = new JobsListModel(jobs);

		jobsList = new JList(jLM);
		jobsList.setFont(new Font("Serif", Font.PLAIN, 13));
		jobsList.setCellRenderer(new DefaultListCellRenderer());
		jobsList.setVisibleRowCount(5);

		temp = new JScrollPane(jobsList, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
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
			List<Vehicle> tV = client.getVehicle();
			tV.add(temp);
			client.setVehicle(tV);
		}

		// TODO Add vehicles to client
	}

	private void removeVehicle() {

		// TODO Remove vehicles from client
		currentVehicle = null;
		vLM.remove(vehiclesList.getSelectedIndex());
		selectedVehicle.setText("Select a Vehicle");

	}

	private void addJob() {

		NewJobScreen jobInfo = new NewJobScreen();

		int result = JOptionPane.showConfirmDialog(null, jobInfo,
				NewJobScreen.TITLE, JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.PLAIN_MESSAGE);

		if (result == JOptionPane.OK_OPTION) {
			Job temp = new Job(jobInfo.title.getText(),
					Double.parseDouble(jobInfo.price.getText()));
			jLM.add(temp);
			jobs.add(temp);
			updateTotals();
		}
	}

	private void removeJob() {
		jLM.remove(jobsList.getSelectedIndex());
		jobs.remove(jobsList.getSelectedIndex());
		updateTotals();
	}

	/**
	 * Class used to display the vehicle in a joption pane and show it correctly
	 * 
	 * @author Andres
	 * 
	 */
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

	/**
	 * Used to prompt for the job information
	 * 
	 * @author Andres
	 * 
	 */
	class NewJobScreen extends JPanel {

		public static final String TITLE = "Add New Job";
		public JTextField title, price;
		private JLabel tit, pri;

		public NewJobScreen() {

			setLayout(new GridLayout(2, 2, 15, 15));

			title = new JTextField();
			price = new JTextField();

			tit = new JLabel("Job Name:");
			pri = new JLabel("Price $");

			add(tit);
			add(title);
			add(pri);
			add(price);

			setVisible(true);
		}
	}

	class NewTireScreen extends JPanel {

		public static final String TITLE = "Add New Tire";
		public JTextField title, price;
		private JLabel tit, pri;

		public NewTireScreen() {

			setLayout(new GridLayout(2, 2, 15, 15));

			title = new JTextField();
			price = new JTextField();

			tit = new JLabel("Job Name:");
			pri = new JLabel("Price $");

			add(tit);
			add(title);
			add(pri);
			add(price);

			setVisible(true);
		}
	}

	/**
	 * Used to get the instance of the invoice in this screen
	 * 
	 * @return the data in an invoice item
	 */
	public Invoice getInvoice() {
		if (i != null) {

			System.out.println("i is not null");

			String invoiceDate = month.getText() + "/" + day.getText() + "/"
					+ year.getText();

			i.setBillTo(name.getText());
			i.setJobs(jobs);
			i.setClient(client);
			i.setVehicle(currentVehicle);

			return i;
		} else {

			System.out.println("i is null");

			return new Invoice(client, client.getClientId(), new Date(),
					currentVehicle, jobs, name.getText());
		}
	}
}
