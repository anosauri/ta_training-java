package com.epam.training.student_anna_pienkowska.final_task.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePage {

    @FindBy(css = "[data-test='cart-quantity-label']")
    private WebElement cartTitle;

    @FindBy(css = "[data-test='inventory-item-name']")
    private List<WebElement> cartItemNames;

    @FindBy(css = "#checkout")
    private WebElement checkoutButton;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean cartPageIsDisplayed() {
        return cartTitle.isDisplayed();
    }

    public boolean productIsDisplayed(String productName) {
        for (WebElement item : cartItemNames) {
            if (item.getText().equals(productName)) {
                return true;
            }
        }
        return false;
    }

    public CheckoutInfoPage checkout() {
        click(checkoutButton);
        return new CheckoutInfoPage(driver);
    }

}
