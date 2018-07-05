package july4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class InsertImageToDB {

	public static void main(String[] args) {
		
		ResourceBundle rb = ResourceBundle.getBundle("july4/oracledb");
		String url = rb.getString("dburl");
		String uname = rb.getString("uname");
		String pass = rb.getString("pass");
		
		
		Connection con = null;
		PreparedStatement ps = null;
		InputStream in = null;
		
		try {
			
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection(url,uname,pass);
			
			String sql = "INSERT INTO imagedata VALUES(?,?,?)";
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, 102);
			ps.setString(2, "Some Description of the image 2");
			
			File file = new File("d:/demoio/img1.jpg");
			in = new FileInputStream(file);
			
			ps.setBinaryStream(3,in, (int)file.length());
			
			int i = ps.executeUpdate();
			if(i>0)
				System.out.println("\n\t Imagedata Inserted");
			else
				System.out.println("\n\t Not Inserted");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
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
