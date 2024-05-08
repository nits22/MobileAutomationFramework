package web;

import commons.exceptions.UnsupportedBrowserException;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

public class WebDriverFactory {
    public WebDriverFactory() {
    }

    public WebDriver createLocalWebDriver(String browserName){
        WebDriver driver;
        switch (browserName.toLowerCase()){
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                configureChromeOptions(chromeOptions);
                driver = new ChromeDriver(chromeOptions);
                break;
            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                driver = new FirefoxDriver(firefoxOptions);
                break;
            case "safari":
                SafariOptions safariOptions = new SafariOptions();
                driver = new SafariDriver(safariOptions);
                break;
            default:
                throw new UnsupportedBrowserException(
                        "Unsupported browser type. Accepted values are chrome|firefox|safari");
        }
        return driver;
    }

    public WebDriver createLocalWebDriver(Capabilities capabilities){

        WebDriver driver;
        switch (capabilities.getBrowserName().toLowerCase()){
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                configureChromeOptions(chromeOptions);
                driver = new ChromeDriver(chromeOptions);
                break;
            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                driver = new FirefoxDriver(firefoxOptions);
                break;
            case "safari":
                SafariOptions safariOptions = new SafariOptions();
                driver = new SafariDriver(safariOptions);
                break;
            default:
                throw new UnsupportedBrowserException(
                        "Unsupported browser type. Accepted values are chrome|firefox|safari");
        }
        return driver;
    }

    public WebDriver createRemoteWebDriver(String browserName){
        return null;
    }

    public WebDriver createRemoteWebDriver(DesiredCapabilities capabilities){
        return null;
    }


    private ChromeOptions configureChromeOptions(ChromeOptions options) {
        options.setAcceptInsecureCerts(true);
        options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);

        //options.setLogLevel(ChromeDriverLogLevel.fromString("DEBUG"));
        options.addArguments("--enable-javascript");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-dev-shm-usage");

        //configuration.getWebBrowserCapabilities().asMap().forEach(options::setCapability);

        options.addArguments("--start-maximized");
        options.addArguments("--disable-gpu");

        return options;
    }
}
