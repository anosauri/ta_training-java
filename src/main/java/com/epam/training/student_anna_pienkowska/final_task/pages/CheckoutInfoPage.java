package com.epam.training.student_anna_pienkowska.final_task.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutInfoPage extends BasePage {

    @FindBy(css = "span[data-test='title']")
    private WebElement checkoutInfoTitle;

    @FindBy(css = "#first-name")
    private WebElement firstNameField;

    @FindBy(css = "#last-name")
    private WebElement lastNameField;

    @FindBy(css = "#postal-code")
    private WebElement postalCodeField;

    @FindBy(css = "#continue")
    private WebElement continueButton;

    public CheckoutInfoPage(WebDriver driver) {
        super(driver);
    }

    public boolean checkoutInfoPageIsDisplayed() {
        return checkoutInfoTitle.isDisplayed();
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

    public CheckoutOverviewPage fillInformation(String firstName, String lastName, String postalCode) {
        setFirstName(firstName);
        setLastName(lastName);
        setPostalCode(postalCode);
        return clickContinueButton();
    }
}
