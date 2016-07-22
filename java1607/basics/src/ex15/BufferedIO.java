package ex15;

import java.io.*;

public class BufferedIO {

	public static void main(String[] args) {
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		
		try {
			fis = new FileInputStream("D:\\x.txt");
			bis = new BufferedInputStream(fis);
			
			byte[] buff = new byte[1024];
			int len;
			
			while (-1 != (len = bis.read(buff))) {
				System.out.println(new String(buff, 0, len));
			}
			

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				bis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
