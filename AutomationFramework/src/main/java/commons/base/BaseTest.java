package commons.base;

import commons.utils.ConfigFileReader;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import web.DriverManager;
import web.WebDriverManager;

import java.lang.reflect.Member;
import java.util.Properties;

public class BaseTest {

    public ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    protected static ThreadLocal<Flipkart> flipkart = new ThreadLocal<>();
    private static DriverManager<WebDriver> driverManager;

    public static String baseUrl;
    public Properties properties;


    @BeforeSuite
    public void setup(ITestContext context){
        driverManager = new WebDriverManager();
        properties = new ConfigFileReader().loadPropertyFiles();
        baseUrl = properties.getProperty("base_url");
    }

    @BeforeMethod(alwaysRun = true)
    public void driverSetup(){
        driver.set(driverManager.getDriver("local", "chrome"));
        flipkart.set(new Flipkart(driver.get()));
        baseUrl = properties.getProperty("base_url");
    }

    public WebDriver getDriver() {
        return driver.get();
    }

    public Flipkart getPages() {
        return flipkart.get();
    }
}
