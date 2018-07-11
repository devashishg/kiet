package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.bo.Employee;


public class EmployeeDAO {

	public static DataSource dataSource;
	
	private static Connection getConnection() {
		Connection con = null;
		
	    try {
	    	con =	dataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    return con;
	}
	
	private static void closeConnection(Connection con) {
		try {
			if(con!=null)
				con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static int addEmployee(Employee emp) {
		//write code to perform insert operation
		
		Connection con=null;
		String sql = "INSERT INTO employees VALUES(?,?,?,?)";
		int result = 0;
		try {
			con = getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, emp.getEmpid());
			ps.setString(2, emp.getEname());
			ps.setString(3, emp.getCity());
			ps.setDouble(4, emp.getSalary());
			
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnection(con);
		}
		return result;
	}
}







