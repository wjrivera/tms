package utilities;

public class Job {
	//Local variable for a small Job class
	public String title;
	public double price;
	// The following are just setters and Getters
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

	//The following is a return string for the Job class 
	//so its properly displayed for the client in the order right.
	public String toString() {
		String temp = "$########  _";
		temp = temp.replaceAll("########", "" + price);
		temp = temp.replaceAll("_", title);

		return temp;
	}

}
