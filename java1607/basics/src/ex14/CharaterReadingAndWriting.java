package ex14;

import java.io.*;

public class CharaterReadingAndWriting {
	
	public static void main(String[] args) {
		FileReader fr = null;
		FileWriter fw = null;
		
		try {
			fr = new FileReader("D:\\fw.txt");
			char[] cbuf = new char[1024];
			int len = 0;
			
			while (-1 != (len = fr.read(cbuf))) {
				System.out.println(cbuf);
			}
			
			fw = new FileWriter("D:\\fw.txt", true);
			String s = "";
			for (int i = 0; i < 10; i++) {
				s += i;
				fw.write(s);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
