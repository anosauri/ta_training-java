Feature: Checkout Process

  Background:
    Given User is on the Saucedemo login page
    #TODO: Better to have user credentials in a separate file and read from there
    # So your step could be : User logs in with standard credentials.
    # see here we don't care about the actual credentials,
    # we just want to use the standard ones, and if credentials change we don't need to
    # change the step definition, we just need to change the data file
    When User logs in with username "standard_user" and password "secret_sauce"
    Then User is on the Saucedemo Products page

  Scenario: UC-1 Checkout Flow (one specific item)

    When User adds "Sauce Labs Backpack" to the cart
    And User goes to the cart
    Then User sees "Sauce Labs Backpack" in the cart

    When User proceeds to checkout
    And User provides First Name "Tony", Last Name "Stark" and Postal Code "00-000"
    And User clicks continue
    Then User is on Checkout: Overview page

    When User clicks finish
    Then User sees the successful order message "Thank you for your order!"

  Scenario: UC-2 Checkout Flow (several items)

    When User adds "Sauce Labs Backpack" to the cart
    And User adds "Sauce Labs Onesie" to the cart
    And User goes to the cart
    Then User sees "Sauce Labs Backpack" in the cart
    And User sees "Sauce Labs Onesie" in the cart

    When User proceeds to checkout
    And User provides First Name "Tony", Last Name "Stark" and Postal Code "00-000"
    And User clicks continue
    Then User is on Checkout: Overview page
    And User validates that total price equals the sum of both products

    When User clicks finish
    Then User sees the successful order message "Thank you for your order!"