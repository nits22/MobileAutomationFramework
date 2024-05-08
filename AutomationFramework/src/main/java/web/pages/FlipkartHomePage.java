package web.pages;

import commons.base.Flipkart;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import web.utils.ActionUtils;

public class FlipkartHomePage {

    @FindBy(xpath = "//img[@class='_2puWtW _3a3qyb' and @alt='Fashion']")
    public WebElement fashionCategory;

    @FindBy(xpath = "//a[contains(@href,'topwear')]")
    public WebElement topWearSelector;

    @FindBy(xpath = "//a[contains(text(),\"Men's T-Shirts\")]")
    public WebElement menTshirtsOptionSelector;

    @FindBy(xpath = "//button[contains(@class,'_2KpZ6l _2doB4z')]")
    public WebElement closePopupSelector;

    public ActionUtils actionUtils;
    public WebDriver driver;

    public FlipkartHomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
        actionUtils = new ActionUtils(driver);
        this.driver = driver;
    }

    public void hoverOnFashionCategory() {

        actionUtils.hover(this.fashionCategory);
    }

    public void hoverOnMenTopWearSubCategory() {

        actionUtils.hover(this.topWearSelector);
    }

    public void clickMenTshirtSection() {

        actionUtils.click(this.menTshirtsOptionSelector);
    }

    public void closeLoginPopup() {

        actionUtils.click(this.closePopupSelector);
    }


}
