package com.java.Exception;

public class LibraryDaoException extends Exception {
	public LibraryDaoException() {
		super();
		
	}
	public LibraryDaoException(String msg) {
		super(msg);
		
	}
	public LibraryDaoException(String msg, Throwable cause)
	{
		super(msg,cause);
		
	}

}
