package homework;

import org.junit.Test;
import org.openqa.selenium.support.ui.Select;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BookShopTest extends BaseTest{

    /*Checks if the Home page has three arrivals only */
    @Test
    public void testNewArrivals(){

        assertEquals(3, homePage.getNewArrivals().size());
    }

    /*Clicks on Shop, checks if the Home button is visible and clicks on it
     * Verifies if it returns to the Home page */
    @Test
    public void testShopHomeFlow(){
        homePage.getShopMenu().click();
        assertTrue(shopPage.getHomeButton().isDisplayed());
        shopPage.getHomeButton().click();
        assertEquals("Automation Practice Site", driver.getTitle());
    }

    /*Selects a book and adds it to basket. Then it goes to cart and proceeds to checkout.
    * It fills all the necessary fields and selects payment method then places order. */
    @Test
    public void testPlaceOrder(){
        //1. Click on the shop menu
        homePage.getShopMenu().click();

        //2. Click on one of the books on the list
        shopPage.getBookItem().click();

        //3. Check if the button "ADD TO BASKET" is visible and click on it
        assertTrue(bookPage.getAddButton().isDisplayed());
        bookPage.getAddButton().click();

        //4. Check if "VIEW BASKET" button is visible and click on it
        assertTrue(bookPage.getViewBasket().isDisplayed());
        bookPage.getViewBasket().click();

        //5. Verify that Subtotal < Total
        double total = Double.parseDouble(basketPage.getTotal().getText().substring(1));
        double subtotal = Double.parseDouble(basketPage.getSubtotal().getText().substring(1));
        assertTrue(total > subtotal);

        //6. Click the "CHECK OUT" button
        basketPage.getCheckoutButton().click();

        //7. Fill all the necessary fields and set Cash on Delivery
        checkoutPage.getFirstName().sendKeys("First Name");
        checkoutPage.getLastName().sendKeys("Last Name");
        checkoutPage.getEmail().sendKeys("email@test.com");
        checkoutPage.getPhone().sendKeys("1234567890");
        checkoutPage.getAddress().sendKeys("Str. My Test Address");
        checkoutPage.getCity().sendKeys("Test City");
        checkoutPage.getPostcode().sendKeys("123456");
        checkoutPage.getPassword().sendKeys("password");
        checkoutPage.getPaymentCod().click();

        Select selectCountry = new Select(checkoutPage.getCountry());
        selectCountry.selectByVisibleText("Romania");

        checkoutPage.getPlaceOrderButton().click();

        //8. Check if "Cash on Delivery" is selected for both payment methods
        assertEquals("Cash on Delivery", orderDetailsPage.getPayment1().getText());
        assertEquals("Cash on Delivery", orderDetailsPage.getPayment2().getText());
    }

}
