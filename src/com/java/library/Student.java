package com.java.library;

public class Student {
	private int sid;
	private String Sname;
	private int mobile;
	private String gender;

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return Sname;
	}

	public void setSname(String sname) {
		Sname = sname;
	}

	public int getMobile() {
		return mobile;
	}

	public void setMobile(int mobile) {
		this.mobile = mobile;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {

		return "STUDENT ID" + getSid() + "STUDENT NAME" + getSname() + "STUDENT MOBILE" + getMobile() + "GENDER"
				+ getGender();
	}

}
