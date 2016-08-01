package test1;

import java.io.*;

public class IO {
	
	public static final String FILEPATH = "D:\\java\\test.txt";
	
	public static void main(String[] args) {
		File f = new File(FILEPATH);
		File dir = f.getParentFile();
		
		if (!dir.exists()) {
			dir.mkdirs();
		}
		
		try {
			f.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
