package com.Sauce.Test;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Sauce.Base.BaseClass;
import com.Sauce.Base.LoginPage;
import com.Sauce.Base.ProductPage;

public class ProductListingPageTest extends BaseClass{

	public void login(String username, String password) {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.setUsername(username);
		loginpage.setPassword(password);
		loginpage.clickLoginbtn();
	}
	@Test
	@Parameters({"Username", "Password"})
	public void Verifyallproductaredisplayed(String username, String password) {
		login(username,password);
		ProductPage productpage = new ProductPage(driver);
		String products = productpage.getAllproducts();
		System.out.println(products);
	}
	
	@Test
	@Parameters({"Username", "Password", "Product1"})
	public void Validateproductnamedescriptionandprice(String username, String password, String product) {
		login(username,password);
		ProductPage productpage = new ProductPage(driver);
		String productDetails = productpage.getProductDetails(product);
		System.out.println("Product details are: "+productDetails);
		String productprice = productpage.getProductPrice(product);
		System.out.println("Product price is: "+productprice);
	}
	
	@Test
	@Parameters({"Username", "Password", "Sort"})
	public void Sortproductsandvalidateorder(String username, String password, String sort)  {
		login(username,password);
		ProductPage productpage = new ProductPage(driver);
		productpage.sortProducts(sort);
	}
	
	@Test
	@Parameters({"Username", "Password", "Product1"})
	public void Clickonproductandvalidateredirectiontoproductdetailpage(String username, String password, String product)  {
		login(username,password);
		ProductPage productpage = new ProductPage(driver);
		productpage.viewProduct(product);
		String currentURL = driver.getCurrentUrl();
		Assert.assertTrue(currentURL.contains("https://www.saucedemo.com/inventory-item.html"));
	}

}
