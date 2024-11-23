package com.java.collections;

import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class JobDetails {
	static Map<Integer, Job> hashMap = new HashMap<Integer, Job>();
	public static void main(String[] args) {
		
		Scanner sn= new Scanner(System.in);
		
		boolean flag= true;
		System.out.println("|*********welcome MERIDEN  jobs***********|");
		while(flag)
		{
			int num;
			System.out.println("1.ADD\n2.UPDATE\n3.RETRIEVE\n4.DELETE\n5.EXIT");
			num=sn.nextInt();
			switch(num)
			{
			case 1:
				add(sn);
				break;
			case 2: 
				update(sn);
				break;
			case 3:
				show(sn);
				break;
			case 4:
				delete(sn);
				break;
			case 5:
				System.out.println("THANK YOU  SEE YOU AGAIN");
				flag=false;
				break;
			default:
				System.out.println("please select above options ");
				
			
			}
			
		}
		
		
		

	}

	public  static void delete(Scanner sn) {
		System.out.println("enter id");
		hashMap.remove(sn.nextInt());
		
	}

	public  static void show(Scanner sn) {
		System.out.println(hashMap);
		// TODO Auto-generated method stub
		
	}

	public  static void update(Scanner sn) {
		Job j=getDetails(sn, "update");
		hashMap.put(j.getId(),j);
		
		
	}

	public static void add(Scanner sn) {
		Job j1= getDetails(sn,"insert");
		hashMap.put(j1.getId(), j1);
		
	}

	public static Job getDetails(Scanner sn,String op) {
	
		Job j= new Job();
		if(op.equalsIgnoreCase("insert")||op.equalsIgnoreCase("update"))
		{
		System.out.println("ENTER ID :");
		j.setId(sn.nextInt());
	    }
		System.out.println("ENTER NAME  :");
		j.setName(sn.next());
		System.out.println("ENTER STORE  :");
		j.setStore(sn.next());
		System.out.println("ENTER HOURS  :");
		j.setHours(sn.nextInt());
		System.out.println("ENTER  your pay $:");
		j.setPay(sn.nextInt());
		return j;
		
	}

}
