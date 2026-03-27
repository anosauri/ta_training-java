package com.epam.training.student_anna_pienkowska.final_task.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductsPage extends BasePage {

    @FindBy(xpath = "//span[text()='Products']")
    private WebElement productsHeader;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    private WebElement cartIcon;

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public boolean productsPageIsDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(productsHeader));
        return productsHeader.isDisplayed();
    }

    public void addProductToCart(String productName) {
        String formattedProductName = productName.replaceAll(" ", "-").toLowerCase();
        String buttonId = "add-to-cart-" + formattedProductName;
        WebElement addButton = driver.findElement(By.id(buttonId));
        click(addButton);
    }

    public CartPage goToCart() {
        click(cartIcon);
        return new CartPage(driver);
    }
}
