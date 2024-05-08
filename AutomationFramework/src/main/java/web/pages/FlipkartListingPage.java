package web.pages;

import commons.base.Flipkart;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import web.utils.ActionUtils;

import java.util.ArrayList;
import java.util.List;

public class FlipkartListingPage {

    public By productNameSelector = By.xpath("//img[contains(@src,'image')]/following::a[contains(@class,'IRpwTa')]");

    public WebDriver driver;

    public ActionUtils actionUtils;

    public FlipkartListingPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        actionUtils = new ActionUtils(driver);
        this.driver = driver;
    }

    public List<String> getProductNameList() {

        List<WebElement> elements = driver.findElements(productNameSelector);

        List<String> nameList = new ArrayList<>();

        for (WebElement element : elements) {

            nameList.add(element.getText());
        }

        return nameList;

    }

}
