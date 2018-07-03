package july3;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CS_InsertDemo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
		
		String sql = "{call insertempl(?,?,?,?)}";
		CallableStatement cs = con.prepareCall(sql);
		
		cs.setInt(1, 7);
		cs.setString(2, "Raju");
		cs.setString(3, "Mumbai");
		cs.setDouble(4, 2000.00);
		
		boolean result = cs.execute();
		System.out.println(result);
		
		if(!result) {
			int i = cs.getUpdateCount();
			if(i>0)
				System.out.println("record inserted");
		}
		
	}
}
