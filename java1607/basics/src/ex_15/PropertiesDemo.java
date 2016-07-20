package ex_15;

import java.io.*;
import java.util.*;

public class PropertiesDemo {
	
	public static void main(String[] args) {
		Properties pro = new Properties();
		
		File fp = new File("src/ex_15/demo.properties");
		
		try {
			pro.load(new FileReader(fp));
			pro.setProperty("code", "ANSB-1111");
			System.out.println(pro.getProperty("jode"));
			pro.store(new FileWriter(fp), "write by jtwu");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
