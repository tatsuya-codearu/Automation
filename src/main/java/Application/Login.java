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
import org.testng.Assert;
import org.testng.annotations.Test;

import Utilities.AbstarctComps;
import Utilities.ExcelData;

public class Login extends AbstarctComps {

	WebDriver driver;
	ExcelData xl = new ExcelData();

	@FindBy(linkText = "My Account")
	WebElement myaccount;

	@FindBy(xpath = "//input[@id='username']")
	WebElement usrname;

	@FindBy(xpath = "//input[@id='password']")
	WebElement passwrd;

	@FindBy(css = "button[value='Log in']")
	WebElement login;

	@FindBy(css = "div[id='primary'] li:nth-child(1)")
	WebElement error;

	@FindBy(xpath = "//p[contains(text(),'Hello')]")
	WebElement conflogin;

	@FindBy(linkText = "Log out")
	WebElement logout;

	@FindBy(xpath = "//div[@id='primary']//li[1]")
	WebElement invlogin;

	public Login(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void setLogin(String testId1) throws IOException {
		waitForWebElementToAppear(myaccount);
		myaccount.click();
		//getScreenshot(testId1, driver);
		
		TakesScreenshot ts = (TakesScreenshot) driver;	
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reports//" + testId1 + "-Step1" + ".png");
		try {
			
			FileUtils.copyFile(source, file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		usrname.sendKeys(xl.xlData(testId1, "username"));
		passwrd.sendKeys(xl.xlData(testId1, "password"));
		
		TakesScreenshot ts1 = (TakesScreenshot) driver;	
		File source1 = ts1.getScreenshotAs(OutputType.FILE);
		File file1 = new File(System.getProperty("user.dir") + "//reports//" + testId1 + "-Step2" + ".png");
		try {
			
			FileUtils.copyFile(source1, file1);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		login.click();
		
		TakesScreenshot ts2 = (TakesScreenshot) driver;	
		File source2 = ts2.getScreenshotAs(OutputType.FILE);
		File file2 = new File(System.getProperty("user.dir") + "//reports//" + testId1 + "-Step3" + ".png");
		try {
			
			FileUtils.copyFile(source2, file2);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Assert.assertEquals("Hello villy (not villy? Log out)", conflogin.getText());

	}

	public void setLogout(String testId2) {
		myaccount.click();
		TakesScreenshot ts = (TakesScreenshot) driver;	
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reports//" + testId2 + "-Step8" + ".png");
		try {
			
			FileUtils.copyFile(source, file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		logout.click();
		TakesScreenshot ts1 = (TakesScreenshot) driver;	
		File source1 = ts1.getScreenshotAs(OutputType.FILE);
		File file1 = new File(System.getProperty("user.dir") + "//reports//" + testId2 + "-Step9" + ".png");
		try {
			
			FileUtils.copyFile(source1, file1);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String setWrongLogin(String testId3) throws IOException {
		waitForWebElementToAppear(myaccount);
		myaccount.click();
		TakesScreenshot ts = (TakesScreenshot) driver;	
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reports//" + testId3 + "-Step1" + ".png");
		try {
			
			FileUtils.copyFile(source, file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		usrname.sendKeys(xl.xlData(testId3, "username"));
		passwrd.sendKeys(xl.xlData(testId3, "password"));
		
		TakesScreenshot ts1 = (TakesScreenshot) driver;	
		File source1 = ts1.getScreenshotAs(OutputType.FILE);
		File file1 = new File(System.getProperty("user.dir") + "//reports//" + testId3 + "-Step2" + ".png");
		try {
			
			FileUtils.copyFile(source1, file1);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		login.click();
		
		TakesScreenshot ts2 = (TakesScreenshot) driver;	
		File source2 = ts2.getScreenshotAs(OutputType.FILE);
		File file2 = new File(System.getProperty("user.dir") + "//reports//" + testId3 + "-Step" + ".png");
		try {
			
			FileUtils.copyFile(source2, file2);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return invlogin.getText();
	}

}
