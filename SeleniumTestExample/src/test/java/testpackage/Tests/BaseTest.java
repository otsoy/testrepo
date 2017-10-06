package testpackage.Tests;


import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import testpackage.Browsers;
import testpackage.PageObjects.MainPage;
import testpackage.PageObjects.MarketPage;
import testpackage.PageObjects.ProductDetailsPage;
import testpackage.PageObjects.ResultsPage;


/**
 * Created by oksana on 10/6/2017.
 */
public class BaseTest {
    static WebDriver driver;
    MainPage mainPage;
    MarketPage marketPage;
    ResultsPage resultsPage;
    ProductDetailsPage productDetailsPage;

    @Before
    public  void setUp(){
        mainPage = PageFactory.initElements(driver, MainPage.class);
        marketPage = PageFactory.initElements(driver, MarketPage.class);
        resultsPage = PageFactory.initElements(driver, ResultsPage.class);
        productDetailsPage =PageFactory.initElements(driver, ProductDetailsPage.class);
    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }
}
