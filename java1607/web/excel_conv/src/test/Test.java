package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Test {

	public void readTest() throws FileNotFoundException, IOException {
		File xls = new File("src/sample.xls");
		ExcelSheet es = new ExcelSheet();
		es.load(new FileInputStream(xls));

		for (int i = 1; i <= es.getRowCount(); i++) {
			for (int j = 1; j <= es.getColCount(); j++) {
				System.out.print("\t" + es.dataAt(i, j));
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Test test = new Test();
		test.readTest();
	}
	
}
