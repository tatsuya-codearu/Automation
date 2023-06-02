package Reporting;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Application.Cart;
import Application.Checkout;
import Application.Login;
import Application.Products;


public class Test_case extends BaseTest{
	
	
	@Test(groups="TC-001")
	@Parameters({"testId1","shopURL"})
	public void LoginTest(String testId1, String shopURL) throws Exception {
		
		Login submit = new Login(driverThread.get());
		submit.setLogin(testId1);
		driverThread.get().navigate().to(shopURL);
			
	}
	
	
	@Test(groups="TC-003")
	@Parameters({"testId3","error"})
	public void InvalidLogin(String testId3, String error) throws IOException {
		Login submit = new Login(driverThread.get());
		String info = submit.setWrongLogin(testId3);
		Assert.assertEquals(info, error);
	}
	
	@Test(groups="TC-002")
	@Parameters({"testId2","shopURL"})
	public void addingToCart(String testId2, String shopURL) throws InterruptedException, IOException {
		Login submit = new Login(driverThread.get());
		submit.setLogin(testId2);
		driverThread.get().navigate().to(shopURL);
		Products prod = new Products(driverThread.get());
		prod.addToCart1(testId2);
		submit.setLogout(testId2);
		
	}
	
	
	@Test(groups="TC-004")
	@Parameters({"testId4","shopURL", "rec"})
	public void ConfirmOrder(String testId4, String shopURL,String rec) throws InterruptedException, IOException {
		Login log = new Login(driverThread.get());
		Products prod = new Products(driverThread.get());
		Cart cart = new Cart(driverThread.get());
		Checkout check = new Checkout(driverThread.get());
		
			
		log.setLogin(testId4);
		driverThread.get().navigate().to(shopURL);
		prod.addToCart1(testId4);
		log.setLogout(testId4);
		driverThread.get().navigate().to(shopURL);
		log.setLogin(testId4);
		driverThread.get().navigate().to(shopURL);
		prod.addToCart2(testId4);
		cart.goToCart(testId4);
		check.PlaceOrder(testId4);
		
		
		TakesScreenshot ts = (TakesScreenshot) driverThread.get();	
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reports//" + testId4 + "-Step17" + ".png");
		try {
			
			FileUtils.copyFile(source, file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	


}
