package july3;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class PS_Insert_Demo {

	public static void main(String[] args) throws SQLException {
		
		Driver myDriver = new oracle.jdbc.OracleDriver();
		DriverManager.registerDriver(myDriver);
		
		Properties info = new Properties();
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		info.put("user", "system");
		info.put("password", "manager");
		
		Connection con = DriverManager.getConnection(url, info);
		
		String sql = "INSERT INTO employees VALUES (?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setInt(1, 6);
		ps.setString(2, "Vipul");
		ps.setString(3, "Pune");
		ps.setDouble(4, 10000.00);
		
		int i = ps.executeUpdate();
		if(i>0) {
			System.out.println("record inserted");
		}else {
			System.out.println("not inserted");
		}
		
		con.close();
		
	}
}




