package july3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB_Select_Demo {

	public static void main(String[] args) {
		
		Connection con = null;
		Statement st = null;
		
		try {
			
			Class.forName("oracle.jdbc.OracleDriver");
			
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			
			st = con.createStatement();
			
			String sql = "SELECT * FROM employees";
			
		    //ResultSet rs =	st.executeQuery(sql);
			
			boolean result = st.execute(sql);
		    
			if(result) {
				ResultSet rs = st.getResultSet();
			
				    while( rs.next()) {
					    int empid = rs.getInt(1);
					    String ename = rs.getString(2);
					    String city = rs.getString(3);
					    Double salary = rs.getDouble(4);
					    
					    System.out.println("\n\t" + empid + "\t" + ename + "\t" + city + "\t"+ salary);
					  }
				    rs.close();
		    
			}
			
		}catch(ClassNotFoundException e) {
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
				try {
					if(con!=null)
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
}
