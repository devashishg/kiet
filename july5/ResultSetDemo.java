package july4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ResultSetDemo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		ResourceBundle rb = ResourceBundle.getBundle("july4/oracledb");
		String url = rb.getString("dburl");
		String uname = rb.getString("uname");
		String pass = rb.getString("pass");
		
		
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(url,uname,pass);
		
		String sql = "SELECT empid,ename,city,salary FROM employees";
		
		PreparedStatement ps = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		
		ResultSet rs = ps.executeQuery();
		
		rs.next();
		System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getDouble(4));
		
		rs.next();
		System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getDouble(4));
		
		rs.previous();
		System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getDouble(4));
		
		rs.absolute(5);
		System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getDouble(4));
		
		rs.relative(2);
		System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getDouble(4));

		rs.first();
		System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getDouble(4));

		rs.updateString(3, "Mumbai");
		rs.updateDouble(4, 5000.00);
		rs.updateRow();
		System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getDouble(4));

		rs.next();
		System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getDouble(4));

		rs.deleteRow();
		
		rs.moveToInsertRow();
		rs.updateInt(1, 9);
		rs.updateString(2, "Anshika");
		rs.updateString(3, "Delhi");
		rs.updateDouble(4, 2000);
		rs.insertRow();
		
		rs.close();
		con.close();
		
	}
}







