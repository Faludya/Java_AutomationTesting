package homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;

import static homework.PropertiesLoader.getPropertyValue;

public class BaseTest {

    protected WebDriver driver;
    ChromeOptions options = new ChromeOptions();
    Map<String, Object> prefs = new HashMap<String, Object>();

    protected BasePage basePage;
    protected HomePage homePage;
    protected ShopPage shopPage;
    protected BookPage bookPage;
    protected BasketPage basketPage;
    protected CheckoutPage checkoutPage;
    protected OrderDetailsPage orderDetailsPage;

    public WebDriver getDriver() {
        String browser = getPropertyValue("browser");

        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                prefs.put("profile.managed_default_content_settings.javascript", 2);
                options.setExperimentalOption("prefs", prefs);
                options.addArguments("start-maximized");
                driver = new ChromeDriver(options);
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
        }

        return driver;
    }

    @Before
    public void setup() {
        driver = getDriver();

        basePage = new BasePage(driver);
        homePage = new HomePage(driver);
        shopPage = new ShopPage(driver);
        bookPage = new BookPage(driver);
        basketPage = new BasketPage(driver);
        checkoutPage = new CheckoutPage(driver);
        orderDetailsPage = new OrderDetailsPage(driver);

        basePage.loadBaseUrl();
    }

    @After
    public void after() {
        driver.quit();
    }

}
