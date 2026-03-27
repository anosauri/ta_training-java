package com.epam.training.student_anna_pienkowska.final_task.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CheckoutOverviewPage extends BasePage {

    @FindBy(css = ".summary_subtotal_label")
    private WebElement itemTotal;

    @FindBy(css = ".inventory_item_price")
    private List<WebElement> itemPrice;

    @FindBy(css = "#finish")
    private WebElement finishButton;

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    public boolean checkoutOverviewPageIsDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(itemTotal));
        return itemTotal.isDisplayed();
    }

    public CheckoutCompletePage clickFinishButton() {
        click(finishButton);
        return new CheckoutCompletePage(driver);
    }

    public double getItemPrice(WebElement priceElement) {
        String priceText = priceElement.getText();
        String price = priceText.replaceAll("[^0-9.]", "");
        return Double.parseDouble(price);
    }

    public boolean checkSum() {

        double totalPrice = getItemPrice(itemTotal);

        double sum = 0;
        for (WebElement priceElement : itemPrice) {
            double price = getItemPrice(priceElement);
            sum += price;
        }

        return sum == totalPrice;
    }

}
