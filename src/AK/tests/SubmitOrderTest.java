package AK.tests;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import AK.TestComponenet.BaseTest;
import AK.pageobjects.CheckoutPage;
import AK.pageobjects.ConfirmationPage;
import AK.pageobjects.LandingPage;
import AK.pageobjects.OrderPage;
import AK.pageobjects.ProductCatalogue;
import AK.pageobjects.CartPage;

public class SubmitOrderTest extends BaseTest{


		String productName = "ZARA COAT 3";
		@Test(dataProvider="getData",groups= {"Purchase"})
		public void submitOrder(HashMap<String,String> input) throws IOException, InterruptedException {
			
			 LandingPage landingPage = launchApplication();
			ProductCatalogue productCatalogue = landingPage.loginApplication(input.get("email"),input.get("password"));
			List<WebElement> products = productCatalogue.getProductList();
			productCatalogue.addProductToCart(input.get("product"));
			CartPage cartpage = productCatalogue.goToCartPage();
			
			Boolean match = cartpage.VerfiyProductDisaplay(input.get("product"));
			Assert.assertTrue(match);
			CheckoutPage checkoutPage = cartpage.goToCheckout();
			checkoutPage.selectCountry("India");
			ConfirmationPage confirmationPage = checkoutPage.submitOrder();
			String confirmationMessage = confirmationPage.getConfirmationMessage();
			Assert.assertTrue(confirmationMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

		}
	@Test(dependsOnMethods= {"sumbitOrder"})
		public void OrderHistoryTest()
		{
		  // LandingPage landingPage = launchApplication();
			ProductCatalogue productCatalogue = landingPage.loginApplication("Akshays@gmail.com", "Akshay@07");
			OrderPage ordersPage=productCatalogue.goToOrderPage();
			Assert.assertTrue(ordersPage.VerfiyOrderDisaplay(productName));
			
			
		}
		
	
	
	
		
	@DataProvider
	public Object[][] getData() throws IOException
	{
		
       List<HashMap<String,String>> data = getJsonDataToMap("C:\\Users\\Admin\\eclipse\\AK\\src\\AK\\data\\PurchaseOrder.json");
		return new Object [][] {{data.get(0)},{data.get(1)}};
	}



	

	/*	
	@DataProvider
	public Object[][] getData() 
	{
		HashMap<String,String> map=new HashMap<String,String>();
		map.put("email", "Akshays@gmail.com");
		map.put("password", "Akshays@07");
		map.put("product","ZARA COAT 3");
		
		HashMap<String,String> map1=new HashMap<String,String>();
		map.put("email", "Shetty@gmail.com");
		map.put("password", "Iamking@000");
		map.put("product","ADIDAS ORIGINAL");	

		return new Object [][] {{map},{map1}};
	}

	*/
	/*
	@DataProvider
	public Object[][] getData() 
	{
		return new Object [][] {{"Akshays@gmail.com","Akshay@07","ZARA COAT 3"},{"shetty@gmail.com","Iamking@000","ADIDAS ORIGINAL"}};
	}

	*/
	}

	
	
	
