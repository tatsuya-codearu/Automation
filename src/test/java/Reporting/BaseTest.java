package Reporting;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import Utilities.LandingPage;



public class BaseTest {
    protected ThreadLocal<WebDriver> driverThread;

    @BeforeClass
    @Parameters({"browserName", "urlRemote"})
    public void initializeDriver(String browserName, String urlRemote) {
        driverThread = new ThreadLocal<>();
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setBrowserName(browserName);

        try {
            WebDriver driver = new RemoteWebDriver(new URL(urlRemote), caps);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
            driverThread.set(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @BeforeMethod
    public LandingPage launchApplication() throws Exception {
        WebDriver driver = driverThread.get();
        LandingPage landingPage = new LandingPage(driver);
        landingPage.goTo();
        return landingPage;
    }

    @AfterMethod
    public void tearDown() {
        WebDriver driver = driverThread.get();
        if (driver != null) {
            driver.quit();
        }
    }
    
    public WebDriver getDriver() throws MalformedURLException, Exception {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\Data\\GlobalData.properties");
        prop.load(fis);
        String browserName = prop.getProperty("browser");
        String urlRemote = prop.getProperty("url");
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setBrowserName(browserName);

        return new RemoteWebDriver(new URL(urlRemote), caps);
    }

    public String getScreenshot(String testCaseName) throws IOException {
        WebDriver driver = driverThread.get();
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
        FileUtils.copyFile(source, file);
        return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
    }
}