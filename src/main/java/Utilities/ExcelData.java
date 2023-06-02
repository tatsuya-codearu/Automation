package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData {

	public String xlData(String testID, String dataName) throws IOException {

		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\Data\\Automation.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Sheet2");

	    ArrayList<String> rowData = new ArrayList<String>();

	    Iterator<Row> rowIterator = sheet.iterator();
	    while (rowIterator.hasNext()) {
	        Row row = rowIterator.next();

	        Iterator<Cell> cellIterator = row.cellIterator();

	        while (cellIterator.hasNext()) {
	            Cell cell = cellIterator.next();
	            if (cell.getStringCellValue().isEmpty()) {
	                continue;
	            } else {
	                rowData.add(cell.getStringCellValue());
	            }
	            
	        }
	    }

	    
	    int t = -1;
	    int v = -1;

	    for (int i = 0; i < rowData.size(); i++) {
	        String value = rowData.get(i);
	        if (value.equals(testID)) {
	            t = i;
	            break;
	        }
	    }

	    for (int i = 0; i < rowData.size(); i++) {
	        String value = rowData.get(i);
	        if (value.equals(dataName)) {
	            v = i;
	            break;
	        }
	    }
	    String result= null;

	    if (t != -1 && v != -1) { // Check if t and v have been updated
	        result = rowData.get(t + v);
	         
	    }
	    workbook.close();
        
        return result;
	}
}
