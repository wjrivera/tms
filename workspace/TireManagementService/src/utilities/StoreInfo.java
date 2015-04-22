package utilities;

public class StoreInfo {
	private static String storeName;
	private static String address;
	private static String city;
	private static String state;
	private static String country;
	private static String phoneNumber;
	private static String faxNumber;
	private static boolean[] daysOfOperation= new boolean[6];
	private static String hoursOfOperation;
	
	public static String getStoreName() {
		return storeName;
	}
	public static void setStoreName(String storeName) {
		StoreInfo.storeName = storeName;
	}
	public static String getAddress() {
		return address;
	}
	public static void setAddress(String address) {
		StoreInfo.address = address;
	}
	public static String getCity() {
		return city;
	}
	public static void setCity(String city) {
		StoreInfo.city = city;
	}
	public static String getState() {
		return state;
	}
	public static void setState(String state) {
		StoreInfo.state = state;
	}
	public static String getCountry() {
		return country;
	}
	public static void setCountry(String country) {
		StoreInfo.country = country;
	}
	public static String getPhoneNumber() {
		return phoneNumber;
	}
	public static void setPhoneNumber(String phoneNumber) {
		StoreInfo.phoneNumber = phoneNumber;
	}
	public static String getFaxNumber() {
		return faxNumber;
	}
	public static void setFaxNumber(String faxNumber) {
		StoreInfo.faxNumber = faxNumber;
	}
	public static boolean[] getDaysOfOperation() {
		return daysOfOperation;
	}
	public static void setDaysOfOperation(boolean[] daysOfOperation) {
		StoreInfo.daysOfOperation = daysOfOperation;
	}
	public static String getHoursOfOperation() {
		return hoursOfOperation;
	}
	public static void setHoursOfOperation(String hoursOfOperation) {
		StoreInfo.hoursOfOperation = hoursOfOperation;
	}
	

}
