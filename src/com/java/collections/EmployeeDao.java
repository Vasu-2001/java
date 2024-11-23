package com.java.collections;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class EmployeeDao{

	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "org.h2.Driver";
	static final String DB_URL = "jdbc:h2:~/test";

	// Database credentials
	static final String USER = "sa";
	static final String PASS = "";

	Connection con = null;

	public Connection getConnection() throws EmplyeeDaoException {
		try {
			if (con == null) {
				Class.forName(JDBC_DRIVER);
				con = DriverManager.getConnection(DB_URL, USER, PASS);
			}else {
				return con;
			}
		} catch (ClassNotFoundException e) {
			throw new EmplyeeDaoException("Not able to Create DB Connection", e);
		} catch (SQLException e) {
			throw new EmplyeeDaoException("Not able to Create DB Connection", e);
		}
		System.out.println("Creating Connection");
		return con;
	}

	public Statement getStatement(Connection con) throws EmplyeeDaoException {
		Statement stmt = null;
		try {
			stmt = con.createStatement();
		} catch (SQLException e) {
			throw new EmplyeeDaoException("Not able to Create Statement", e);
		}
		return stmt;
	}

	public int insertEmployee(Employee emp) throws EmplyeeDaoException 
	{
		Connection con = getConnection();

		Statement stmt = getStatement(con);
		/*  String createTableQuery =  "CREATE TABLE EMPLOYEE (ID INTEGER NOT NULL, NAME VARCHAR, SALARY INTEGER, ADDRESS VARCHAR, "
		 + " MOBILE INTEGER, GENDER VARCHAR, AGE INTEGER, PRIMARY KEY (ID))"; try {
		  stmt.executeUpdate(createTableQuery); 
		  }
		 catch (SQLException e) 
		 {
		String msg = "FAILED"; 
		
		throw new EmplyeeDaoException("Not able to Create Employee table", e); 
		}*/
		
		 

		String insertDataQuery = "INSERT INTO EMPLOYEE VALUES(" + emp.getEmpId() + ", '" + emp.getEmpName() + "', "
				+ emp.getSalary() + ", '" + emp.getAddress() + "', " + emp.getMobileNo() + ", '" + emp.getGender()
				+ "', " + emp.getAge() + " )";
		int result = 0;
		try {
			result = stmt.executeUpdate(insertDataQuery);
		} catch (SQLException e) {
			throw new EmplyeeDaoException("Not able to Create Employee table", e);
		}
		return result;
	}

	public String updateEmployee(Employee emp) throws EmplyeeDaoException {
		String msg = "SUCCESS";
		Connection con = getConnection();

		Statement stmt = getStatement(con);
		String updateDataQuery = "UPDATE EMPLOYEE SET NAME = '" + emp.getEmpName() + "',  SALARY = " + emp.getSalary()
				+ ", ADDRESS = '" + emp.getAddress() + "',  MOBILE = " + emp.getMobileNo() + ", AGE = " + emp.getAge()
				+ ",  GENDER = '" + emp.getGender() + "'  WHERE ID = " + emp.getEmpId();

		try {
			stmt.executeUpdate(updateDataQuery);
		} catch (SQLException e) {
			msg = "FAILED";
			throw new EmplyeeDaoException("Not able to Update Employee in table", e);
		}
		return msg;
	}

	public String deleteEmployee(int empId) throws EmplyeeDaoException {
		String msg = "SUCCESS";
		Connection con = getConnection();

		Statement stmt = getStatement(con);
		String deleteQuery = "DELETE EMPLOYEE WHERE ID = " + empId;

		try {
			stmt.executeUpdate(deleteQuery);
		} catch (SQLException e) {
			msg = "FAILED";
			throw new EmplyeeDaoException("Not able to Delete Employee from table", e);
		}
		return msg;
	}

	public List<Employee> getEmployees() throws EmplyeeDaoException {
		String getDataQuery = "SELECT ID, NAME, SALARY, ADDRESS, AGE, MOBILE, GENDER FROM EMPLOYEE";
		Connection con = getConnection();
		Statement st = getStatement(con);
		List<Employee> empList = new ArrayList<Employee>();

		try {
			ResultSet rs = st.executeQuery(getDataQuery);
			while (rs.next()) {
				Employee emp = new Employee();
				emp.setEmpId(rs.getInt("ID"));
				emp.setEmpName(rs.getString("NAME"));
				emp.setSalary(rs.getInt("SALARY"));
				emp.setAddress(rs.getString("ADDRESS"));
				emp.setMobileNo(rs.getLong("MOBILE"));
				emp.setGender(rs.getString("GENDER"));
				emp.setAge(rs.getInt("AGE"));

				empList.add(emp);
			}
		} catch (SQLException e) {
			throw new EmplyeeDaoException("Not able to get Employee details from table", e);
		}
		return empList;
	}

}