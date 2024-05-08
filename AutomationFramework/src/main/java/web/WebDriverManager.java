package web;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;


public class WebDriverManager implements DriverManager<WebDriver> {

    private WebDriverFactory driverFactory;
    private DesiredCapabilities capabilities;

    @Override
    public WebDriver getDriver(String... args) {
        String runMode = args[0];
        String browserName = args[1];
        driverFactory = new WebDriverFactory();
        WebDriver webDriver;
        if(runMode.equalsIgnoreCase("local"))
            webDriver = driverFactory.createLocalWebDriver(browserName);
        else webDriver = driverFactory.createRemoteWebDriver(browserName);
        return webDriver;
    }

    @Override
    public WebDriver getDriver(MutableCapabilities capabilities, String runMode) {
        driverFactory = new WebDriverFactory();
        WebDriver webDriver;
        if(runMode.equalsIgnoreCase("local"))
            webDriver = driverFactory.createLocalWebDriver(capabilities.getBrowserName());
        else webDriver = driverFactory.createRemoteWebDriver(capabilities.getBrowserName());
        return webDriver;
    }

    @Override
    public void destroyDriver(WebDriver driver) {
        if (driver != null) {
            driver.quit();
        }
    }

    public static void main(String[] args) {
        WebDriverManager wdm = new WebDriverManager();
        WebDriver driver = wdm.getDriver("local", "chrome");
        driver.get("https://google.com");
    }
}
