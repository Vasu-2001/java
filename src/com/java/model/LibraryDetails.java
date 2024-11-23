package com.java.model;

import java.sql.SQLException;
import java.util.Scanner;

import com.java.Exception.LibraryDaoException;
import com.java.dao.LibraryDao;
import com.java.library.Library;

public class LibraryDetails {
	LibraryDao dao=new LibraryDao();

	public static void main(String[] args) throws LibraryDaoException, SQLException{
      Scanner sn= new Scanner(System.in);
      LibraryDetails details=new LibraryDetails();
      
      boolean flag=true;
      while(flag)
      {
    	  System.out.println("***********MENU FOR LIBRARY***********");
    	  System.out.println("1.ADD BOOK\n2.UPDATE BOOK\n3.DELETE BOOK\n4.retrieve book\n5.SHOW ALL\n6.EXIT");
    	  int t=sn.nextInt();
    	  switch(t)
    	  {
    	  case 1:
    		  details.addBook(sn);
    		  break;
    	  case 2:
    		  details.updateBook(sn);
    		  break;
    	  case 3 :
    		  deleteBook();
    		  break;
    	  case 4:
    		  retrieveBook();
    		  break;
    	  case 5:
    		  showAll();
    		  break;
    	  case 6:
    		  flag=false;
    	  
    	  }
      }
     
    	
    	  
    	  
      }
	private static void showAll() {
		// TODO Auto-generated method stub
		
	}
	private static void retrieveBook() {
		// TODO Auto-generated method stub
		
	}
	private static void deleteBook() {
		// TODO Auto-generated method stub
		
	}
	public  void updateBook(Scanner sn) throws LibraryDaoException, SQLException {
		Library library=getLibraryDetails(sn, "update") ;
		int r=dao.updateBook(library);
		System.out.println("successfully updated"+r);
		// TODO Auto-generated method stub
		
	}
	public   void addBook(Scanner sn) throws LibraryDaoException {
		Library lb= getLibraryDetails(sn,"insert");
		int r=dao.insertBook(lb);
		System.out.println("sucessfully inserted"+r);
		
		
		
	}
	public  Library getLibraryDetails(Scanner sn,String msg)
     {
   	 Library lb= new Library();
   	 if(msg.equalsIgnoreCase("insert")||msg.equalsIgnoreCase("update"))
   	 {
   	  System.out.println("ENTER BOOK ID");
   	  lb.setBookId(sn.nextInt());
   	 }
      System.out.println("ENTER BOOK  NAME");
 	  lb.setBookName(sn.next());
 	  System.out.println("ENTER BOOK AUTHOR ");
 	  lb.setBookAuthor(sn.next());
 	  System.out.println("ENTER BOOK COPIES");
 	  lb.setBookCopies(sn.nextInt());
	 return lb;
		

	}

}
