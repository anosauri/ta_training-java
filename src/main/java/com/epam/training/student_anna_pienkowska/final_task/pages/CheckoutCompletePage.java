package com.epam.training.student_anna_pienkowska.final_task.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutCompletePage extends BasePage {

    @FindBy(css = ".complete-header")
    private WebElement completeMessage;

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    public boolean isCheckoutCompletePageDisplayed() {
        //TODO I recommend you to create methods with different waiting conditions in BasePage
        // and use them in your page classes
        wait.until(ExpectedConditions.visibilityOf(completeMessage));
        return completeMessage.isDisplayed();
    }

    public boolean isCheckoutCompleted(String message) {
        String text = completeMessage.getText();
        return text.equals(message);
    }

}
