package Application;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Utilities.AbstarctComps;
import Utilities.ExcelData;

public class Checkout extends AbstarctComps{
	WebDriver driver;
	ExcelData xl = new ExcelData();
	
	@FindBy(css="#billing_first_name")
	WebElement fname;
	
	@FindBy(css="#billing_last_name")
	WebElement lname;
	
	@FindBy(css="#select2-billing_country-container")
	WebElement drpdwnCountry;
	
	@FindBy(css="input[role='combobox']")
	WebElement cmboboxCountry;
	
	@FindBy(css="#select2-billing_country-result-h5l8-ZA")
	WebElement southAfrica;
	
	@FindBy(css="#billing_address_1")
	WebElement strAddress;
	
	@FindBy(css="#billing_city")
	WebElement town;
	
	@FindBy(css="#select2-billing_state-container")
	WebElement drpdwnboxProv;
	
	@FindBy(css="input[role='combobox']")
	WebElement cmboboxProv;
	
	@FindBy(css="#select2-billing_state-result-pfeg-KZN")
	WebElement KZN;
	
	@FindBy(css="#billing_postcode")
	WebElement zipCode;
	
	@FindBy(css="#billing_phone")
	WebElement phone;
	
	@FindBy(css="#billing_email")
	WebElement gmail;
	
	@FindBy(css=".woocommerce-terms-and-conditions-checkbox-text")
	WebElement terms;
	
	@FindBy(css="#place_order")
	WebElement placeOrder;
	
	@FindBy(css="li:nth-child(3) a:nth-child(1)")
	WebElement check;
	
	public Checkout(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void checkOut(String testId4) throws IOException{
		check.click();
		
	}

	public void PlaceOrder(String testId4) throws InterruptedException, IOException {
		
		
		fname.clear();
		fname.sendKeys(xl.xlData(testId4, "firstName"));
		lname.clear();
		lname.sendKeys(xl.xlData(testId4, "lastName"));
		drpdwnCountry.click();
		cmboboxCountry.sendKeys(xl.xlData(testId4, "country"));
		cmboboxCountry.sendKeys(Keys.ENTER);
		strAddress.clear();
		strAddress.sendKeys(xl.xlData(testId4, "streetAddress"));
		town.clear();
		town.sendKeys(xl.xlData(testId4, "city"));
		drpdwnboxProv.click();
		cmboboxProv.sendKeys(xl.xlData(testId4, "province"));
		cmboboxProv.sendKeys(Keys.ENTER);
		zipCode.clear();
		zipCode.sendKeys(xl.xlData(testId4, "postcode"));
		phone.clear();
		phone.sendKeys(xl.xlData(testId4, "phoneNo"));
		gmail.clear();
		gmail.sendKeys(xl.xlData(testId4, "email"));
		//waitToBeClickable(terms);
		
		TakesScreenshot ts = (TakesScreenshot) driver;	
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reports//" + testId4 + "-Step17" + ".png");
		try {
			
			FileUtils.copyFile(source, file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Thread.sleep(5000);
		terms.click();
		TakesScreenshot ts1 = (TakesScreenshot) driver;	
		File source1 = ts1.getScreenshotAs(OutputType.FILE);
		File file1 = new File(System.getProperty("user.dir") + "//reports//" + testId4 + "-Step18" + ".png");
		try {
			
			FileUtils.copyFile(source1, file1);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		placeOrder.click();
		
		TakesScreenshot ts2 = (TakesScreenshot) driver;	
		File source2 = ts2.getScreenshotAs(OutputType.FILE);
		File file2 = new File(System.getProperty("user.dir") + "//reports//" + testId4 + "-Step19" + ".png");
		try {
			
			FileUtils.copyFile(source2, file2);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Thread.sleep(4000);
		
	}

}
