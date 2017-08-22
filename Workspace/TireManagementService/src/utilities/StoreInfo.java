package utilities;

public class StoreInfo {
	// Local variables set to blank from the begining
	private static String storeName = "";
	private static String address = "";
	private static String city = "";
	private static String state = "";
	private static String zip = "";
	private static String phoneNumber = "";
	private static String faxNumber = "";
	private static String email = "";
	private static String county = "";

	// The following are setters and getters
	public static String getEmail() {
		return email;
	}

	public static void setEmail(String email) {
		StoreInfo.email = email;
	}

	public static String getCounty() {
		return county;
	}

	public static void setCounty(String county) {
		StoreInfo.county = county;
	}

	public static String getTaxId() {
		return taxId;
	}

	public static void setTaxId(String taxId) {
		StoreInfo.taxId = taxId;
	}

	private static String taxId;

	public static String getZip() {
		return zip;
	}

	public static void setZip(String zip) {
		StoreInfo.zip = zip;
	}

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
	
	//print info is a method to display the information passed from the client. 
	public static void printInfo(){
		System.out.println("Name :" + storeName);
		System.out.println("Address :" + address);
		System.out.println("City :" + city);
		System.out.println("State :" + state);
		System.out.println("Zip :" + zip);
		System.out.println("Phone :" + phoneNumber);
		System.out.println("Fax :" + faxNumber);
		System.out.println("County :" + county);
		System.out.println("Email :" + email);
		System.out.println("Id :" + taxId);
	}
	
}
