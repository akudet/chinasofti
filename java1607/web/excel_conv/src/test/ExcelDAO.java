package test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelDAO {
	Class<?> voClass;
	

	public ExcelDAO(Class<?> voClass) {
		super();
		this.voClass = voClass;
	}

	public <T> void test(Collection<T> data, Class<?> voClass) throws IllegalArgumentException, IllegalAccessException, IOException {
		HSSFWorkbook hwb = new HSSFWorkbook();
		HSSFSheet sheet = hwb.createSheet(voClass.getSimpleName().toLowerCase());
		
		mapHeader(sheet.createRow(0), voClass);
		
		int row = 1;
		
		for (T t : data) {
			mapRow(sheet.createRow(row), t);
			row++;
		}
		
		hwb.write(new File("D:\\test.xls"));
	}
	
	public void mapHeader(HSSFRow row, Class<?> voClass) {
		Field[] fields = voClass.getDeclaredFields();
		
		for (int i = 0; i < fields.length; i++) {
			HSSFCell cell = row.createCell(i);
			cell.setCellValue(fields[i].getName());
		}
	}
	
	public void mapRow(HSSFRow row, Object obj) throws IllegalArgumentException, IllegalAccessException {
		Field[] fields = obj.getClass().getDeclaredFields();
		
		for (int i = 0; i < fields.length; i++) {
			HSSFCell cell = row.createCell(i);
			fields[i].setAccessible(true);
			
			Object val = fields[i].get(obj);
			if (val instanceof Boolean){
				cell.setCellValue((Boolean) val);
			} else if (val instanceof Double) {
				cell.setCellValue((Double) val);
			} else if (val instanceof Date) {
				cell.setCellValue((Date) val);
			} else {
				cell.setCellValue(val.toString());
			}
		}
		
	}
	
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		Student s = new Student(1000, "jtwu", 27, new Date());
		
		List<Student> studs = new ArrayList<Student>();
		studs.add(s);
		
		try {
			new ExcelDAO(Student.class).test(studs, Student.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
	}
	
}
