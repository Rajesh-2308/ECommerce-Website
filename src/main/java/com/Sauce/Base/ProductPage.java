package com.Sauce.Base;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ProductPage {
	
	WebDriver driver;
	
	public ProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//div[@id = 'inventory_container']")
	public WebElement productsLabel;
	
	@FindBy (xpath = "//select[@class='product_sort_container']")
	public WebElement productDropdown;
	
	@FindBy (xpath = "//div[@class='inventory_item_label']/a/div")
	public List<WebElement> allProducts;
	
	@FindBy (xpath = "//a[@class='shopping_cart_link']")
	public WebElement cartIcon;
	
	public void clickAddtocartButton(String productName) {
		String addtoCartXpath = "//div//div[text() = '" +productName+ "']/ancestor::div[@class='inventory_item_description']//div[@class='pricebar']//button";
		WebElement addtoCartButton = driver.findElement(By.xpath(addtoCartXpath));
		addtoCartButton.click();
	}
	
	public void clickremoveButton(String productName) {
		String addtoCartXpath = "//div//div[text() = '" +productName+ "']/ancestor::div[@class='inventory_item_description']//div[@class='pricebar']//button";
		WebElement removeButton = driver.findElement(By.xpath(addtoCartXpath));
		removeButton.click();
	}
	
	public String getProductDetails(String productName) {
		String productDetailsXpath = "//div//div[text() = '"+productName+"']/ancestor::div[@class='inventory_item_description']//div[@class='inventory_item_desc']";
		WebElement productDetails = driver.findElement(By.xpath(productDetailsXpath));
		return productDetails.getText();
	}
	
	public String getProductPrice(String productName) {
		String productPriceXpath = "//div//div[text() = '"+productName+"']/ancestor::div[@class='inventory_item_description']//div[@class='pricebar']//div";
		WebElement productPrice = driver.findElement(By.xpath(productPriceXpath));
		return productPrice.getText().substring(1);
	}
	
	public String getAllproducts() {
		StringBuilder builder = new StringBuilder();
		for(WebElement element:allProducts) {
			builder.append(element.getText()).append("\n");
		}
		return builder.toString();
	}
	
	public void viewProduct(String productName) {
		String productXpath = "//div[@class = 'inventory_item_name ' and text() = '"+productName+"']";
		WebElement productLink = driver.findElement(By.xpath(productXpath));
		productLink.click();
	}
	
	
	public void sortProducts(String dropdownValue) {
		Select select = new Select(productDropdown);
		select.selectByVisibleText(dropdownValue);
	}
	
	public void gotoCartPage() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", cartIcon);
	}
	
	public boolean isProductpage() {
		return productsLabel.isDisplayed();
	}

}
