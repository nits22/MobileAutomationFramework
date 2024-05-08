import commons.base.BaseTest;
import org.testng.annotations.*;
import web.pages.FlipkartHomePage;

public class TestFlipkartHome extends BaseTest {


    @BeforeMethod
    @Parameters({"browser"})
    public void setup(@Optional("CHROME") String browser) {

        // created new instance of every object for parallel execution handling
        getDriver().get(baseUrl);
    }

    @Test
    public void testMenTshirtResults() {

        System.out.println("thread one");
        flipkart.get().flipkartHomePage.hoverOnFashionCategory();
        flipkart.get().flipkartHomePage.hoverOnMenTopWearSubCategory();
        flipkart.get().flipkartHomePage.clickMenTshirtSection();
    }
}
