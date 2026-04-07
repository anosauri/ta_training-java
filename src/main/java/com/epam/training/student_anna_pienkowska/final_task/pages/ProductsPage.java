package com.epam.training.student_anna_pienkowska.final_task.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPage extends BasePage {

    @FindBy(xpath = "//span[text()='Products']")
    private WebElement productsHeader;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    private WebElement cartIcon;

    private static final String ADD_TO_CART_PREFIX = "add-to-cart-";

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public boolean productsPageIsDisplayed() {
        waitUntilDisplayed(productsHeader);
        return true;
    }

    public String generateButtonId(String productName){
        String formattedProductName = productName.replaceAll(" ", "-").toLowerCase();
        return ADD_TO_CART_PREFIX + formattedProductName;
    }

    public void addProductToCart(String productName) {
        String buttonId = generateButtonId(productName);
        WebElement addButton = driver.findElement(By.id(buttonId));
        click(addButton);
    }

    public CartPage goToCart() {
        click(cartIcon);
        return new CartPage(driver);
    }
}
