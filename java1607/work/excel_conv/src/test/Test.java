package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.dao.StudentDAO;
import test.vo.Student;

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
	
	public void DBTest() {
		ApplicationContext context = new ClassPathXmlApplicationContext("app-config.xml");
		StudentDAO sd = context.getBean(StudentDAO.class);
		for (Student s : sd.findAll()) {
			System.out.println(s);
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Test test = new Test();
		test.readTest();
		test.DBTest();
	}
	
}
