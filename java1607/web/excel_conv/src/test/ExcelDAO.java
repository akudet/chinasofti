package test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.RichTextString;

public class ExcelDAO {
	Class<?> voClass;
	

	public ExcelDAO(Class<?> voClass) {
		super();
		this.voClass = voClass;
	}

	public <T> void test(Collection<T> data, Class<?> voClass) throws IllegalArgumentException, IllegalAccessException, IOException, InvocationTargetException, NoSuchMethodException, SecurityException {
		HSSFWorkbook hwb = new HSSFWorkbook();
		HSSFSheet sheet = hwb.createSheet(voClass.getSimpleName().toLowerCase());
		
		mapHeader(sheet.createRow(0), voClass);
		
		int row = 1;
		
		for (T t : data) {
			mapRowByMethod(sheet.createRow(row), t);
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
				cell.setCellValue(new SimpleDateFormat("yyyy/MM/dd").format((Date) val));
			} else {
				cell.setCellValue(val.toString());
			}
		}
		
	}
	
	public Method getMethod(Class<?> voClass, Field field) throws NoSuchMethodException, SecurityException {
		String fieldName = field.getName();
		String getMethodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
		return voClass.getDeclaredMethod(getMethodName);
	}
	
	public void mapRowByMethod(HSSFRow row, Object obj) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Field[] fields = obj.getClass().getDeclaredFields();

		for (int i = 0; i < fields.length; i++) {
			HSSFCell cell = row.createCell(i);
			Method method = getMethod(obj.getClass(), fields[i]);
			
			Object val = method.invoke(obj);
			if (val instanceof Boolean){
				cell.setCellValue((Boolean) val);
			} else if (val instanceof Double) {
				cell.setCellValue((Double) val);
			} else if (val instanceof Date) {
				cell.setCellValue(new SimpleDateFormat("yyyy/MM/dd").format((Date) val));
			} else {
				cell.setCellValue(val.toString());
			}
		}
		
	}
	
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Student s1 = new Student(1000, "巫金桐", 27, new Date());
		Student s2 = new Student(1000, "wrap", 27, new Date());
		Student s3 = new Student(1000, "pitch", 27, new Date());
		
		List<Student> studs = new ArrayList<Student>();
		studs.add(s1);
		studs.add(s2);
		studs.add(s3);
		
		try {
			new ExcelDAO(Student.class).test(studs, Student.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
	}
	
}
