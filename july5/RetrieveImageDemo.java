package july4;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class RetrieveImageDemo {

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
			
			String sql = "SELECT id, imagedesc,image FROM imagedata where id=?";
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, 101);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				String desc = rs.getString(2);
				System.out.println(desc);
				
				Blob blob = rs.getBlob(3);
				byte[] barr = blob.getBytes(1, (int) blob.length());
				
				FileOutputStream fos = new FileOutputStream("d:/demoio/a1.jpg");
				fos.write(barr);
				fos.close();
				
			}else {
				System.out.println("data not found");
			}
			
			rs.close();

			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
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
