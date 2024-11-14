package com.java.collections;

import java.util.ArrayList;
import java.util.HashMap;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList al= new ArrayList();
		al.add("hell0");
		al.add("welcome");
		ArrayList al1=new ArrayList();
		al1.add("to");
		al1.add("java");
		al.addAll(al1);
		System.out.println(al+"\n"+al1);
		al.remove("hell0");
		System.out.println(al+"\n"+al1);
		al.removeAll(al1);
		System.out.println(al+"\n"+al1);
		System.out.println(al.contains("welcome"));
		HashMap hm= new HashMap();
		hm.put(1, 111);
		hm.put(2,222);
		hm.put(3, 333);
		hm.put(4, 444);
		System.out.println(hm);
		System.out.println(hm.get(1));
		System.out.println(hm.remove(2));
		System.out.println(hm);
		System.out.println(hm.size());
		System.out.println(hm.containsKey(3));
		System.out.println(hm.containsValue(444));
		System.out.println(hm.keySet());
		System.out.println(hm.values());
		
		
		

	}

}
