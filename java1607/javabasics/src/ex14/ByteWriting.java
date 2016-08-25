package ex14;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteWriting {

	public static void main(String[] args) {
		FileOutputStream fos = null;
		
		try {
			fos = new FileOutputStream("D:\\x.txt");
			String s = new String("ËûhiË¼Ë÷");
			fos.write(s.getBytes("UTF8"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}
