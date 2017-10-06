package testpackage.Tests;

import org.junit.*;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Description;
import testpackage.Browsers;
import testpackage.PageObjects.MainPage;
import testpackage.PageObjects.MarketPage;
import testpackage.PageObjects.ProductDetailsPage;
import testpackage.PageObjects.ResultsPage;

/**
 * Created by oksana on 10/4/2017.
 */
@Description("Test basics features in Chrome")
public class ChromeTest extends BaseTest {
    @BeforeClass
    public static void setUpBeforeTestClass(){
        driver = Browsers.Init("Chrome");
    }

    @Test
    public void testFiltersResult(){
        mainPage.openMarket();
        marketPage.chooseSection("Computer");
        marketPage.chooseChildSection("Notebook");
        marketPage.goToAdvancedSearch();
        marketPage.choosePriceRange(-1, 30000);
        marketPage.chooseManufacturerByName("HP");
        marketPage.chooseManufacturerByName("Lenovo");
        marketPage.applyFilters();
        Assert.assertEquals("Amount of results shown is not correct", 12, resultsPage.getResultTitlesCount());
    }

    @Test
    public void testSearchResult(){
        String product = resultsPage.getFirstResultTitle();
        if(resultsPage.search(product).equals("product") ){
            Assert.assertEquals("Product title is not correct", product, productDetailsPage.getProductTitle());
        }else
        {
            Assert.assertEquals("Product title is not correct", product, resultsPage.getFirstResultTitle());
        }

    }
}
