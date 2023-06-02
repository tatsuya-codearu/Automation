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

public class Products extends AbstarctComps{
	WebDriver driver;
	
	@FindBy(xpath="//a[normalize-space()='Black Cross Back Maxi Dress']")
	WebElement item1;
	
	@FindBy(xpath="//a[normalize-space()='yellow tie dye bardot bodycon mini dress']")
	WebElement item2;
	
	@FindBy(css="option[value='beige']")
	WebElement color1;
	
	@FindBy(css="option[value='orange']")
	WebElement color2;
	
	@FindBy(css="option[value='medium']")
	WebElement size;
	
	@FindBy(xpath="//button[normalize-space()='Add to cart']")
	WebElement addCart;
	
	@FindBy(xpath="//a[normalize-space()='3']")
	WebElement page3;
	
	public Products(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void addToCart1(String testId2) throws InterruptedException {
		
		item1.click();
		TakesScreenshot ts1 = (TakesScreenshot) driver;	
		File source1 = ts1.getScreenshotAs(OutputType.FILE);
		File file1 = new File(System.getProperty("user.dir") + "//reports//" + testId2 + "-Step4" + ".png");
		try {
			
			FileUtils.copyFile(source1, file1);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		color1.click();
		TakesScreenshot ts2 = (TakesScreenshot) driver;	
		File source2 = ts2.getScreenshotAs(OutputType.FILE);
		File file2 = new File(System.getProperty("user.dir") + "//reports//" + testId2 + "-Step5" + ".png");
		try {
			
			FileUtils.copyFile(source2, file2);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		size.click();
		TakesScreenshot ts3 = (TakesScreenshot) driver;	
		File source3 = ts3.getScreenshotAs(OutputType.FILE);
		File file3 = new File(System.getProperty("user.dir") + "//reports//" + testId2 + "-Step6" + ".png");
		try {
			
			FileUtils.copyFile(source3, file3);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		addCart.click();
		TakesScreenshot ts = (TakesScreenshot) driver;	
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reports//" + testId2 + "-Step7" + ".png");
		try {
			
			FileUtils.copyFile(source, file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Thread.sleep(2000);
	}
	
	public void addToCart2(String testId4) {
		page3.click();
		
		TakesScreenshot ts = (TakesScreenshot) driver;	
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reports//" + testId4 + "-Step10" + ".png");
		try {
			
			FileUtils.copyFile(source, file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		item2.click();
		
		TakesScreenshot ts1 = (TakesScreenshot) driver;	
		File source1 = ts1.getScreenshotAs(OutputType.FILE);
		File file1 = new File(System.getProperty("user.dir") + "//reports//" + testId4 + "-Step11" + ".png");
		try {
			
			FileUtils.copyFile(source1, file1);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		color2.click();
		
		TakesScreenshot ts2 = (TakesScreenshot) driver;	
		File source2 = ts2.getScreenshotAs(OutputType.FILE);
		File file2 = new File(System.getProperty("user.dir") + "//reports//" + testId4 + "-Step12" + ".png");
		try {
			
			FileUtils.copyFile(source2, file2);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		size.click();
		
		TakesScreenshot ts3 = (TakesScreenshot) driver;	
		File source3 = ts3.getScreenshotAs(OutputType.FILE);
		File file3 = new File(System.getProperty("user.dir") + "//reports//" + testId4 + "-Step13" + ".png");
		try {
			
			FileUtils.copyFile(source3, file3);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		addCart.click();
		
		TakesScreenshot ts4 = (TakesScreenshot) driver;	
		File source4 = ts4.getScreenshotAs(OutputType.FILE);
		File file4 = new File(System.getProperty("user.dir") + "//reports//" + testId4 + "-Step14" + ".png");
		try {
			
			FileUtils.copyFile(source4, file4);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
