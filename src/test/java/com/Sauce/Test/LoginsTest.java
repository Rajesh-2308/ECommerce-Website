package com.Sauce.Test;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Sauce.Base.BaseClass;
import com.Sauce.Base.LoginPage;
import com.Sauce.Base.ProductPage;

public class LoginsTest extends BaseClass{
	
	@Test
	@Parameters({"Username", "Password"})
	public void ValidLoginwithstandarduser(String username, String password) {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.setUsername(username);
		loginpage.setPassword(password);
		loginpage.clickLoginbtn();
		
		ProductPage productpage = new ProductPage(driver);
		Assert.assertTrue(productpage.isProductpage());
		
	}
	
	@Test
	@Parameters({"Username", "invalidPassword"})
	public void InvalidLoginwithwrongusernamepassword(String username, String invalidpassword){
		LoginPage loginpage = new LoginPage(driver);
		loginpage.setUsername(username);
		loginpage.setPassword(invalidpassword);
		loginpage.clickLoginbtn();
		Assert.assertTrue(loginpage.invalidLoginErrMsg().contains("do not match"));
	}
	
	@Test 
	@Parameters({"loggedoutusername", "Password"})
	public void Lockedoutuserloginattempt(String loggedoutusername, String password) {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.setUsername(loggedoutusername);
		loginpage.setPassword(password);
		loginpage.clickLoginbtn();
		Assert.assertTrue(loginpage.invalidLoginErrMsg().contains("user has been locked out"));
	}
	
	@Test
	@Parameters({"Username", "Password"})
	public void Errormessageverificationwhenusernameorpasswordismissing(String username, String password) {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.setUsername(username);
		loginpage.clickLoginbtn();
		Assert.assertTrue(loginpage.invalidLoginErrMsg().contains("Password is required"));
		pageRefresh();
		loginpage.setUsername("");
		loginpage.setPassword(password);
		loginpage.clickLoginbtn();
		Assert.assertTrue(loginpage.invalidLoginErrMsg().contains("Username is required"));
	}





}
