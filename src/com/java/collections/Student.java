package com.java.collections;

public class Student {
	private int sid;
	private String sname;
	private long number;
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public long getNumber() {
		return number;
	}
	public void setNumber(long number) {
		this.number = number;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "["+"STUDENT ID :"+sid+"STUDENT NAME :"+sname+"STUDENT NUMBER:"+number+"]";
	}
	
	
	
	
	
 }
