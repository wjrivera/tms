package Interface;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

import utilities.Invoice;

public class InvoiceCellRenderer extends JPanel implements
		ListCellRenderer<Invoice> {

	// Components of the single item
	JLabel name = new JLabel(" ");
	JLabel date = new JLabel(" ");
	JLabel invoiceNum = new JLabel(" ");
	JLabel vehicle = new JLabel(" ");

	public InvoiceCellRenderer() {

		invoiceNum.setFont(new Font("Serif", Font.BOLD, 15));
		name.setFont(new Font("Serif", Font.BOLD, 15));
		setLayout(new GridLayout(2, 2, 15, 15));
		add(invoiceNum);
		add(name);
		add(date);
		add(vehicle);
	}

	@Override
	public Component getListCellRendererComponent(
			JList<? extends Invoice> list, Invoice value, int index,
			boolean isSelected, boolean cellHasFocus) {

		if (index % 2 == 0) {
			setBackground(Color.WHITE);
		} else {
			setBackground(new Color(238, 233, 233));
		}
		if (isSelected) {
			setBackground(Color.YELLOW);
		}

		name.setText(value.getClient().toString());
		invoiceNum.setText(value.getInvoiceNumber().toString());
		date.setText(value.getDate().toString());
		vehicle.setText(value.getVehicle().toString());

		return this;
	}

}
