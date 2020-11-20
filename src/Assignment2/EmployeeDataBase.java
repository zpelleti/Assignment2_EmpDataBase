package Assignment2;

import java.util.Scanner;

public class EmployeeDataBase {

	final static int MAX = 25;
	static Employee empList[] = new Employee[MAX];

	static int dataBase = 0;

	public static void runDataBase() {
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("-------DATABASE-------");
			System.out.println("Please choose an option: ");
			System.out.println("1: Add an Employee");
			System.out.println("2: Delete an Employee");
			System.out.println("3: Change Salary");
			System.out.println("4: Return to Menu");

			int choice = sc.nextInt();
			switch (choice) {

			case 1:
				if (dataBaseFull()) {
					System.out.println("Sorry, the DataBase is full");
				} else {
					System.out.println("Enter the new Employee's ID: ");
					int newID = sc.nextInt();
					if (searchID(newID)) {
						System.out.println("ID already exists. Try again");
					}

					else {
						addEmp(newID);
					}
				}
				System.out.println();
				break;

			case 2:
				if (dataBaseEmpty()) {
					System.out.println("This DataBase is empty");
				} else {
					System.out.println("Enter the ID you want to delete: ");
					int outID = sc.nextInt();
					if (!searchID(outID)) {
						System.out.println("This ID does not exist");
					} else {
						removeEmp(outID);
					}
					System.out.println();
				}
				break;

			case 3:
				System.out.println("To change salary, enter the Employee ID: ");
				int chSalID = sc.nextInt();
				if (!searchID(chSalID)) {
					System.out.println("This ID does not exist");
				} else {
					System.out.println("Enter the new salary: ");
					double newSal = sc.nextDouble();
					dataBaseChange(chSalID, (int) newSal);
				}
				System.out.println();
				break;

			case 4:
				System.out.println("Return to Menu");
				EmployeeSort.main(null);
				break;

			default:
				System.out.println("Invalid entry");
				break;
			}

		}
	}

	public static boolean validateSIN(String SIN) {
		int count = 0;
		int x = 0;

		for (x = 0; x < SIN.length(); ++x) {
			if (SIN.length() == 10)
				count++;
			if (SIN.charAt(3) == '-' && SIN.charAt(6) == '-')
				return true;
		}
		return false;
	}

	public static boolean dataBaseFull() {
		return dataBase == MAX;

	}

	public static void dataBaseChange(int chSalID, int newSal) {

		for (int x = 0; x < dataBase; x++) {
			if (empList[x].getID() == chSalID) {
				empList[x].setAnSal(newSal);
			}
		}

	}

	public static boolean searchID(int ID) {
		for (int x = 0; x < dataBase; x++) {
			if (empList[x].getID() == ID) {
				return true;
			}
		}
		return false;
	}

	public static boolean dataBaseEmpty() {
		if (dataBase == 0) {
			return true;
		} else
			return false;
	}

	public static void addEmp(int ID) {

		String fName;
		String lName;
		String address;
		Departments dept = null;
		double anSal;

		System.out.println("Please enter SIN: ");
		Scanner sc = new Scanner(System.in);
		String SIN = sc.nextLine();
		if (validateSIN(SIN)) {
			System.out.println("SIN validated");
		} else {
			System.out.println("Invalid");
			System.out.println("Please enter valid social security number (XXX-XX-XXXX) :");
			SIN = sc.nextLine();
		}
		System.out.println();

		System.out.println("Please enter first name: ");
		fName = sc.nextLine();
		System.out.println("Please enter last name: ");
		lName = sc.nextLine();
		System.out.println("Please enter address: ");
		address = sc.nextLine();

		System.out.println("Please choose department: ");
		System.out.println("1: FINANCE");
		System.out.println("2: HR");
		System.out.println("3: IT");
		System.out.println("4: MARKETING");

		int tempDept = 1;
		while (tempDept != 0) {
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				Departments dept1 = Departments.FINANCE;
				tempDept = 0;
				break;
			case 2:
				Departments dept2 = Departments.HR;
				tempDept = 0;
				break;
			case 3:
				Departments dept3 = Departments.IT;
				tempDept = 0;
				break;
			case 4:
				Departments dept4 = Departments.MARKETING;
				tempDept = 0;
				break;
			default:
				System.out.println("Please enter a valid department");

			}
		}
		System.out.println("Please enter annual salary :");
		anSal = sc.nextDouble();

		Employee[] emp = new Employee[dataBase];

		// empList[dataBase++] = emp;

		// ID, SIN, fName, lName, address, anSal
	}

	public static void removeEmp(int ID) {

		int index = 0;

		for (Employee e : empList) {
			if (e.getID() == ID) {
				break;
			}
			++index;
		}
		for (int x = index; x < dataBase; x++) {
			empList[x] = empList[x + 1];
		}
		--dataBase;
	}

	public static void display() {

		if (dataBase == 1) {

			System.out.println("Employee ID #:\n " + "Employee SIN #:\n " + "First name: \n" + "Last name: \n"
					+ "Address: \n" + "Department: \n" + "Salary: \n");

			System.out.println(empList[0].getID() + empList[0].getSIN() + empList[0].getPerson().getfName()
					+ empList[0].getPerson().getlName() + empList[0].getPerson().getAddress() + empList[0].getAnSal());

		} else {
			for (int x = 0; x < dataBase; x++) {
				for (int y = 0; y < dataBase; y++) {
					if (empList[y].getID() > empList[y + 1].getID()) {
						Employee temp = empList[y];
						empList[y] = empList[y + 1];
						empList[y + 1] = temp;
					}
				}
			}
			System.out.println("Employee ID #:\n " + "Employee SIN #:\n " + "First name: \n" + "Last name: \n"
					+ "Address: \n" + "Department: \n" + "Salary: \n");

			System.out.println(empList[0].getID() + empList[0].getSIN() + empList[0].getPerson().getfName()
					+ empList[0].getPerson().getlName() + empList[0].getPerson().getAddress() + empList[0].getAnSal());

		}
	}
}
