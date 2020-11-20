package Assignment2;

/**
 * Employee class: fields for ID, SIN, Person object, Salary per anum,
 * Department type, Constructor and get set methods for each fields.
 * 
 * @author zpell
 *
 */
public class Employee {

	private int ID;
	private String SIN;
	private Departments dept;
	private double anSal;
	private PersonDetails person;

	public Employee(int ID, String SIN, String fName, String lName, String address, Departments dept, double anSal) {
		this.ID = ID;
		this.SIN = SIN;
		this.person = new PersonDetails(fName, lName, address);
		this.anSal = anSal;
		this.dept = dept;
	}

	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public String getSIN() {
		return SIN;
	}

	public void setSIN(String SIN) {
		this.SIN = SIN;
	}

	public PersonDetails getPerson() {
		return this.person;
	}

	public void setPerson(PersonDetails person) {
		this.person = person;
	}

	public Departments getDept() {
		return dept;
	}

	public void setDept(Departments dept) {
		this.dept = dept;
	}

	public double getAnSal() {
		return anSal;
	}

	public void setAnSal(double anSal) {
		this.anSal = anSal;
	}

}
