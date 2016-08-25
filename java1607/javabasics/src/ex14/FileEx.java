package ex14;

import java.io.*;

public class FileEx {

	
	public static void main(String[] args) {
		File f = new File("D:\\java\\c.txt");
		File dir = new File(f.getParent()).getParentFile();
		
		System.out.println(dir.toURI());
		
		if (!dir.exists()) {
			dir.mkdir();
		}
		
		
		String[] textFilenames = dir.list(new FilenameFilter() {

			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith(".txt");
			}
			
		});
		
		for(String filename : textFilenames) {
			System.out.println(filename);
		}
		
		File[] dirs = dir.listFiles(new DirFilter());
		for (File d : dirs) {
			System.out.println(d);
		}
		
		try {
			f.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
