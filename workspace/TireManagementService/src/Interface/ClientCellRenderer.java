package Interface;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

import utilities.Client;

public class ClientCellRenderer extends JLabel implements ListCellRenderer {

	public ClientCellRenderer() {
		setOpaque(true);
	}

	@Override
	public Component getListCellRendererComponent(JList list, Object client,
			int index, boolean isSelected, boolean hasFocus) {

		setBackground(Color.WHITE);
		if (isSelected) {
			setBackground(Color.YELLOW);
		}

		Client temp = (Client) client;
		
		setText(temp.toString());
		setFont(new Font("Serif", Font.BOLD, 20));

		System.out.println("here");
		// add(viewButton);

		super.setEnabled(list.isEnabled());
		super.setFont(list.getFont());

		return this;
	}
}
