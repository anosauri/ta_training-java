package com.epam.training.student_anna_pienkowska.final_task.steps;

import com.epam.training.student_anna_pienkowska.final_task.drivers.DriverManager;
import com.epam.training.student_anna_pienkowska.final_task.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckoutSteps {

    private LoginPage loginPage;
    private ProductsPage productsPage;
    private CartPage cartPage;
    private CheckoutInfoPage checkoutInfoPage;
    private CheckoutOverviewPage checkoutOverviewPage;
    private CheckoutCompletePage checkoutCompletePage;

    @Given("User is on the Saucedemo login page")
    public void userIsOnTheSaucedemoLoginPage() {
        loginPage = new LoginPage(DriverManager.getDriver());
        productsPage = new ProductsPage(DriverManager.getDriver());
        DriverManager.getDriver().get("https://www.saucedemo.com/");
    }

    @When("User logs in with username {string} and password {string}")
    public void userLogsInWithUsernameAndPassword(String username, String password) {
        loginPage.logInto(username, password);
    }

    @Then("User is on the Saucedemo Products page")
    public void userIsOnTheSaucedemoProductsPage() {
        productsPage.productsPageIsDisplayed();
    }

    @When("User adds {string} to the cart")
    public void userAddsToTheCart(String productName) {
        productsPage.addProductToCart(productName);
    }

    @And("User goes to the cart")
    public void userGoesToTheCart() {
        cartPage = new CartPage(DriverManager.getDriver());
        productsPage.goToCart();
    }

    @Then("User sees {string} in the cart")
    public void userSeesInTheCart(String productName) {
        cartPage.cartPageIsDisplayed();
        cartPage.productIsDisplayed(productName);
    }

    @When("User proceeds to checkout")
    public void userProceedsToCheckout() {
        checkoutInfoPage = new CheckoutInfoPage(DriverManager.getDriver());
        cartPage.checkout();
        checkoutInfoPage.checkoutInfoPageIsDisplayed();
    }

    @And("User provides First Name {string}, Last Name {string} and Postal Code {string}")
    public void userProvidesFirstNameLastNameAndZipPostalCode(String firstName, String lastName, String postalCode) {
        checkoutInfoPage.fillInformation(firstName, lastName, postalCode);
    }

    @And("User clicks continue")
    public void userClicksContinue() {
        checkoutOverviewPage = new CheckoutOverviewPage(DriverManager.getDriver());
        checkoutInfoPage.clickContinueButton();
    }

    @Then("User is on Checkout: Overview page")
    public void userIsOnCheckoutOverviewPage() {
        checkoutOverviewPage.checkoutOverviewPageIsDisplayed();
    }

    @When("User clicks finish")
    public void userClicksFinish() {
        checkoutCompletePage = new CheckoutCompletePage(DriverManager.getDriver());
        checkoutOverviewPage.clickFinishButton();
    }

    @Then("User sees the successful order message {string}")
    public void userSeesTheSuccessfulOrderMessage(String message) {
        checkoutCompletePage.isCheckoutCompletePageDisplayed();
        checkoutCompletePage.isCheckoutCompleted(message);
    }

    @And("User validates that total price equals the sum of both products")
    public void userValidatesThatTotalPriceEqualsTheSumOfBothProducts() {
        checkoutOverviewPage.checkSum();
    }
}
