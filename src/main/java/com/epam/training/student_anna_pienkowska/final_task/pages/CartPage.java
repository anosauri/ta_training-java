package com.epam.training.student_anna_pienkowska.final_task.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CartPage extends BasePage {

    @FindBy(css = "[data-test='cart-quantity-label']")
    private WebElement cartElement;

    @FindBy(css = "[data-test='inventory-item-name']")
    private List<WebElement> cartItemNames;

    @FindBy(css = "#checkout")
    private WebElement checkoutButton;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean cartPageIsDisplayed() {
        //TODO: This waiting logic should be moved to BasePage
        wait.until(ExpectedConditions.visibilityOf(cartElement));
        return cartElement.isDisplayed();
    }

    public boolean productIsDisplayed(String productName) {
        return cartItemNames.stream()
                .anyMatch(item -> item.getText().equals(productName));
    }

    public CheckoutInfoPage checkout() {
        click(checkoutButton);
        return new CheckoutInfoPage(driver);
    }

}
