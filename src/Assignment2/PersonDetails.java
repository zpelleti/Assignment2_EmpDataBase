package Assignment2;

public class PersonDetails {
	/**
	 * First class: person's first and last names, and address. Constructors, get
	 * and set methods for each parameters.
	 */
	private String fName;
	private String lName;
	private String address;

	public PersonDetails(String fName, String lName, String address) {
		this.fName = fName;
		this.lName = lName;
		this.address = address;

	}

	public PersonDetails() {

	}

	public String getfName() {
		return fName;
	}

	public String getlName() {
		return lName;
	}

	public String getAddress() {
		return address;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
