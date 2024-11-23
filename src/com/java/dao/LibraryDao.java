package com.java.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.java.Exception.LibraryDaoException;
import com.java.library.Library;

public class LibraryDao {
	static final String JDBC_DRIVER = "org.h2.Driver";
	static final String DB_URL = "jdbc:h2:~/test";
	static final String USER = "sa";
	static final String PASS = "";
	Connection cn = null;

	public Connection getConnection() throws LibraryDaoException {

		try {
			
			if (cn == null) {
				Class.forName(JDBC_DRIVER);
				cn = DriverManager.getConnection(DB_URL, USER, PASS);
			} else {
				return cn;
			}
		} catch (ClassNotFoundException e) {
			throw new LibraryDaoException("problem in driver connection", e);

		} catch (SQLException e) {
			throw new LibraryDaoException("problem in driver connection", e);

		}
		return cn;

	}

	public Statement getStatement(Connection cn) throws LibraryDaoException {
		Statement st = null;
		try {
			st = cn.createStatement();
		} catch (SQLException e) {
			throw new LibraryDaoException("problem in create sattement", e);
		}
		return st;
		/*
		 * bookId; private String bookName; private String bookAuthor; private int
		 * bookCopies
		 */
	}

	public int insertBook(Library lb) throws LibraryDaoException {
		Connection connection = getConnection();
		Statement st = getStatement(connection);
		int i = 1;
		int res;
		/*if (i == 1) {

			String createTableQuery = "CREATE TABLE LIBRARY (ID INTEGER NOT NULL, NAME VARCHAR,  AUTHOR VARCHAR, "
					+ " COPIES INTEGER, PRIMARY KEY (ID))";
			try {
				st.executeUpdate(createTableQuery);
				i++;
			} catch (SQLException e) {

				throw new LibraryDaoException("Not able to Create Employee table", e);
			}
		}*/
		String query = "insert into library values(" + lb.getBookId() + ",'" + lb.getBookName() + "'" + ",'"
				+ lb.getBookAuthor() + "'," + lb.getBookCopies() + ")";
		try {
			res = st.executeUpdate(query);
		} catch (SQLException e) {
			throw new LibraryDaoException("problem in query", e);
		}
		return res;

	}
	public int updateBook(Library lb) throws LibraryDaoException, SQLException
	{
		int in;
		Connection connection= getConnection();
		Statement statement= getStatement(connection);
		String updateDataQuery = "UPDATE LIBRARY SET NAME='"+lb.getBookName()+"',"+"AUTHOR='"+lb.getBookAuthor()+"',COPIES="+lb.getBookCopies()+" WHERE ID="+lb.getBookId();
		in=statement.executeUpdate(updateDataQuery);
		return in;
		
	}

}
