package testpackage.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

/**
 * Created by oksana on 10/4/2017.
 */
public class ResultsPage extends YandexPage {

    @FindBy(xpath = "//div[contains(@class, 'n-snippet-card2__title')]")
    private static List<WebElement> resultsTitles;

    public ResultsPage(WebDriver driver){
        super(driver);

    }

    public int getResultTitlesCount(){
        return resultsTitles.size();
    }

    @Step("Note first product title")
    public String getFirstResultTitle(){
        return resultsTitles.get(0).getText();
    }
}
