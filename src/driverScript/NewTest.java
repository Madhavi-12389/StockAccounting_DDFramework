package driverScript;

import java.io.IOException;

import org.testng.annotations.Test;

import CommonFunctionLibrary.Erp_Functions;
import utilities.ExcelFileUtilities;

public class NewTest {
	
	Erp_Functions er = new Erp_Functions();
	
  @Test
  public void f() throws Exception {
	  
	  ExcelFileUtilities ecll = new ExcelFileUtilities();
	  
	  int rowcount = ecll.rowCount("supplier");
	  
	  for (int i = 1; i < rowcount; i++) {
		
		  String sname= ecll.getData("supplier", i, 0);
			String address= ecll.getData("supplier", i, 1);
			String city= ecll.getData("supplier", i, 2);
			String country= ecll.getData("supplier", i, 3);
			String cperson= ecll.getData("supplier", i, 4);
			String pnumber= ecll.getData("supplier", i, 5);
			
			String mail= ecll.getData("supplier", i, 6);
			String mnumber= ecll.getData("supplier", i, 7);
			String note= ecll.getData("supplier", i, 8);
			
			
			
			er.launchApp("http://webapp.qedge.com/");
		  
			er.logIn("admin", "master");
			
			 String status=	er.supplier(sname, address, city, country, cperson, pnumber, mail, mnumber, note);
				ecll.setData("supplier", i, 9, status);
				
		  
	}
	  
	  
  }
}
