package metodo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import model.Orden;


public class ExcelExport {
	public static void ordenToExcel(Orden orden) throws FileNotFoundException {
		String path = "src/ordenes.xlsx";
		try {
			FileInputStream inputStream = new FileInputStream(new File(path));
			Workbook wb = WorkbookFactory.create(inputStream);
	        Sheet sheet = wb.getSheetAt(0);
	        CellStyle style;
	        DataFormat format = wb.createDataFormat();
	        
			int rowCount = sheet.getLastRowNum();
	        int columnCount = 0;

	        Row row = sheet.createRow(++rowCount);
	        Cell cell = row.createCell(columnCount);
	        cell.setCellValue(orden.getNombre());
	        
	        cell = row.createCell(++columnCount);
	        cell.setCellValue(orden.getDireccion());
	        
	        cell = row.createCell(++columnCount);
	        cell.setCellValue(orden.getMonto());
	        style = wb.createCellStyle();
	        style.setDataFormat(format.getFormat("$* #,##"));
	        cell.setCellStyle(style);
	        
	        cell = row.createCell(++columnCount);
	        cell.setCellValue(orden.getFecha());
	        style = wb.createCellStyle();
	        style.setDataFormat(format.getFormat("dd-mm-yyyy"));
	        cell.setCellStyle(style);
	        
	        cell = row.createCell(++columnCount);
	        cell.setCellValue(orden.getProductCodes());
	        for (int i = 0; i < columnCount; i++) {
	        	sheet.autoSizeColumn(i);
			}
	        
	        inputStream.close();
			
	        FileOutputStream outputStream = new FileOutputStream(path);
	        wb.write(outputStream);
        	wb.close();
        	outputStream.close();
	        		
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	
	}
}
