package testpackage.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by oksana on 10/3/2017.
 */
public class MainPage extends YandexPage {

    @FindBy(xpath = "//a[@data-id='market']\n")
    public static WebElement marketButton;

    public MainPage (WebDriver driver){
        super(driver);
    }

    @Step("Open Yandex.Market")
    public void openMarket(){
        marketButton.click();
        this.waitForLoad(driver);
    }
}
