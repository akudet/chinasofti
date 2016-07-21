package ex14;

import java.io.*;

public class ByteReading {

	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream(new File("D:\\a.txt"));
			byte[] buffer = new byte[1024];
			int len = fis.read(buffer, 0, 1024);
			
			if (-1 != len) {
				System.out.println(new String(buffer, 0, len));
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
