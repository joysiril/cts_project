package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Base_Class.WrapperClass;

public class Login_page {           //   Login page
	
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
		dr.findElement(usr).sendKeys(name);
	}
	
	public void password(String  passwd)      // Entering Password
	{
		dr.findElement(pwd).sendKeys(passwd);
	}
	public void clk_btn()                     //  Clicking Login Button
	{
		dr.findElement(clk).click();
	}
	public String err_msg()
	{
		String exp_err=dr.findElement(By.xpath("//h3[@data-test='error']")).getText();
		return exp_err;
	}
	
	
	public  void Total_Login(String Username,String Password)      //  Calling Total Login Functions
	{
		//System.out.println(Usrname+" "+Pswd);
		this.username(Username);
		this.password(Password);
		this.clk_btn();
		
		
	}

}
