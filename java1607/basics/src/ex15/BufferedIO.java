package ex15;

import java.io.*;

public class BufferedIO {

	public static void main(String[] args) {
		FileInputStream fis = null;
		BufferedInputStream bis = null;

		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			fis = new FileInputStream("D:\\x.txt");
			bis = new BufferedInputStream(fis);
			
			fr = new FileReader("D:\\y.txt");
			br = new BufferedReader(fr);
			
			String str;
			while (null != (str = br.readLine())) {
				System.out.format("RA: %s%n", str);
			}
			
			byte[] buff = new byte[1024];
			int len;
			
			while (-1 != (len = bis.read(buff))) {
				System.out.print(new String(buff, 0, len));
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
