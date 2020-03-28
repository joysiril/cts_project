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

public class Demo_Sauce_testng extends WrapperClass{
	
	 static WebDriver dr;
	 Login_page lp;
	 Get_Excel exl=new Get_Excel();
	 WrapperClass wc;

	 @BeforeMethod
	 public void brow_launch() {      // Launching the browser
		 String url="https://www.saucedemo.com/";
		 dr=WrapperClass.Launch_browser("CHROME",url);
		 //dr=WrapperClass.Launch_browser("FIREFOX",url);	 
	 }
	 
	 @Test(priority=1,dataProvider="InvalidData")
	  public void LoginInvaliddata(String Username,String Password) throws InterruptedException, IOException {
		  lp=new Login_page(dr);
		  System.out.println(Username+" "+Password);		//Login page
		  lp.Total_Login(Username,Password); 
		 String exp_res=lp.err_msg();			//Getting the error message
		 System.out.println(exp_res);			
		  Assert.assertTrue(exp_res.contains("Epic sadface")); 	//Checking whether the error message contains "Epic sadface" or not
		  wc.screenshot();						//Taking screenshot
	 }
	 
  @Test(priority=2,dataProvider="ValidData")
  public void Logindata(String Username,String Password) throws InterruptedException, IOException {
	  lp=new Login_page(dr);
	  System.out.println(Username+" "+Password);			
	  lp.Total_Login(Username,Password); 				//Login page
	  
	  AddtoCart_Page acp=new AddtoCart_Page(dr);
	  acp.cart_page();									//Adding products to the cart
	  wc.screenshot();		// Taking screenshot
  }
  
  @Test(priority=3,dataProvider="AddCart")
  public void AddCart(String Username,String Password) throws InterruptedException, IOException {
	  lp=new Login_page(dr);
	  System.out.println(Username+" "+Password); 			//Login page
	  lp.Total_Login(Username,Password); 
	  
	  AddtoCart_Page acp=new AddtoCart_Page(dr);
	  acp.cart_page();										// Adding products to cart
	  
	  Information_Page inf=new Information_Page(dr);
	  inf.info_page();										// Giving information for ordering
	  String msg=inf.thank_msg();
	  System.out.println(msg);
	  Assert.assertTrue(msg.contains("THANK YOU"));
	  wc.screenshot();		// Taking screenshot
  }
  
  @DataProvider(name="InvalidData")     //Provides data for invalid login
  public String[][] Invaliddata_Provider() {
	  String[][] testdata=new String [2][2];
//	  s= exl.get_Excel(1,1);
	  testdata=exl.get_Excel("invalid details",1,1);
	  System.out.println("return data");
	  return exl.testdata;
  }
  
  @DataProvider(name="ValidData")			//Provides data for valid login 
  public String[][] ValidData_Provider() {
	  String[][] testdata=new String [2][2];
	  testdata=exl.get_Excel("valid details",1,1);
	  System.out.println("return data");
	  return exl.testdata;
  }
  
  @DataProvider(name="AddCart")				//Provides data for valid login and checkout the product
  public String[][] AddCart_Provider() {
	  String[][] testdata=new String [2][2];
	  testdata=exl.get_Excel("valid details",1,1);
	  System.out.println("return data");
	  return exl.testdata;
  }
  
  @AfterMethod()
  public void addcart() 
  {
	  dr.close();			// Closing the browser
	
  }
  
}
