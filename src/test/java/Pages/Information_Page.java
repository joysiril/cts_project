package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Information_Page {				// Your Information page
	 
	WebDriver dr;
	
	public Information_Page(WebDriver dr)
	{
		this.dr=dr;
	}
	
	public void fname() {					// Entering first name
		dr.findElement(By.xpath("//input[@id='first-name']")).sendKeys("joy");
	}
	
	public void lname() {					// Entering last name
		dr.findElement(By.xpath("//input[@id='last-name']")).sendKeys("siril");
	}
	
	public void zipcode() {					//Entering zip code
		dr.findElement(By.xpath("//input[@id='postal-code']")).sendKeys("517501");
	}
	
	public void contue() {					// Clicking continue button 
		dr.findElement(By.xpath("//input[@type='submit']")).click();
	}
	
	public void finish() {					// Clicking the finish button
		dr.findElement(By.xpath("//a[@class='btn_action cart_button']")).click();
	}
	
	public void info_page() {				// Calling all the info_page functions
		this.fname();
		this.lname();
		this.zipcode();
		this.contue();
		this.finish();
	}
}
