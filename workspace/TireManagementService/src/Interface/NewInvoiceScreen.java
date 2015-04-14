package Interface;

import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import utilities.Client;

public class NewInvoiceScreen extends JPanel {

	public static final String TITLE = "Add Invoice";

	public JTextField name, email, phoneNumber, address, city, state, zip;
	public JLabel n, e, p, a, c, s, z;

	public NewInvoiceScreen(Client client) {
	
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		n = new JLabel("Bill To");
		e = new JLabel("E-Mail");
		p = new JLabel("Phone Number");
		a = new JLabel("Address");
		c = new JLabel("City");
		s = new JLabel("State");
		z = new JLabel("zip");
		
		name = new JTextField(client.toString());
		email = new JTextField(client.getEmail());
		phoneNumber = new JTextField(client.getPhoneNumber());
		address = new JTextField(client.getAddress());
		city = new JTextField(client.getCity());
		state = new JTextField(client.getState());
		zip = new JTextField(client.getZip());
		
		JPanel infoPanel = new JPanel();
		infoPanel.setLayout(new GridLayout(8,2,15,15));
		
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

		add(infoPanel);
		
				
	}
}
