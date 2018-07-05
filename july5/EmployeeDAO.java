package july4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class EmployeeDAO {

	public EmployeeDAO() {
		
	}
	
	private static Connection getConnection() {
		
			ResourceBundle rb = ResourceBundle.getBundle("july4/oracledb");
		String url = rb.getString("dburl");
		String uname = rb.getString("uname");
		String pass = rb.getString("pass");
		
		Connection con=null;
		
		try {
			
			con = DriverManager.getConnection(url,uname,pass);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	public static int addEmployee(Employee emp) {
		//write code to perform insert operation
		
		Connection con=null;
		String sql = "INSERT INTO employees VALUES(?,?,?,?)";
		int result = 0;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
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
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConnection(con);
		}
		return result;
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
	
	private static List<Employee> getEmployees(){
		
		Connection con=null;
		String sql = "SELECT empid,ename,city,salary from employees";
		int result = 0;
		List<Employee> empList = new ArrayList<>();
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = getConnection();
			
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int id  = rs.getInt("empid");
				String nm = rs.getString("ename");
				String city = rs.getString("city");
				double salary = rs.getDouble("salary");
				Employee e = new Employee(id,nm,city,salary);
				empList.add(e);
			}
			rs.close();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConnection(con);
		}
		
		return empList;
	}
}





