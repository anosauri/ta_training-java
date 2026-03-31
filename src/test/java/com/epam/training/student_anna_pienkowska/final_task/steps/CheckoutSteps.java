package com.epam.training.student_anna_pienkowska.final_task.steps;

import com.epam.training.student_anna_pienkowska.final_task.drivers.DriverManager;
import com.epam.training.student_anna_pienkowska.final_task.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

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
        //TODO please avoid hardcoding urls in the code, you can use properties file to store them and read from there
        DriverManager.getDriver().get("https://www.saucedemo.com/");
    }

    @When("User logs in with username {string} and password {string}")
    public void userLogsInWithUsernameAndPassword(String username, String password) {
        productsPage = loginPage.logInto(username, password);
    }

    @Then("User is on the Saucedemo Products page")
    public void userIsOnTheSaucedemoProductsPage() {
        Assert.assertTrue(productsPage.productsPageIsDisplayed(), "Saucedemo products page did not display");
    }

    @When("User adds {string} to the cart")
    public void userAddsToTheCart(String productName) {
        productsPage.addProductToCart(productName);
    }

    @And("User goes to the cart")
    public void userGoesToTheCart() {
        cartPage = productsPage.goToCart();
    }

    @Then("User sees {string} in the cart")
    public void userSeesInTheCart(String productName) {
        Assert.assertTrue(cartPage.cartPageIsDisplayed(), "Saucedemo cart page did not load.");
        Assert.assertTrue(cartPage.productIsDisplayed(productName),productName + " is not in the cart.");
    }

    @When("User proceeds to checkout")
    public void userProceedsToCheckout() {
        checkoutInfoPage = cartPage.checkout();
        Assert.assertTrue(checkoutInfoPage.checkoutInfoPageIsDisplayed(), "Saucedemo checkout info page did not load.");
    }

    @And("User provides First Name {string}, Last Name {string} and Postal Code {string}")
    public void userProvidesFirstNameLastNameAndZipPostalCode(String firstName, String lastName, String postalCode) {
        checkoutInfoPage.fillInformation(firstName, lastName, postalCode);
    }

    @And("User clicks continue")
    public void userClicksContinue() {
        checkoutOverviewPage = checkoutInfoPage.clickContinueButton();
    }

    @Then("User is on Checkout: Overview page")
    public void userIsOnCheckoutOverviewPage() {
        Assert.assertTrue(checkoutOverviewPage.checkoutOverviewPageIsDisplayed(), "Saucedemo checkout overview page did not load.");
    }

    @When("User clicks finish")
    public void userClicksFinish() {
        checkoutCompletePage = checkoutOverviewPage.clickFinishButton();
    }

    @Then("User sees the successful order message {string}")
    public void userSeesTheSuccessfulOrderMessage(String message) {
        Assert.assertTrue(checkoutCompletePage.isCheckoutCompletePageDisplayed(), "Saucedemo checkout complete page did not load.");
        Assert.assertTrue(checkoutCompletePage.isCheckoutCompleted(message), "Saucedemo completed order message did not display.");
    }

    @And("User validates that total price equals the sum of both products")
    public void userValidatesThatTotalPriceEqualsTheSumOfBothProducts() {
        Assert.assertTrue(checkoutOverviewPage.checkSum(), "Total price is not equal to the sum of both products");
    }
}
