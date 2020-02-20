package CommonFunctionLibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Erp_Functions {

	WebDriver driver;
	String res="";
	
public void openApplication(){
	
	
	
}	


public String launchApp( String url){
	System.setProperty("webdriver.chrome.driver", "D:\\Madhavi\\StockAccountingDdFramework\\drivers\\chromedriver.exe");
	driver= new ChromeDriver();	
	
	
	driver.get(url);
	
	String res="";
	driver.manage().window().maximize();
	
	if (driver.findElement(By.id("btnsubmit")).isDisplayed()) {
		res= "pass";
	}else{
		res="Fail";
	}
	return res;
	
}


public String logIn(String username,String pwd) throws InterruptedException{
	
	driver.findElement(By.id("username")).clear();
	driver.findElement(By.id("username")).sendKeys(username);
	
	driver.findElement(By.id("password")).clear();
	driver.findElement(By.id("password")).sendKeys(pwd);
	driver.findElement(By.id("btnsubmit")).click();
	
	Thread.sleep(5000);
	if (driver.findElement(By.id("logout")).isDisplayed()) {
		res= "pass";
	}else{
		res="Fail";
	}
	return res;
	
	
	
}


public String supplier(String sname,String address,String city,String country,
		String cperson,String pnumber,String mail,String mnumber,String note) throws Exception{
	driver.findElement(By.linkText("Suppliers")).click();
	Thread.sleep(5000);
	driver.findElement(By.xpath("//*[@id='ewContentColumn']/div[3]/div[1]/div[1]/div[1]/div/a")).click();
	Thread.sleep(5000);
	
	String exp_data=driver.findElement(By.id("x_Supplier_Number")).getAttribute("value");
	
	driver.findElement(By.id("x_Supplier_Name")).sendKeys(sname);
	driver.findElement(By.id("x_Address")).sendKeys(address);
	driver.findElement(By.id("x_City")).sendKeys(city);
	driver.findElement(By.id("x_Country")).sendKeys(country);
	driver.findElement(By.id("x_Contact_Person")).sendKeys(cperson);
	driver.findElement(By.id("x_Phone_Number")).sendKeys(pnumber);
	driver.findElement(By.id("x__Email")).sendKeys(mail);
	driver.findElement(By.id("x_Mobile_Number")).sendKeys(mnumber);
	driver.findElement(By.id("x_Notes")).sendKeys(note);
	
	driver.findElement(By.id("btnAction")).sendKeys(Keys.ENTER);
	
	Thread.sleep(5000);
	driver.findElement(By.xpath("//button[text()='OK!']")).click();
	
	Thread.sleep(5000);
	driver.findElement(By.xpath("(//button[text()='OK'])[6]")).click();
	Thread.sleep(5000);
	if(driver.findElement(By.id("psearch")).isDisplayed()){
		Thread.sleep(5000);
		driver.findElement(By.id("psearch")).sendKeys(exp_data);
		driver.findElement(By.id("btnsubmit")).click();
	}else{
		driver.findElement(By.xpath("//*[@id='ewContentColumn']/div[2]/div[2]/div/button")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("psearch")).sendKeys(exp_data);
		driver.findElement(By.id("btnsubmit")).click();
	}
	
	String act_data=driver.findElement(By.xpath("//*[@id='el1_a_suppliers_Supplier_Number']/span")).getText();
	

	if(exp_data.equalsIgnoreCase(act_data)){
		res="Pass";
	}else{
		res="Fail";
	}
	
	return res;
	
}




public String logOut(){
	
    driver.findElement(By.linkText("logout")).click();
    driver.findElement(By.xpath("")).click();
    
    
	if (driver.findElement(By.id("logout")).isDisplayed()) {
		res= "pass";
	}else{
		res="Fail";
	}
	return res;
}

public void closeapp(){
	driver.close();
	
}



}
