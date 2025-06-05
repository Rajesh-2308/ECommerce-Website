package com.Sauce.Test;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Sauce.Base.BaseClass;
import com.Sauce.Base.CartPage;
import com.Sauce.Base.LoginPage;
import com.Sauce.Base.ProductPage;
import com.beust.jcommander.Parameter;

public class CartFunctionality extends BaseClass{
	
	public void login(String username, String password) {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.setUsername(username);
		loginpage.setPassword(password);
		loginpage.clickLoginbtn();
	}
	
	@Test 
	@Parameters({"Username", "Password","Product1"})
	public void Addaproducttothecart(String username, String password, String product) throws InterruptedException {
		login(username,password);
		ProductPage productpage = new ProductPage(driver);
		productpage.clickAddtocartButton(product);
		productpage.gotoCartPage();
		CartPage cartpage = new CartPage(driver);
		cartpage.verifyCartProduct(product);
		
	}
	
	@Test 
	@Parameters({"Username", "Password","Product1","Product2"})
	public void Removeaproductfromthecart(String username, String password, String product1, String product2) throws InterruptedException {
		login(username,password);
		ProductPage productpage = new ProductPage(driver);
		productpage.clickAddtocartButton(product1);
		Thread.sleep(3000);
		productpage.clickAddtocartButton(product2);
		productpage.gotoCartPage();
		
		CartPage cartpage = new CartPage(driver);
		
		Assert.assertTrue(cartpage.verifyCartProduct(product1));
		Assert.assertTrue(cartpage.verifyCartProduct(product2));
		cartpage.removeProductCartPage(product2);
		Assert.assertFalse(cartpage.verifyCartProduct(product2));
		
	}
	
	@Test
	@Parameters({"Username", "Password","Product1","Product2"})
	public void Addmultipleproductsandverifycartitemcount(String username, String password, String product1, String product2) throws InterruptedException {
		login(username,password);
		ProductPage productpage = new ProductPage(driver);
		productpage.clickAddtocartButton(product1);
		Thread.sleep(3000);
		productpage.clickAddtocartButton(product2);
		productpage.gotoCartPage();
		
		CartPage cartpage = new CartPage(driver);
		
		Assert.assertTrue(cartpage.verifyCartProduct(product1));
		Assert.assertTrue(cartpage.verifyCartProduct(product2));
	}
	

}
