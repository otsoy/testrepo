package testpackage.PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by oksana on 10/4/2017.
 */
public class YandexPage {
    protected final WebDriver driver;

    @FindBy(xpath = "//input[@id='header-search']")
    private static WebElement searchInput;

    @FindBy(xpath = "//span[contains(@class, 'search2__button')]/button")
    private static WebElement searchButton;

    public YandexPage(WebDriver driver){
        this.driver = driver;
    }

    @Step("Search for product")
    public String search(String txt){
        searchInput.sendKeys(txt);
        searchButton.submit();
        this.waitForLoad(driver);
        if (driver.getCurrentUrl().contains("product")){
            return "product";
        } else{
            return "result";
        }

    }


   public void waitForLoad(WebDriver driver) {
        new WebDriverWait(driver, 30).until(ExpectedConditions.jsReturnsValue("return document.readyState==\"complete\";"));
    }

}
