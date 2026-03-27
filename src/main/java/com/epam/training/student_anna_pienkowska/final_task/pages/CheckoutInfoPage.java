package com.epam.training.student_anna_pienkowska.final_task.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutInfoPage extends BasePage {

    @FindBy(css = "#first-name")
    private WebElement firstNameField;

    @FindBy(css = "#last-name")
    private WebElement lastNameField;

    @FindBy(css = "#postal-code")
    private WebElement postalCodeField;

    @FindBy(xpath = "//input[@id='continue']")
    private WebElement continueButton;

    public CheckoutInfoPage(WebDriver driver) {
        super(driver);
    }

    public boolean checkoutInfoPageIsDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(firstNameField));
        return firstNameField.isDisplayed();
    }

    public CheckoutInfoPage setFirstName(String firstName) {
        set(firstNameField, firstName);
        return this;
    }

    public CheckoutInfoPage setLastName(String lastName) {
        set(lastNameField, lastName);
        return this;
    }

    public CheckoutInfoPage setPostalCode(String postalCode) {
        set(postalCodeField, postalCode);
        return this;
    }

    public CheckoutOverviewPage clickContinueButton() {
        click(continueButton);
        return new CheckoutOverviewPage(driver);
    }

    public void fillInformation(String firstName, String lastName, String postalCode) {
        setFirstName(firstName).setLastName(lastName).setPostalCode(postalCode);
    }
}
