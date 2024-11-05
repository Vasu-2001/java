package com.java.basics;

public class StringMethods {

	public static void main(String[] args) {
	String str="baa";
	String str1="aab";
	System.out.println(str.charAt(0));//j
	System.out.println(str.codePointAt(1));
	System.out.println(str.codePointBefore(2));
	System.out.println(str.codePointCount(0, 3));
	System.out.println(str.compareTo(str1));
	System.out.println(str.compareToIgnoreCase(str1));
	System.out.println(str.concat(str1));
	System.out.println(str.contains(str1));
	System.out.println(str.contentEquals(str1));
	System.out.println(str.length());
	System.out.println(str.hashCode());
	System.out.println(str.toUpperCase());

	}

}
