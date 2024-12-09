package AK.tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import AK.TestComponenet.BaseTest;
import AK.TestComponenet.Retry;
import AK.pageobjects.LandingPage;
import AK.pageobjects.ProductCatalogue;


public class ErrorValidationsTest extends BaseTest {
	
	@Test(groups= {"ErrorHandling"},retryAnalyzer=Retry.class)
	public void LoginErrorValidation() throws IOException, InterruptedException{
		
				landingPage.loginApplication("Akshays@gmail.com", "Akshy@07");
				 Assert.assertEquals("Incorrect email  password", landingPage.getErrorMessage());
	}

	@Test
	public void ProductValidation() throws IOException, InterruptedException {
		String productName = "ZARA COAT 3";
	    ProductCatalogue productCatalogue=landingPage.loginApplication("Akshays@gmail.com","Akshay@07");
	    List<WebElement> products=productCatalogue.getProductList();
	    productCatalogue.addProductToCart(productName);
	    AK.pageobjects.CartPage cartPage=productCatalogue.goToCartPage();
	    Boolean match=cartPage.VerfiyProductDisaplay("ZARA COAT 33");
	    Assert.assertFalse(match);

	}
}
