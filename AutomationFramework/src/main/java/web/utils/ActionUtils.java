package web.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ActionUtils {

public WebDriverWait wait;

public WebDriver driver;
public ActionUtils(WebDriver driver){
    this.driver = driver;
    wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
}
    public void hover(WebElement webElement) {

        wait.until(ExpectedConditions.visibilityOf(webElement));
        //wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(webElement)));
        Actions actions = new Actions(driver);
        actions.moveToElement(webElement).build().perform();
    }


    public void actionClick(WebElement webElement) {

        wait.until(ExpectedConditions.visibilityOf(webElement));
        Actions actions = new Actions(driver);
        actions.click(webElement).build().perform();
    }

    public void click(WebElement webElement) {

        wait.until(ExpectedConditions.visibilityOf(webElement));
        webElement.click();
    }
}
