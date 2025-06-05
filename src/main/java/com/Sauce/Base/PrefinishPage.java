package com.Sauce.Base;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class PrefinishPage {
	
	WebDriver driver;
	public PrefinishPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy (xpath="//div[@class='cart_item_label']/a/div")
	List<WebElement> prefinishProducts;
	
	@FindBy (xpath="//div[@class='cart_item_label']//div[@class='item_pricebar']/div")
	List<WebElement> prefinishPrices;
	
	@FindBy (xpath="//div[@class='summary_value_label' and @data-test='payment-info-value']")
	WebElement paymentInfo;
	
	@FindBy (xpath="//div[@class='summary_value_label' and @data-test='shipping-info-value']")
	WebElement shippingInfo;
	
	@FindBy (xpath="//div[@class='summary_total_label' and @data-test='total-label']")
	WebElement priceTotal;
	
	@FindBy (xpath="//button[@id='cancel']")
	WebElement cancelFromPrefinish;
	
	@FindBy (xpath="//button[@id='finish']")
	WebElement finishButton;
	
	
	public boolean verifyPrefinishProduct(String productName) {
		List<String> list = new ArrayList<String>();
		for(WebElement element:prefinishProducts) {
			list.add(element.getText());
		}
		if(list.contains(productName)) {
			return true;
		}
		return false;
	}
	
	public boolean verifyPrefinishPrice(String price) {
		List<String> list = new ArrayList<String>();
		for(WebElement element:prefinishPrices) {
			list.add(element.getText());
		}
		if(list.contains(price)) {
			return true;
		}
		return false;
	}
	
	public String getPaymentInfo() {
		return paymentInfo.getText();
	}
	
	public String getShippingInfo() {
		return shippingInfo.getText();
	}
	
	public String getPricetotal() {
		return priceTotal.getText();
	}
	
	public void clickcancelfromPrefinishpage() {
		cancelFromPrefinish.click();
	}
	
	public void clickFinishbutton() {
		finishButton.click();
	}
	
	

}
