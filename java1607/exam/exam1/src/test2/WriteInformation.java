package test2;

import test1.IO;

import java.io.*;

public class WriteInformation {

	public static void main(String[] args) {
		File f = new File(IO.FILEPATH);
		
		FileWriter fw = null;
		try {
			// write my information to the file
			fw = new FileWriter(f);
			
			PrintWriter pw = new PrintWriter(fw);
			pw.println("Î×½ðÍ©");
			pw.println("ÄÐ");
			pw.println("17768100357");
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// close the file if opened
			if (null != fw) {
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
}
