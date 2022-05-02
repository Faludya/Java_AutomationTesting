package homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static homework.PropertiesLoader.getPropertyValue;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    int timeoutSec = 5;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSec));
    }

    public void loadBaseUrl() {
        String url = getPropertyValue("url");
        driver.get(url);
    }

    public WebElement find(By element) {
        return driver.findElement(element);
    }

    public void click(By element) {
        find(element).click();
    }

    public void type(By element, String text) {
        find(element).sendKeys(text);
    }

    public boolean isDisplayed(By element) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(element));
        return true;
    }

    public String getText(By element) {
        return find(element).getText();
    }
}
