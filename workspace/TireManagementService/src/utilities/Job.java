package utilities;

public class Job {

	public String title;
	public double price;

	public Job(String title, double price) {
		this.title = title;
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String toString() {
		String temp = "$########  _";
		temp = temp.replaceAll("########", "" + price);
		temp = temp.replaceAll("_", title);

		return temp;
	}

}
