package com.java.arrays;

public class Test {

	public static void main(String[] args) {
		StudentDetails std= new StudentDetails(101, "vasu", 2037152817);
		StudentDetails st[]= {new StudentDetails(101, "vasu", 2037152817),new StudentDetails(102, "raju", 2037152816),new StudentDetails(103, "rani", 2037152818)};
		System.out.println("STUDENT ID\tSTUDENTNAME\tSTUDENT NUMBER");
		System.out.println("---------------------------------------------");
		/*for(int i=0;i<st.length;i++)
		{
			System.out.println(st[i].toString());
	
		}*/
		for(StudentDetails ob:st)
		{
			System.out.println(ob.toString());
		}

	}

}
