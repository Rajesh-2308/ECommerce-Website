package com.Sauce.Base;

import java.awt.print.PageFormat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BurgerMenu {
	
	WebDriver driver;
	public BurgerMenu(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (css = "#react-burger-menu-btn")
	WebElement burgerMenu;

	
	public void clickBurgermenu() {
		burgerMenu.click();
	}
	
	public void clickanyfromBurgermenu(String menu) {
		String xpath = "//div[@class='bm-menu-wrap']//a[text()='"+menu+"']";
		WebElement ele = driver.findElement(By.xpath(xpath));
		ele.click();
	}

}
