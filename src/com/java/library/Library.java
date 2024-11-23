package com.java.library;

public class Library {
	private int bookId;
	private String bookName;
	private  String bookAuthor;
    private int bookCopies;
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public int getBookCopies() {
		return bookCopies;
	}
	public void setBookCopies(int bookCopies) {
		this.bookCopies = bookCopies;
	}
   @Override
public String toString() {
	return "BOOK ID : "+bookId+"BOOK NAME : "+bookName+"BOOK AUTHOR : "+bookAuthor+"BOOK COPIES : "+bookCopies;
}
	

}
