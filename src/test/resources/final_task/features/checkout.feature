Feature: Checkout Process

  Background:
    Given User is on the Saucedemo login page
    When User logs in with username "standard_user" and password "secret_sauce"
    Then User is on the Saucedemo Products page

  Scenario: UC-1 Checkout Flow (one specific item)

    When User adds "Sauce Labs Backpack" to the cart
    And User goes to the cart
    Then User sees "Sauce Labs Backpack" in the cart

    When User proceeds to checkout
    And User provides First Name "Tony", Last Name "Stark" and Zip/Postal Code "00-000"
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
    And User provides First Name "Tony", Last Name "Stark" and Zip/Postal Code "00-000"
    And User clicks continue
    Then User is on Checkout: Overview page
    And User validates that total price equals the sum of both products

    When User clicks finish
    Then User sees the successful order message "Thank you for your order!"