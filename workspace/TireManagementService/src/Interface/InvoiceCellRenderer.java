package Interface;

import java.awt.Color;
import java.awt.Component;
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

	public InvoiceCellRenderer() {
		setLayout(new GridLayout(2, 2, 15, 15));
		add(invoiceNum);
		add(name);
		add(date);
		add(new JLabel(" "));
	}

	@Override
	public Component getListCellRendererComponent(
			JList<? extends Invoice> list, Invoice value, int index,
			boolean isSelected, boolean cellHasFocus) {

		setBackground(Color.WHITE);
		if (isSelected) {
			setBackground(Color.YELLOW);
		}

		name.setText(value.getClient().toString());
		invoiceNum.setText(value.getInvoiceNumber().toString());
		date.setText(value.getDate().toString());

		return this;
	}

}
