package com.java.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StudentDetails {
	static Map<Integer, Student> sMap = new HashMap<Integer, Student>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int operation = 0;
		do {
			System.out.println("*****************MENU*******************");
			System.out.println(
					" 1. ADD STUDENT \n 2. Update STUDENT  \n 3. Delete STUDENT  \n 4. Retrive STUDENT\n 5. Exit. Please Select Your Operation ");
			operation = sc.nextInt();
			switch (operation) {
			case 1:
				insertStudent(sc);
				break;
			case 2:
				updateStudent(sc);
				break;
			case 3:
				deleteStudent(sc);
				break;
			case 4:
				retrieveStudentDetails();
				break;
			}

		} while (operation != 5);

	}

	public static void retrieveStudentDetails() {
		System.out.println(sMap);
	}

	public static void insertStudent(Scanner sc) {
		Student  s = getStudentDetails(sc, "Insert");
		sMap.put(s.getSid(), s);
	}

	public static void updateStudent(Scanner sc) {
		Student  s= getStudentDetails(sc, "Update");
		sMap.put(s.getSid(), s);
	}

	public static void deleteStudent(Scanner sc) {
		System.out.println("Enter  Id");
		sMap.remove(sc.nextInt());
	}

	public static Student getStudentDetails(Scanner sc, String operation) {
		Student s1 = new Student();

		if (operation.equalsIgnoreCase("Insert") || operation.equalsIgnoreCase("Update")) {
			System.out.println("Enter  Id");
			s1.setSid(sc.nextInt());
		}
		System.out.println("Enter  Name");
		s1.setSname(sc.next());
		System.out.println("Enter  Mobile No");
		s1.setNumber(sc.nextLong());


		return s1;
	}

}