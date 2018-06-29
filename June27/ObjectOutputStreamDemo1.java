package june27;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectOutputStreamDemo1 {

	public static void main(String[] args) throws IOException {
		
		Employee emp = new Employee(101, "Vishal", 8000.00);
		
		File f = new File("d:/demoio/objectdemo.txt");
		FileOutputStream fos  = new FileOutputStream(f);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeObject(emp);
		oos.close();
		
	}
}
