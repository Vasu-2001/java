package com.java.collections;
import java.util.List;
import java.util.Scanner;
public class EmployeeDetails {

	EmployeeDao dao = new EmployeeDao();

	public static void main(String[] args) throws EmplyeeDaoException {
		Scanner sc = new Scanner(System.in);
		EmployeeDetails ed = new EmployeeDetails();

		int operation = 0;
		do {
			System.out.println(
					"Avilable Operations \n 1. Insert \n 2. Update \n 3. Delete \n 4. Retrive \n 5. Exit. Please Select Your Operation ");
			operation = sc.nextInt();
			switch (operation) {
			case 1:
				ed.insertEmployee(sc);
				break;
			case 2:
				ed.updateEmployee(sc);
				break;
			case 3:
				ed.deleteEmplyee(sc);
				break;
			case 4:
				List<Employee> empList = ed.retrieveEmplyeeDetails();
				for (Employee employee : empList) {
					System.out.println(employee);
				}
				break;
			}

		} while (operation != 5);

	}

	public List<Employee> retrieveEmplyeeDetails() throws EmplyeeDaoException {
		return dao.getEmployees();
	}

	public void insertEmployee(Scanner sc) throws EmplyeeDaoException {
		Employee emp = getEmployeeeDetails(sc, "Insert");
		dao.insertEmployee(emp);
	}

	public void updateEmployee(Scanner sc) throws EmplyeeDaoException {
		Employee emp = getEmployeeeDetails(sc, "Update");
		dao.updateEmployee(emp);
	}

	public void deleteEmplyee(Scanner sc) throws EmplyeeDaoException {
		System.out.println("Enter Emplyee Id to delete");
		dao.deleteEmployee(sc.nextInt());
	}

	public Employee getEmployeeeDetails(Scanner sc, String operation) {
		Employee emp = new Employee();

		if (operation.equalsIgnoreCase("Insert") || operation.equalsIgnoreCase("Update")) {
			System.out.println("Enter Emplyee Id");
			emp.setEmpId(sc.nextInt());
		}

		System.out.println("Enter Emplyee Name");
		emp.setEmpName(sc.next());

		System.out.println("Enter Emplyee Salary");
		emp.setSalary(sc.nextInt());

		System.out.println("Enter Emplyee Address");
		emp.setAddress(sc.next());

		System.out.println("Enter Emplyee Mobile No");
		emp.setMobileNo(sc.nextLong());

		System.out.println("Enter Emplyee age");
		emp.setAge(sc.nextInt());

		System.out.println("Enter Emplyee Geneder");
		emp.setGender(sc.next());

		return emp;
	}

}
