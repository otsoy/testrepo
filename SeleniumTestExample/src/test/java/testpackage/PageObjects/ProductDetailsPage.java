package testpackage.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by oksana on 10/4/2017.
 */
public class ProductDetailsPage  extends YandexPage{
    @FindBy(xpath = "//div[contains(@class,'n-title__text')]/h1")
    private static WebElement productTitle;

    public ProductDetailsPage(WebDriver driver){
        super(driver);
    }

    public String getProductTitle(){
       return  productTitle.getText();
    }


}
