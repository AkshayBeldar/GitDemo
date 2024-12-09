package AK.pageobjects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import AK.TestComponenet.BaseTest;

public class OrderPage extends AbstractComponent {

	WebDriver driver; // local variable

	@FindBy(css = ".totalRow button")
	WebElement checkoutEle;

	@FindBy(css = "tr td.nth-child(3)")
	private List<WebElement> productNames;

	public OrderPage(WebDriver driver) {
		super(driver);
		// Initialization
		this.driver = driver; // call a Local Variable
		PageFactory.initElements(driver, this);
	}

	public boolean VerfiyOrderDisaplay(String productName) {
		boolean match = productNames.stream()
				.anyMatch(product -> product.getText().equalsIgnoreCase(productName));
		return match;
	}

	


}
