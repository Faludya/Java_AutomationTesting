package homework;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


@Getter
public class OrderDetailsPage extends  BasePage{

    public OrderDetailsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"page-35\"]/div/div[1]/ul/li[4]/strong")
    private WebElement payment1;

    @FindBy(xpath = "//*[@id=\"page-35\"]/div/div[1]/table/tfoot/tr[3]/td")
    private WebElement payment2;


}
