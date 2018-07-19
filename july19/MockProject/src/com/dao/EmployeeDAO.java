package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.bo.Employee;


public class EmployeeDAO {

	private static String table_name = "emp";
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
	
	public static Employee validateUser(String username, String password) {
		Employee e = null;
		
		Connection con=null;
		String sql = "SELECT EMPID, ENAME, CITY, SALARY FROM emp WHERE ENAME=?";
	
		try {
			con = getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
		
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				int empid = rs.getInt(1);
				String en = rs.getString(2);
				String ct = rs.getString(3);
				double sal = rs.getDouble(4);
				e = new Employee(empid, en, ct, sal);
			}
			
			rs.close();
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		} finally {
			closeConnection(con);
		}
		return e;
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
		String sql = "INSERT INTO "+table_name+" VALUES(?,?,?,?)";
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

	public static Employee getEmp(int empid) {
		
		Employee emp = null;
		PreparedStatement ps = null;
		Connection con = null;
		try {
			con = getConnection();
			String sql = "SELECT empid, ename, city, salary from "+table_name+" where empid=?";
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, empid);
		    ResultSet rs = 	ps.executeQuery();
		    
		    if(rs.next()) {
		    	int eid = rs.getInt("empid");
		    	String ename = rs.getString("ename");
		    	String city = rs.getString("city");
		    	double salary = rs.getDouble("salary");
		    	
		    	return new Employee(eid, ename, city, salary);
		    	
		    }
		    rs.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConnection(con);
		}
		
		return emp;
		
	}
	
	public static List<Employee> getAllEmp() {
		List<Employee> empList = new ArrayList<>();
		
		PreparedStatement ps = null;
		Connection con = null;
		
		
		try {
			
			con = getConnection();
			String sql = "SELECT empid, ename, city, salary from emp";
			ps = con.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				
				int eid = rs.getInt("empid");
		    	String ename = rs.getString("ename");
		    	String city = rs.getString("city");
		    	double salary = rs.getDouble("salary");
		    	
		    	empList.add(new Employee(eid, ename, city, salary));
			}
			rs.close();		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConnection(con);
		}

		return empList;
	}

	public static int updateEmployee(Employee emp) {
		
		int result = 0;
		Connection con = null;
		try {
			con = getConnection();
			
			String sql = "UPDATE emp SET ename=?, city=?, salary=? WHERE empid=?";
			PreparedStatement ps = con.prepareStatement(sql);
	
			ps.setString(1, emp.getEname());
			ps.setString(2, emp.getCity());
			ps.setDouble(3, emp.getSalary());
			ps.setInt(4, emp.getEmpid());
			
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







