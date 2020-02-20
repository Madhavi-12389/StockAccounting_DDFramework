package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFileUtilities {

	Workbook wb;
	public  ExcelFileUtilities() throws IOException{
		FileInputStream fi = new FileInputStream("D:\\Madhavi\\StockAccountingDdFramework\\TestInput\\supplier.xlsx");
		wb = new XSSFWorkbook(fi);
		
	}
	
	public int rowCount(String sheetname){
	  return wb.getSheet(sheetname).getLastRowNum();
		
		}
	public int colCount(String sheetname){
		return  wb.getSheet(sheetname).getRow(0).getLastCellNum();
			
			}
	
	public String getData(String sheetname,int row,int col){
		
		String data="";
		
		if (wb.getSheet(sheetname).getRow(row).getCell(col).getCellType()==Cell.CELL_TYPE_NUMERIC){
			int celldata=(int)wb.getSheet(sheetname).getRow(row).getCell(col).getNumericCellValue();
			data= String.valueOf(celldata);
		} else {
		data=wb.getSheet(sheetname).getRow(row).getCell(col).getStringCellValue();
		}
		return data;
	}
	
	
	public void setData(String sheetname,int row,int col,String status) throws IOException
	{
		Cell cell=wb.getSheet(sheetname).getRow(row).getCell(col);
		cell.setCellValue(status);
		if (status.equalsIgnoreCase("Pass")) {
		
			CellStyle style=wb.createCellStyle();
			Font font=wb.createFont();
			font.setColor(IndexedColors.GREEN.getIndex());
			font.setBold(true);
			style.setFont(font);
			cell.setCellStyle(style);
			
			
		}else if(status.equalsIgnoreCase("Fail")){
			CellStyle style=wb.createCellStyle();
			Font font=wb.createFont();
			font.setColor(IndexedColors.RED.getIndex());
			font.setBold(true);
			style.setFont(font);
			cell.setCellStyle(style);
			
		}else if(status.equalsIgnoreCase("NE")){
			CellStyle style=wb.createCellStyle();
			Font font=wb.createFont();
			font.setColor(IndexedColors.BLUE.getIndex());
			font.setBold(true);
			style.setFont(font);
			cell.setCellStyle(style);
			
		}
		
		FileOutputStream fo = new FileOutputStream("D:\\Madhavi\\StockAccountingDdFramework\\Testoutput\\supplierOutput.xlsx");
	    wb.write(fo);	
	    fo.close();
	
	
	
	
	}
	
	
}
