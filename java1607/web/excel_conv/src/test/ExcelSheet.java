package test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


public class ExcelSheet {
	
	private List<List<String>> mSheet;
	
	public int getRowCount() {
		return mSheet.size();
	}
	
	public int getColCount() {
		return mSheet.get(0).size();
	}
	
	// get the data at specific position
	// index start from 1
	public String dataAt(int i, int j) {
		return mSheet.get(i - 1).get(j - 1);
	}
	
	// load the first sheet of the input workbook
	public void load(InputStream in) throws IOException {
		HSSFWorkbook hwb = new HSSFWorkbook(in);
		HSSFSheet sheet = hwb.getSheetAt(0);
		
		mSheet = new ArrayList<List<String>>();
		
		for (int i = sheet.getFirstRowNum(); i <= sheet.getLastRowNum() ; i++) {
			HSSFRow row = sheet.getRow(i);
			if (null == row) {
				continue;
			}
			
			mSheet.add(readRow(row));
		}
	}

	private List<String> readRow(HSSFRow row) {
		List<String> rowResult = new ArrayList<String>();
		for (int j = row.getFirstCellNum(); j <= row.getLastCellNum(); j++) {
			HSSFCell cell = row.getCell(j);
			if (null == cell) {
				continue;
			}
			
			rowResult.add(cell.toString());
		}
		return rowResult;
	}

}
