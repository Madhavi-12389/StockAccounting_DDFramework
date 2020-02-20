package utilities;

import java.io.IOException;

public class dummyclass {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
    
		ExcelFileUtilities exl= new ExcelFileUtilities();
		int totalrow=exl.rowCount("supplier");
		System.out.println("Total rows are"+totalrow);
		
		int toatalcol=exl.colCount("supplier");
		System.out.println("Total col are"+toatalcol);
		
		String CellData=exl.getData("supplier", 2, 3);
		System.out.println(CellData);
		
		exl.setData("supplier", 4, 5, "Fail");
		System.out.println("hiii");
	}

}
