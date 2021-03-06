package Interface;

import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractListModel;

import utilities.Job;

/**
 * Helps display the Jobs Properly and update them in real time
 * 
 * @author Jason Ricardo
 * 
 */
public class JobsListModel extends AbstractListModel<Job> {

	private List<Job> jobs;

	public JobsListModel(List<Job> jobs) {
		this.jobs = new ArrayList<>(jobs);
	}

	public void add(Job j) {
		if (jobs.add(j)) {
			fireContentsChanged(this, 0, getSize());
		}
	}
	
	public boolean remove(int index) {

		boolean removed = (jobs.remove(index) == null) ? false : true;
		if (removed) {
			fireContentsChanged(this, 0, getSize());
		}

		return removed;
	}

	@Override
	public Job getElementAt(int arg0) {
		return jobs.get(arg0);
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return jobs.size();
	}

}
