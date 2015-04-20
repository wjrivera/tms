package utilities;

/**
 * Created by jay on 2/24/15.
 * Edited by Andres on 4/11/15
 */
public class Tire {
	String tireSize;
	double height;
	double rimSize;
	double width;
	int year;
	double thread;
	double price;

	public Tire() {
		System.out.println("Please enter a tire size");
	}

	public Tire(String tireSize) {
		if (!checkNumber(tireSize)) {
			System.out.println("Incorrect number");
		} else {
			System.out.println("Correct Number");
			parseIntoSpecificSizes(tireSize);
		}

	}

	public void parseIntoSpecificSizes(String tireSize) {
		StringBuffer sb = new StringBuffer();
		for (int j = 0; j < 3; j++) {
			int k = Integer.valueOf(String.valueOf(tireSize.charAt(j)));
			sb.append(k);
			if (j == 2) {
				int r = Integer.parseInt(sb.toString());
				height = r;
				System.out.println(height);
			}
		}
		sb.delete(0, sb.length());
		for (int k = 3; k < 5; k++) {
			int s = Integer.valueOf(String.valueOf(tireSize.charAt(k)));
			sb.append(s);
			if (k == 4) {
				int r = Integer.parseInt(sb.toString());
				width = r;
				System.out.println(width);
			}

		}
		sb.delete(0, sb.length());
		for (int l = 5; l < 7; l++) {
			int s = Integer.valueOf(String.valueOf(tireSize.charAt(l)));
			sb.append(s);
			if (l == 6) {
				int r = Integer.parseInt(sb.toString());
				rimSize = r;
				System.out.println(rimSize);
			}
		}
	}

	public boolean checkNumber(String x) {
		if (x.matches("^[0-9]+$")) {
			return true;
		}

		return false;
	}

	public void setHeight(double h) {
		height = h;
	}

	public void setRimSize(double r) {
		rimSize = r;
	}

	public void setWidth(double w) {
		width = w;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void setThread(double thread) {
		this.thread = thread;
	}

	public double getHeight() {

		return height;
	}

	public double getWidth() {

		return width;
	}

	public double getRimSize() {

		return rimSize;
	}

	public int getYear() {
		return year;
	}

	public double getThread() {
		return thread;
	}

}