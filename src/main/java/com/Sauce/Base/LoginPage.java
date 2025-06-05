package com.Sauce.Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "user-name")
	public WebElement username;

	@FindBy(id = "password")
	public WebElement password;

	@FindBy(id = "login-button")
	public WebElement loginButton;
	
	@FindBy (xpath="//h3[@data-test='error']")
	public WebElement errormsg;

	public void setUsername(String Username) {
		username.sendKeys(Username);
	}
	
	public void setPassword(String Password) {
		password.sendKeys(Password);
	}
	
	public void clickLoginbtn() {
		loginButton.click();
	}
	
	public String invalidLoginErrMsg() {
		return errormsg.getText();
	}

}
