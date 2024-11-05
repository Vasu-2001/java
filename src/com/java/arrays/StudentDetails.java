package com.java.arrays;

public class StudentDetails {
	private int studentId;
	private String studentName;
	private int StudentPh;
	public StudentDetails(int id, String str, int num)
	{
		this.studentId=id;
		this.studentName=str;
		this.StudentPh=num;
	}
	public String toString()
	{
		return studentId+"\t\t"+studentName+"\t\t"+StudentPh+"\n";
	}
	
}
