package june27;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DataInputStreamDemo1 {

	public static void main(String[] args) throws IOException {
		
		File f1 = new File("d:/demoio/a2.txt");
		FileInputStream fis = new FileInputStream(f1);
		DataInputStream dis = new DataInputStream(fis);
		
		byte b = dis.readByte();
		System.out.println("\n\t byte b = " + b);
		
		short s = dis.readShort();
		System.out.println("\n\t Short s = " + s);
		
		int i = dis.readInt();
		System.out.println("\n\t int i = " + i);
		
		long l = dis.readLong();
		System.out.println("\n\t long l = " + l);
		
		float f = dis.readFloat();
		System.out.println("\n\t float f = " + f);
		
		double d = dis.readDouble();
		System.out.println("\n\t double d = " +d);
		
		String str = dis.readUTF();
		System.out.println("\n\t String s = " + str);
	}
}
