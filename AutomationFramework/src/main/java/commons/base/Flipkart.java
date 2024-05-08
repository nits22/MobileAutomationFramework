package commons.base;

import lombok.Getter;
import web.utils.ActionUtils;
import org.openqa.selenium.WebDriver;
import web.pages.FlipkartHomePage;
import web.pages.FlipkartListingPage;

@Getter
public class Flipkart {

    public FlipkartListingPage flipkartListingPage;
    public FlipkartHomePage flipkartHomePage;


    public Flipkart(WebDriver driver){
        flipkartHomePage = new FlipkartHomePage(driver);
        flipkartListingPage = new FlipkartListingPage(driver);
    }
}
