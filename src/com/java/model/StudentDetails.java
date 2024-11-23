package com.java.model;

import java.util.Scanner;

import com.java.library.Student;

import com.java.dao.StudentDao;
import com.java.Exception.StudentDaoException;

public class StudentDetails {
	StudentDao dao = new StudentDao();

	public static void main(String[] args) throws StudentDaoException {
		Scanner sn = new Scanner(System.in);
		boolean flag = true;
		StudentDetails details = new StudentDetails();
		while (flag) {
			System.out.println("***********MENU FOR STUDENT DETAILS***********");
			System.out.println("1.addstudent\n2.update student\n3.view\n4.delete student1");
			int temp = sn.nextInt();
			switch (temp) {
			case 1:
				details.addStudent(sn);
				break;
			case 2:
				details.updateStudent(sn);
			case 3:
				details.viewAllStudents();
				break;
			case 4:
				System.out.println("before deletion");
				details.viewAllStudents();
				
				details.deleteStudent(sn);
				System.out.println("after  deletion");
				details.viewAllStudents();
				break;

			}
		}

	}

	public void deleteStudent(Scanner sn) throws StudentDaoException {

		System.out.println("ENTER STUDENT ID TO DELETE FORM ABOVE TABLE");
		int id = sn.nextInt();
		int res=dao.deleteStudent(id);

		// TODO Auto-generated method stub

	}

	public void viewAllStudents() throws StudentDaoException {
		System.out.println("STUDENT ID\tSTUDENT NAME\tSTUDENT MOBILE\tSTUDENT GENDER");
		dao.showAll();

		// TODO Auto-generated method stub

	}

	public void updateStudent(Scanner sn) throws StudentDaoException {
		Student std = getStudentDetails(sn, "update");
		int res = dao.updateStudent(std);
		System.out.println(res + "updated succesfully");

	}

	public void addStudent(Scanner sn) throws StudentDaoException {
		Student std = getStudentDetails(sn, "insert");
		int res = dao.insertStudent(std);
		System.out.println(res + " record succuessfully inersted");

	}

	public Student getStudentDetails(Scanner sn, String msg) {
		Student std = new Student();
		if (msg.equalsIgnoreCase("insert") || msg.equalsIgnoreCase("update")) {
			System.out.println("ENTER STUDENT ID");
			std.setSid(sn.nextInt());
		}
		System.out.println("enter student name");
		std.setSname(sn.next());
		System.out.println("enter student mobile");
		std.setMobile(sn.nextInt());
		System.out.println("enter student gender");
		std.setGender(sn.next());
		return std;

	}

}
