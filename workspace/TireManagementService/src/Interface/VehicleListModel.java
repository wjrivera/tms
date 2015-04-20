package Interface;

import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractListModel;

import utilities.Vehicle;

public class VehicleListModel extends AbstractListModel<Vehicle> {

	private List<Vehicle> vehicles;

	public VehicleListModel(List<Vehicle> vehicles) {
		this.vehicles = new ArrayList<>(vehicles);
	}

	public void add(Vehicle v) {
		if (vehicles.add(v)) {
			fireContentsChanged(this, 0, getSize());
		}
	}

	public void updateAll(List<Vehicle> list) {

	}

	public boolean remove(int index) {

		boolean removed = (vehicles.remove(index) == null) ? false : true;
		if (removed) {
			fireContentsChanged(this, 0, getSize());
		}

		return removed;
	}

	@Override
	public Vehicle getElementAt(int index) {
		return vehicles.get(index);
	}

	@Override
	public int getSize() {
		return vehicles.size();
	}

}