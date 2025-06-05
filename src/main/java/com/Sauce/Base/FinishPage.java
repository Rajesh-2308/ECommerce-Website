package com.Sauce.Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class FinishPage {
	
	WebDriver driver;
	public FinishPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath="//h2[@class='complete-header']")
	WebElement thankyou;
	
	@FindBy (xpath="//div[@class='complete-text']")
	WebElement completeMsg;
	
	@FindBy (xpath="//span[@class='title']")
	WebElement completeLabel;
	
	@FindBy (xpath="back-to-products")
	WebElement backhome;
	
	public void assertThankyoumsg(String msg) {
		Assert.assertEquals(thankyou.getText(), msg);
	}
	
	public String getCompletemsg() {
		return completeMsg.getText();
	}
	
	public void checkCompletelabel() {
		Assert.assertTrue(completeLabel.getText().contains("Complete"));
	}
	
	public void clickBackhomeButton() {
		backhome.click();
	}

}
