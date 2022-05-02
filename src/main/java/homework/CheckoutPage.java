package homework;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class CheckoutPage extends  BasePage{

    public CheckoutPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "billing_first_name")
    private WebElement firstName;

    @FindBy(id = "billing_last_name")
    private WebElement lastName;

    @FindBy(id = "billing_email")
    private WebElement email;

    @FindBy(id = "billing_phone")
    private WebElement phone;

    @FindBy(id = "billing_country")
    private WebElement country;

    @FindBy(id = "billing_address_1")
    private WebElement address;

    @FindBy(id = "billing_city")
    private WebElement city;

    @FindBy(id = "billing_postcode")
    private WebElement postcode;

    @FindBy(id = "account_password")
    private WebElement password;

    @FindBy(id = "payment_method_cod")
    private WebElement paymentCod;

    @FindBy(id = "place_order")
    private WebElement placeOrderButton;

}
