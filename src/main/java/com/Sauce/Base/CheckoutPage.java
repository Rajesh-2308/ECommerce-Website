package com.Sauce.Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CheckoutPage {
	
	WebDriver driver;
	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//*[@id='first-name']")
	WebElement firstName;
	
	@FindBy (xpath="//*[@id='last-name']")
	WebElement lastName;
	
	@FindBy (xpath = "//*[@id='postal-code']")
	WebElement postalCode;
	
	@FindBy (xpath="//*[@id='cancel']")
	WebElement cancelButton;
	
	@FindBy (xpath="//*[@id='continue']")
	WebElement continueFromCheckout;
	
	@FindBy (xpath="//h3[@data-test='error']")
	WebElement errorMsg;
	
	public void setFirstname(String FN) {
		firstName.sendKeys(FN);
	}
	
	public void setLastName(String LN) {
		lastName.sendKeys(LN);
	}
	
	public void setPostalCode(String ZIP) {
		postalCode.sendKeys(ZIP);
	}
	
	public void clickCancelfromCheckoutPage() {
		cancelButton.click();
	}
	
	public void continuefromCheckoutPage() {
		continueFromCheckout.click();
	}
	
	public void errormsgformissinginfo(String msg) {
		Assert.assertTrue(errorMsg.getText().contains(msg));
	}

}
