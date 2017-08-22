package Interface;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import utilities.Client;

/**
 * Used to display a custom JList item correctly
 * 
 * @author Andres
 *
 */
public class ClientCellRenderer extends JLabel implements ListCellRenderer {

	public ClientCellRenderer() {
		setOpaque(true);
	}

	// Gui Componentfor Clients
	@Override
	public Component getListCellRendererComponent(JList list, Object client,
			int index, boolean isSelected, boolean hasFocus) {

		//make it easier to see separations
		if (index % 2 == 0) {
			setBackground(Color.WHITE);
		} else {
			setBackground(new Color(238, 233, 233));
		}
		//Sets a color when a customer has been selected for it to be easier to be seen.
		if (isSelected) {
			setBackground(Color.YELLOW);
		}
		
		Client temp = (Client) client;

		setText(temp.toString());
		//Sets the Serif to be the font
		setFont(new Font("Serif", Font.BOLD, 20));
		//Enables the list
		super.setEnabled(list.isEnabled());
		super.setFont(list.getFont());

		return this;
	}
}
