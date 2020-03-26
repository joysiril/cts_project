package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Base_Class.WrapperClass;

public class Login_page  extends  WrapperClass {           //   Login page
	
	By usr=By.xpath("//input[@id='user-name']");
	By pwd=By.xpath("//input[@id='password']");
	By clk=By.xpath("//input[@class='btn_action']");
	
	 WebDriver dr;

	public Login_page(WebDriver dr)
	{
		this.dr=dr;
	}
	
	public void username(String  name)        //   Entering Username
	{
		WebElement wt1=WaitForElement(usr,20);         
		wt1.sendKeys(name);
	}
	
	public void password(String  passwd)      // Entering Password
	{
		WebElement wt2=WaitForElement(pwd,20);
		wt2.sendKeys(passwd);
	}
	public void clk_btn()                     //  Clicking Login Button
	{
		WebElement wt3=WaitForElement(clk,20);
		wt3.click();
	}
	
	
	
	public  void Total_Login(String Usrname,String Pswd)      //  Calling Total Login Functions
	{
		System.out.println(Usrname+" "+Pswd);
		this.username(Usrname);
		this.password(Pswd);
		this.clk_btn();
		
		
	}

}
