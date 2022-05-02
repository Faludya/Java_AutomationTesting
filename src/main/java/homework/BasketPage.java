package homework;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

@Getter
public class BasketPage extends  BasePage{

    public BasketPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"page-34\"]/div/div[1]/div/div/table/tbody/tr[1]/td/span")
    private WebElement subtotal;

    @FindBy(xpath = "//*[@id=\"page-34\"]/div/div[1]/div/div/table/tbody/tr[3]/td/strong/span")
    private WebElement total;

    @FindBy(css = ".checkout-button")
    private WebElement checkoutButton;

}
