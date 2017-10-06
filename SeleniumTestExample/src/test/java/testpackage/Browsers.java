package testpackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by oksana on 10/6/2017.
 */
public class Browsers {
    private static WebDriver driver;
    private static String baseURL = "https://www.yandex.ru/";


    public static WebDriver Init(String browser)
    {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\oksana\\Downloads\\geckodriver-v0.19.0-win64\\geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\oksana\\Downloads\\chromedriver_win32\\chromedriver.exe");
        if (browser.equals("Chrome") ){
            driver = new ChromeDriver();
        }else if (browser.equals("Firefox")){
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.get(baseURL);
        return driver;
    }


}
