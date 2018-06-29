package june27;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectInputStreamDemo1 {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		Employee e1 = null;
		
		File f = new File("d:/demoio/objectdemo.txt");
		FileInputStream fis = new FileInputStream(f);
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		e1 = (Employee)ois.readObject();
		
		System.out.println(e1);
		 
		ois.close();
	}
}
