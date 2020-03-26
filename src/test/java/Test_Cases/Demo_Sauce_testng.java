package Test_Cases;

import org.testng.annotations.Test;

import Base_Class.Get_Excel;
import Base_Class.WrapperClass;
import Pages.AddtoCart_Page;
import Pages.Information_Page;
import Pages.Login_page;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

public class Demo_Sauce_testng extends Get_Excel{
	
	 static WebDriver dr;
	 Login_page lp;

	 
	 @BeforeClass
	  public void read_excel() {  	   // To read the data from excel
		 get_Excel();	  
	  }
	 
	 @BeforeMethod
	 public void brow_launch() {      // Launching the browser
		 String url="https://www.saucedemo.com/";
		 dr=WrapperClass.Launch_browser("CHROME",url);
		 //dr=WrapperClass.Launch_browser("FIREFOX",url);	 
	 }
	 
	 
  @Test(dataProvider="logindata")
  public void Logindata(String Username,String Password) throws InterruptedException, IOException {
	  lp=new Login_page(dr);
	  System.out.println(Username+" "+Password);
	  lp.Total_Login(Username,Password); 
	  
	  AddtoCart_Page acp=new AddtoCart_Page(dr);
	  acp.cart_page();
	  
	  Information_Page inf=new Information_Page(dr);
	  inf.info_page();
	  
	  WrapperClass.screenshot();		// Taking screenshot
  }
  
  
  @DataProvider(name="logindata")
  public String[][] data_Provider() {
	  System.out.println("return data");
	  return testdata;
  }

  @AfterMethod()
  public void addcart() 
  {
	  dr.close();			// Closing the browser
	
  }
  
}
