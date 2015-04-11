package Interface;

import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NewCustomerScreen extends JPanel {

	public static final String TITLE = "Add New Customer";
	public JTextField firstName, lastName, email, phoneNumber, address, city,
			state, zip;
	private JLabel f, l, e, p, a, c, s, z;

	public NewCustomerScreen() {

		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

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

		JPanel infoPanel = new JPanel();
		infoPanel.setLayout(new GridLayout(8, 2, 15, 15));

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

		add(infoPanel);

		setVisible(true);
	}

}
