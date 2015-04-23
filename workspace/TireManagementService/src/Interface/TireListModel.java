package Interface;

import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractListModel;

import utilities.Tire;

/**
 * Unused, but working...due to clients request
 * @author Andres
 *
 */
public class TireListModel extends AbstractListModel<Tire> {

	private List<Tire> tires;

	public TireListModel(List<Tire> tires) {
		this.tires = new ArrayList<>(tires);
	}

	public void add(Tire t) {
		if (tires.add(t)) {
			fireContentsChanged(this, 0, getSize());
		}
	}

	public boolean remove(int index) {

		boolean removed = (tires.remove(index) == null) ? false : true;
		if (removed) {
			fireContentsChanged(this, 0, getSize());
		}

		return removed;
	}

	@Override
	public Tire getElementAt(int arg0) {
		return tires.get(arg0);
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return tires.size();
	}

}
