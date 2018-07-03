package july3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBDemo1 {

	public static void main(String[] args) {
		
		Connection con = null;
		Statement st  = null;
		
		try {
			// 1. load the driver class in memory
			Class.forName("oracle.jdbc.OracleDriver");
			
			// 2. Create the Connection
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			
			if(con!=null) {
				System.out.println("\n\t Connection Successfull!");
			}
			
			//3. Create a Statement Object
			st = con.createStatement();
			
			/*
			int empid = 4;
			String ename = "Anshika";
			String city = "Pune";
			double salary = 2100.00;
			
			
			//String sql = "INSERT INTO employees VALUES("+empid+", '"+ ename +"', '"+city+"', "+salary+")";
			String sql = String.format("INSERT INTO employees VALUES(%d, '%s', '%s', %f)", empid, ename, city, salary);
			
			//4. Execute the sql command 
			int result = st.executeUpdate(sql);
			
			if(result>0) {
				System.out.println("\n\t Record is inserted!");
			}else {
				System.out.println("\n\t Not Inserted");
			}*/
			
			String name = "Siddhant";
			int id = 4;

			String sql = "UPDATE employees SET ename='"+name+"' WHERE empid="+id;
		    int result = st.executeUpdate(sql);
		    
		    if(result>0)
		    	System.out.println("\n\t Record updated");
		    else
		    	System.out.println("\n\t Records not updated");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			
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

