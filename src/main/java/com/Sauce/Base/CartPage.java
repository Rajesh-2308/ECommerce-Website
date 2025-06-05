package com.Sauce.Base;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CartPage {
	
	WebDriver driver;
	public CartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath="//div[@class='cart_item_label']/a/div")
	List<WebElement> cartProducts;
	
	@FindBy (xpath="//div[@class='cart_item_label']//div[@class='item_pricebar']/div")
	List<WebElement> cartPrices;
	
	@FindBy (xpath="//*[@name='continue-shopping']")
	WebElement continueShoppingButton;
	
	@FindBy (xpath="//*[@name='checkout']")
	WebElement checkoutButton;
	
	
	public boolean verifyCartProduct(String productName) {
		List<String> list = new ArrayList<String>();
		for(WebElement element:cartProducts) {
			list.add(element.getText());
		}
		if(list.contains(productName)) {
			return true;
		}
		return false;
	}
	
	public boolean verifyCartPrice(String price) {
		List<String> list = new ArrayList<String>();
		for(WebElement element:cartPrices) {
			list.add(element.getText().substring(1));
		}
		if(list.contains(price)) {
			return true;
		}
		return false;
	}
	
	public void removeProductCartPage(String productName) {
		String removeXpath = "//*[text()='"+productName+"']/ancestor::div[@class='cart_item_label']/div/button";
		driver.findElement(By.xpath(removeXpath)).click();
	}
	
	public void continueShopping() {
		continueShoppingButton.click();
	}
	
	public void checkOut() {
		checkoutButton.click();
	}

}
