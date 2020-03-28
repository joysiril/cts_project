package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Information_Page {				// Your Information page
	 
	WebDriver dr;
	By first=By.xpath("//input[@id='first-name']");
	By last=By.xpath("//input[@id='last-name']");
	By code=By.xpath("//input[@id='postal-code']");
	By cntn=By.xpath("//input[@type='submit']");
	By fnsh=By.xpath("//a[@class='btn_action cart_button']");
	public Information_Page(WebDriver dr)
	{
		this.dr=dr;
	}
	
	public void fname() {					// Entering first name
		dr.findElement(first).sendKeys("joy");
	}
	
	public void lname() {					// Entering last name
		dr.findElement(last).sendKeys("siril");
	}
	
	public void zipcode() {					//Entering zip code
		dr.findElement(code).sendKeys("517501");
	}
	
	public void contue() {					// Clicking continue button 
		dr.findElement(cntn).click();
	}
	
	public void finish() {					// Clicking the finish button
		dr.findElement(fnsh).click();
	}
	
	public String thank_msg() {
		String exp_msg=dr.findElement(By.xpath("//h2[@class='complete-header']")).getText();
		return exp_msg;
	}
	
	public void info_page() {				// Calling all the info_page functions
		this.fname();
		this.lname();
		this.zipcode();
		this.contue();
		this.finish();
	}
}
