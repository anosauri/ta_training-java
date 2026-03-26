package com.epam.training.student_anna_pienkowska.final_task.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(id = "user-name")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(xpath = "//h3[@data-test='error']")
    private WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage setUsername(String username) {
        set(usernameField, username);
        return this;
    }

    public LoginPage setPassword(String password) {
        set(passwordField, password);
        return this;
    }

    public ProductsPage clickLoginButton() {
        click(loginButton);
        return new ProductsPage(driver);
    }

    public ProductsPage logInto(String username, String password) {
        set(usernameField, username);
        set(passwordField, password);
        return clickLoginButton();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }

}
