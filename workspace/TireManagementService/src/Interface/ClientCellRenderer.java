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

	@Override
	public Component getListCellRendererComponent(JList list, Object client,
			int index, boolean isSelected, boolean hasFocus) {

		//make it easier to see separations
		if (index % 2 == 0) {
			setBackground(Color.WHITE);
		} else {
			setBackground(new Color(238, 233, 233));
		}

		if (isSelected) {
			setBackground(Color.YELLOW);
		}

		Client temp = (Client) client;

		setText(temp.toString());
		setFont(new Font("Serif", Font.BOLD, 20));

		super.setEnabled(list.isEnabled());
		super.setFont(list.getFont());

		return this;
	}
}
