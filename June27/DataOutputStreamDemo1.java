package june27;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataOutputStreamDemo1 {

	public static void main(String[] args) throws IOException {
		
		byte b = 1;
		short s = 12;
		int i = 23;
		long l = 76L;
		float f = 23.3f;
		double d = 12.54;
		String str = "Welcome";
		
		File f1 = new File("d:/demoio/a2.txt");
		FileOutputStream fos = new FileOutputStream(f1);
		DataOutputStream dos = new DataOutputStream(fos);
		
		dos.writeByte(b);
		dos.writeShort(s);
		dos.writeInt(i);
		dos.writeLong(l);
		dos.writeFloat(f);
		dos.writeDouble(d);
		dos.writeUTF(str);
		
		dos.close();
	}
}




