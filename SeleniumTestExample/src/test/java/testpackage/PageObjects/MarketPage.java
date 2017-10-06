package testpackage.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by oksana on 10/3/2017.
 */
public class MarketPage extends YandexPage {

    @FindBy(xpath = "//a[@class='link topmenu__link' and contains(@href, 'hid=91009') ]")
    private static WebElement computersButton;

    @FindBy(xpath = "//a[contains(@href, 'hid=91013') and contains(@class, 'catalog-menu__list-item')]")
    private static WebElement notebooksButton;

    @FindBy(xpath = "//a[contains(@href, 'hid=6427100') and contains(@class, 'catalog-menu__list-item')]")
    private static WebElement tabletButton;

    @FindBy(xpath = "//div[@class='n-filter-panel-aside__controls']//a")
    private static WebElement allFiltersLink;

    @FindBy(xpath = "//input[@id='glf-priceto-var']")
    private static WebElement priceTo;

    @FindBy(xpath = "//input[@id='glf-pricefrom-var']")
    private static WebElement priceFrom;

    @FindBy(xpath = "//a[contains(@class,'button_action_show-filtered')]")
    private static WebElement applyButton;


    public MarketPage(WebDriver driver){
        super(driver);
    }

    public void chooseManufacturerByName(String name){
        String xPath = "//div[contains(@class,'n-filter-block_type_normal')][2]//label[@class='checkbox__label' and contains(text(), 'Manufacturer')]";
         driver.findElement(By.xpath(xPath.replace("Manufacturer", name))).click() ;
    }

    @Step("Choose section")
    public void chooseSection(String sectionName){
        if(sectionName.equals("Computer")){
            computersButton.click();
        }
    }
    @Step("Choose child section")
    public void chooseChildSection(String sectionName){
        if (sectionName.equals("Notebook")) {
            notebooksButton.click();
        }else if (sectionName.equals("Tablet")){
            tabletButton.click();
        }
    }

    @Step("Proceed to Advanced Search")
    public void goToAdvancedSearch(){
        allFiltersLink.click();
    }

    @Step("Choose price range")
    public void choosePriceRange(int from, int to){
        if (from > 0) {
            priceFrom.sendKeys(Integer.toString(from));
        }
        if (to > 0) {
            priceTo.sendKeys(Integer.toString(to));
        }
    }

    @Step("Press Apply button")
    public void applyFilters(){
        applyButton.click();
        waitForLoad(driver);
    }

}
