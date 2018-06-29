package june27;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataOutputStreamDemo2 {

	public static void main(String[] args) throws IOException {
		
		double[] prices = {12.21, 23.50, 10.40, 43.5, 33.50};
		int[] units = {2, 5, 7, 10, 5};
		String[] pnames = {"Java T-Shirt", "Java Mug", "Java Pen", "Java Mobile", "Java key chain"};
		
		File f = new File("d:/demoio/store.txt");
		FileOutputStream fos = new FileOutputStream(f);
		DataOutputStream dos = new DataOutputStream(fos);
		
		for(int i=0; i<prices.length;i++) {
			dos.writeUTF(pnames[i]);
			dos.writeDouble(prices[i]);
			dos.writeInt(units[i]);
		}
		
		dos.close();
		
	}
}




