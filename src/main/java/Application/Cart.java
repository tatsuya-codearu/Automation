package Application;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Utilities.AbstarctComps;

public class Cart extends AbstarctComps{
	WebDriver driver;
	
	@FindBy(css=".icon_bag_alt")
	WebElement cart;
	
	@FindBy(xpath="//a[normalize-space()='Proceed to checkout']")
	WebElement proceed;
	
	
	public Cart(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void goToCart(String testId4) {
		cart.click();
		
		TakesScreenshot ts = (TakesScreenshot) driver;	
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reports//" + testId4 + "-Step15" + ".png");
		try {
			
			FileUtils.copyFile(source, file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		proceed.click();
		
		TakesScreenshot ts1 = (TakesScreenshot) driver;	
		File source1 = ts1.getScreenshotAs(OutputType.FILE);
		File file1 = new File(System.getProperty("user.dir") + "//reports//" + testId4 + "-Step16" + ".png");
		try {
			
			FileUtils.copyFile(source1, file1);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
