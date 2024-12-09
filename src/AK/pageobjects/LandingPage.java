package AK.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends AbstractComponent {

	WebDriver driver; // local variable

	public LandingPage(WebDriver driver) {

		super(driver);
		// Initialization
		this.driver = driver; // call a Local Variable
		PageFactory.initElements(driver, this);
	}

	// Page Factory
	@FindBy(id = "userEmail")
	WebElement userEmail;

	@FindBy(id = "userPassword")
	WebElement password;

	@FindBy(id = "login")
	WebElement submit;

	@FindBy(css ="[class*='flyInOut']")
	WebElement errorMessage;
	
	// method create
	public ProductCatalogue loginApplication(String email, String passwords) {
		userEmail.sendKeys(email);
		password.sendKeys(passwords);
		submit.click();
		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		return productCatalogue;
	}

	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}

	public String getErrorMessage() {
		
		waitForWebElementToAppear(errorMessage);
		return errorMessage.getText();
		
	}
}
