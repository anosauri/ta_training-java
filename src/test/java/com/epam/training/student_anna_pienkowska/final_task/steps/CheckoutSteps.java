package com.epam.training.student_anna_pienkowska.final_task.steps;

import com.epam.training.student_anna_pienkowska.final_task.drivers.DriverManager;
import com.epam.training.student_anna_pienkowska.final_task.pages.LoginPage;
import com.epam.training.student_anna_pienkowska.final_task.pages.ProductsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckoutSteps {

    private LoginPage loginPage;
    private ProductsPage productsPage;
    // todo: cartPage, checkoutPage

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
    public void userAddsToTheCart(String arg0) {
    }

    @And("User goes to the cart")
    public void userGoesToTheCart() {
    }

    @Then("User sees {string} in the cart")
    public void userSeesInTheCart(String arg0) {
    }

    @When("User proceeds to checkout")
    public void userProceedsToCheckout() {
    }

    @And("User provides First Name {string}, Last Name {string} and Zip\\/Postal Code {string}")
    public void userProvidesFirstNameLastNameAndZipPostalCode(String arg0, String arg1, String arg2) {
    }

    @And("User clicks continue")
    public void userClicksContinue() {
    }

    @Then("User is on Checkout: Overview page")
    public void userIsOnCheckoutOverviewPage() {
    }

    @When("User clicks finish")
    public void userClicksFinish() {
    }

    @Then("User sees the successful order message {string}")
    public void userSeesTheSuccessfulOrderMessage(String arg0) {
    }

    @And("User validates that total price equals the sum of both products")
    public void userValidatesThatTotalPriceEqualsTheSumOfBothProducts() {
    }
}
