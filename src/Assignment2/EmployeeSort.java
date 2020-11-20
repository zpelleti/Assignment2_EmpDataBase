package Assignment2;

import java.util.Scanner;

public class EmployeeSort {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("Please choose one of these options");
			System.out.println("1: DataBase");
			System.out.println("2: Employee Form");
			System.out.println("3: Exit");

			int choice = sc.nextInt();

			switch (choice) {

			case 1:
				EmployeeDataBase.runDataBase();
				break;

			case 2:
				createLists();
				break;

			case 3:
				System.exit(0);
				System.out.println("Exiting");
				break;

			default:
				System.out.println("Wrong entry");
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

	public static void createLists() {
		/**
		 * Allow to input info for five employees.
		 */
		final int EMP_OBJ = 1;
		Departments dept = null;

		Employee[] empList = new Employee[EMP_OBJ];

		Scanner sc = new Scanner(System.in);
		System.out.println("Please fill out this form: ");

		for (int x = 0; x < EMP_OBJ; x++) {
			System.out.println("Please enter ID (between 100 - 999)");
			int ID = sc.nextInt();
			sc.nextLine();

			System.out.println("Please enter social security number (XXX-XX-XXXX) :");
			String SIN = sc.nextLine();
			if (validateSIN(SIN)) {
				System.out.println("SIN validated");
			} else {
				System.out.println("Invalid");
				System.out.println("Please enter valid social security number (XXX-XX-XXXX) :");
				SIN = sc.nextLine();
			}
			System.out.println();

			System.out.println("Please enter first name :");
			String fName = sc.nextLine();
			System.out.println("Please enter last name :");
			String lName = sc.nextLine();
			System.out.println("Please enter address: ");
			String address = sc.nextLine();

			System.out.println("Please enter department (select one option) :");
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
			double anSal = sc.nextDouble();

			Employee emp = new Employee(ID, SIN, fName, lName, address, dept, anSal);

			// Employee[] empList = new Employee(emp);

			// empList.add(emp)
		}

		/**
		 * User is given the option of displaying the result by searching for ID or for
		 * Salary
		 */

		while (true) {
			System.out.println("Display list by :");
			System.out.println("ID (enter 1)");
			System.out.println("Salary (enter 2)");
			System.out.println("Return to menu (enter 3)");

			int choice = sc.nextInt();

			switch (choice) {
			case 1:

				for (int x = 0; x < empList.length - 1; ++x)
					for (int y = 0; y < empList.length - 1; ++y) {
						if (empList[y].getID() > empList[y + 1].getID()) {
							Employee temp = empList[y];
							empList[y] = empList[y + 1];
							empList[y + 1] = temp;
						}

						System.out.println(empList);
					}
				break;

			case 2:

				for (int x = 0; x < empList.length; x++)
					for (int y = 0; y < empList.length - 1; ++y) {
						if (empList[y].getAnSal() > empList[y + 1].getAnSal()) {
							Employee temp = empList[y];
							empList[y] = empList[y + 1];
							empList[y + 1] = temp;
						}

						System.out.println(empList);
					}

				break;

			default:
				System.out.println();
				return;
			}

		}
	}

	public static void display(Employee[] empList) {

		System.out.println("Employee ID #:\n " + "Employee SIN #:\n " + "First name: \n" + "Last name: \n"
				+ "Address: \n" + "Department: \n" + "Salary: \n");

		for (Employee e : empList) {
			System.out.println(e.getID() + e.getSIN() + e.getPerson().getfName() + e.getPerson().getlName()
					+ e.getPerson().getAddress() + e.getDept() + e.getAnSal());
		}

	}
}
