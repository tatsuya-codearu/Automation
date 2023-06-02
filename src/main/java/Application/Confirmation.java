package Application;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.AbstarctComps;

public class Confirmation extends AbstarctComps{
	WebDriver driver;
	
	@FindBy(css=".woocommerce-thankyou-order-received")
	WebElement recieved;
	
	public Confirmation(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String Confirm() {
		System.out.println(recieved.getText());
		return recieved.getText();
	}

}
