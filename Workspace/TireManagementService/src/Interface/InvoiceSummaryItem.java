package Interface;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import utilities.Invoice;


/**
 * Deprecated, no longer being used, replaced by InvoiceCellRenderer;
 * @author Andres
 *
 */
public class InvoiceSummaryItem extends JPanel {

	private JButton viewButton;
	private JLabel clientNameLabel;
	private JLabel dateLabel;

	public InvoiceSummaryItem(Invoice inv) {

		setLayout(new GridLayout(2, 2, 15, 15));

		viewButton = new JButton("View");
		clientNameLabel = new JLabel(inv.getClient().getLastName() + ", "
				+ inv.getClient().getFirstName());
		
		dateLabel = new JLabel(inv.getDate().toString());

		
		
	}
}
