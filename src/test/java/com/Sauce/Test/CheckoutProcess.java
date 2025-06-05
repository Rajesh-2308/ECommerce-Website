package com.Sauce.Test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Sauce.Base.BaseClass;
import com.Sauce.Base.CartPage;
import com.Sauce.Base.CheckoutPage;
import com.Sauce.Base.FinishPage;
import com.Sauce.Base.LoginPage;
import com.Sauce.Base.PrefinishPage;
import com.Sauce.Base.ProductPage;

public class CheckoutProcess extends BaseClass{
	
	
	public void login(String username, String password) throws InterruptedException {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.setUsername(username);
		loginpage.setPassword(password);
		loginpage.clickLoginbtn();
		}

	
	@Test
	@Parameters({"Username", "Password","Product1","Product2"})
	public void Proceedtocheckoutfromcart(String username, String password, String product1, String product2) throws InterruptedException {
		login(username,password);
		ProductPage productpage = new ProductPage(driver);
		productpage.clickAddtocartButton(product1);
		Thread.sleep(3000);
		productpage.clickAddtocartButton(product2);
		productpage.gotoCartPage();
		
		CartPage cartpage = new CartPage(driver);
		
		Assert.assertTrue(cartpage.verifyCartProduct(product1));
		Assert.assertTrue(cartpage.verifyCartProduct(product2));
		cartpage.checkOut();
		Assert.assertTrue(driver.getCurrentUrl().equals("https://www.saucedemo.com/checkout-step-one.html"));
	}
	
	@Test
	@Parameters({"Username", "Password","Product1","Product2"})
	public void Filloutuserinformationandcontinue(String username, String password, String product1, String product2) throws InterruptedException {
		login(username,password);
		ProductPage productpage = new ProductPage(driver);
		productpage.clickAddtocartButton(product1);
		Thread.sleep(3000);
		productpage.clickAddtocartButton(product2);
		productpage.gotoCartPage();
		
		CartPage cartpage = new CartPage(driver);
		
		Assert.assertTrue(cartpage.verifyCartProduct(product1));
		Assert.assertTrue(cartpage.verifyCartProduct(product2));
		cartpage.checkOut();
		Assert.assertTrue(driver.getCurrentUrl().equals("https://www.saucedemo.com/checkout-step-one.html"));
		CheckoutPage checkoutpage = new CheckoutPage(driver);
		checkoutpage.setFirstname("Rajeshkumar");
		checkoutpage.setLastName("R");
		checkoutpage.setPostalCode("607301");
		checkoutpage.continuefromCheckoutPage();
		PrefinishPage prefinishpage = new PrefinishPage(driver);
		prefinishpage.verifyPrefinishProduct(product1);
		prefinishpage.verifyPrefinishProduct(product2);
	}
	
	@Test
	@Parameters({"Username", "Password","Product1","Product2"})
	public void Completetheorderandvalidateconfirmation(String username, String password, String product1, String product2) throws InterruptedException {
		login(username,password);
		ProductPage productpage = new ProductPage(driver);
		productpage.clickAddtocartButton(product1);
		Thread.sleep(3000);
		productpage.clickAddtocartButton(product2);
		productpage.gotoCartPage();
		
		CartPage cartpage = new CartPage(driver);
		
		Assert.assertTrue(cartpage.verifyCartProduct(product1));
		Assert.assertTrue(cartpage.verifyCartProduct(product2));
		cartpage.checkOut();
		Assert.assertTrue(driver.getCurrentUrl().equals("https://www.saucedemo.com/checkout-step-one.html"));
		CheckoutPage checkoutpage = new CheckoutPage(driver);
		checkoutpage.setFirstname("Rajeshkumar");
		checkoutpage.setLastName("R");
		checkoutpage.setPostalCode("607301");
		checkoutpage.continuefromCheckoutPage();
		PrefinishPage prefinishpage = new PrefinishPage(driver);
		prefinishpage.verifyPrefinishProduct(product1);
		prefinishpage.verifyPrefinishProduct(product2);
		prefinishpage.clickFinishbutton();
		FinishPage finishpage = new FinishPage(driver);
		finishpage.assertThankyoumsg("Thank you for your order!");
	}
	
	@Test
	@Parameters({"Username", "Password","Product1","Product2"})
	public void Errormessagesformissinguserinfo(String username, String password, String product1, String product2) throws InterruptedException {
		login(username,password);
		ProductPage productpage = new ProductPage(driver);
		productpage.clickAddtocartButton(product1);
		Thread.sleep(3000);
		productpage.clickAddtocartButton(product2);
		productpage.gotoCartPage();
		
		CartPage cartpage = new CartPage(driver);
		
		Assert.assertTrue(cartpage.verifyCartProduct(product1));
		Assert.assertTrue(cartpage.verifyCartProduct(product2));
		cartpage.checkOut();
		Assert.assertTrue(driver.getCurrentUrl().equals("https://www.saucedemo.com/checkout-step-one.html"));
		CheckoutPage checkoutpage = new CheckoutPage(driver);
		//checkoutpage.setFirstname("Rajeshkumar");
		checkoutpage.setLastName("R");
		checkoutpage.setPostalCode("607301");
		checkoutpage.continuefromCheckoutPage();
		checkoutpage.errormsgformissinginfo("First Name is required");
	}
	

}
