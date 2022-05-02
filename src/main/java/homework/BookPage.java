package homework;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

@Getter
public class BookPage extends  BasePage{
    public BookPage(WebDriver driver) {

        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".woocommerce-Price-amount")
    private List<WebElement> prices;

    @FindBy(css = ".product_title")
    private WebElement title;

    @FindBy(css = ".single_add_to_cart_button")
    private WebElement addButton;

    @FindBy(xpath = "//*[@id=\"content\"]/div[1]/a")
    private WebElement viewBasket;
}
