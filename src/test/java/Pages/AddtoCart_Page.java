package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AddtoCart_Page {			// Add to cart page
	
	WebDriver dr;
	public AddtoCart_Page(WebDriver dr)
	{
		this.dr=dr;
	}
	
	
	public void price() {               // Selecting the Price (high to low)
		
		
		WebElement wb=dr.findElement(By.xpath("//select[@class='product_sort_container']"));        
		Select DD=new Select(wb);
		DD.selectByVisibleText("Price (high to low)");
		
	}
	
	
	public void addtocart_btn() {          //  Adding products to the cart                  
	
			dr.findElement(By.xpath("//div[@class='inventory_item'][1]//following::button")).click();
			dr.findElement(By.xpath("//div[@class='inventory_item'][3]//following::button")).click();
			dr.findElement(By.xpath("//div[@class='inventory_item'][5]//following::button")).click();
		}
	
	public void goto_cart() {			  // Clicking the cart
		dr.findElement(By.xpath("//div[@id='shopping_cart_container']")).click();
	}
	 
	public void rem_cart() {			 // Removing products from the cart
		
			dr.findElement(By.xpath("//div[@class='item_pricebar']//following::button[2]")).click();
	}
	
	public void chkout() {				// Clicking checkout button
		
		dr.findElement(By.xpath("//a[@class='btn_action checkout_button']")).click();
	}
	
	public void cart_page() {			// Calling all the cart_page functions
		this.price();
		this.addtocart_btn();
		this.goto_cart();
		this.rem_cart();
		this.chkout();
	}
}

