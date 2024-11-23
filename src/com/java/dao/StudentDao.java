package com.java.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.java.Exception.StudentDaoException;
import com.java.library.Student;

public class StudentDao {
	static final String JDBC_DRIVER = "org.h2.Driver";
	static final String DB_URL = "jdbc:h2:~/test";

	// Database credentials
	static final String USER = "sa";
	static final String PASS = "";

	Connection con = null;

	public Connection getConnection() throws StudentDaoException {
		try {
			if (con == null) {
				Class.forName(JDBC_DRIVER);
				con = DriverManager.getConnection(DB_URL, USER, PASS);
			}
		} catch (Exception e) {
			throw new StudentDaoException("problem occurs in registration", e);

		}

		return con;

	}

	public Statement getStatement(Connection connection) throws StudentDaoException {
		Statement st = null;
		try {
			st = con.createStatement();

		} catch (SQLException e) {
			throw new StudentDaoException("problem occurs in statement ", e);
		}

		return st;
	}

	public int insertStudent(Student std) throws StudentDaoException {

		Connection connection = getConnection();
		Statement statement = getStatement(connection);
		/*
		 * String query =
		 * "CREATE TABLE STUDENT( ID INTEGER NOT NULL, NAME VARCHAR, MOBILE INTEGER, GENDER VARCHAR, PRIMARY KEY(ID));"
		 * ; try { statement.executeUpdate(query); } catch (SQLException e) { throw new
		 * StudentDaoException("problem occcurs creating table", e);
		 * 
		 * }
		 */

		String updateQuery = "INSERT INTO STUDENT VALUES(" + std.getSid() + ",'" + std.getSname() + "',"
				+ std.getMobile() + ",'" + std.getGender() + "')";
		int res;
		try {
			res = statement.executeUpdate(updateQuery);
		} catch (SQLException e) {
			throw new StudentDaoException("problem occurs in inserting query", e);

		}
		return res;

	}
	public int updateStudent(Student std) throws StudentDaoException
	{
		Connection connection = getConnection();
		Statement statement = getStatement(connection);
		int res;
		String query= "UPDATE STUDENT SET NAME='"+std.getSname()+"',MOBILE="+std.getMobile()+",GENDER='"+std.getGender()+"'"+"where ID="+std.getSid();
		try
		{
			res=statement.executeUpdate(query);
		}
		catch (SQLException e) {
			throw new StudentDaoException("problem occurs in update qyery", e);
			// TODO: handle exception
		}
		return res;
	}
	public void  showAll() throws StudentDaoException
	{
		Connection connection = getConnection();
		Statement statement = getStatement(connection);
		try
		{
		ResultSet rs =statement.executeQuery("select * from student");
		while(rs.next()) {
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3)+"\t"+rs.getString(4));
		}
		}
		catch (SQLException e) {
			throw new StudentDaoException("problem occurs in show all the details", e);
			// TODO: handle exception
		}
		
	}
	public int deleteStudent(int id) throws StudentDaoException
	{
		Connection connection = getConnection();
		Statement statement = getStatement(connection);
		int res;
		try
		{
			res=statement.executeUpdate("delete from student where ID="+id);
		}
		catch (SQLException e) {
			throw new StudentDaoException("problem occurs in delete", e);

			// TODO: handle exception
		}
		return res;
		
	}

}
