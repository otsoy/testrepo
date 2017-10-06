package testpackage.Tests;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import ru.yandex.qatools.allure.annotations.Description;
import testpackage.Browsers;


/**
 * Created by oksana on 10/6/2017.
 */
@Description("Test basics features in Firefox")
public class FirefoxTest extends BaseTest{
    @BeforeClass
    public static void setUpBeforeTestClass(){
        driver = Browsers.Init("Firefox");
    }
    @Test
    public void testFiltersResult(){
        mainPage.openMarket();
        marketPage.chooseSection("Computer");
        marketPage.chooseChildSection("Tablet");
        marketPage.goToAdvancedSearch();
        marketPage.choosePriceRange(20000, 25000);
        marketPage.chooseManufacturerByName("Acer");
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
