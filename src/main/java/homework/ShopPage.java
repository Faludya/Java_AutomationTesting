package homework;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

@Getter
public class ShopPage extends BasePage {

    ShopPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Home")
    private WebElement homeButton;

    @FindBy(xpath = "//img[@title='Android Quick Start Guide']")
    private WebElement bookItem;
}
