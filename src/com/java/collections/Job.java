package com.java.collections;

public class Job {
	private int id;
	private String name;
	private String store;
	private int hours;
	private int pay;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStore() {
		return store;
	}
	public void setStore(String store) {
		this.store = store;
	}
	public int getHours() {
		return hours;
	}
	public void setHours(int hours) {
		this.hours = hours;
	}
	public int getPay() {
		return pay;
	}
	public void setPay(int pay) {
		this.pay = pay;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return  "["+"ID :\t"+id+"NAME :]t"+name+"]tSTORE\t"+store+"\tHOURS\t :"+hours+"\tPAY\t"+pay+"]";
	}

}
