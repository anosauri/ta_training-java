# Test Automation Course - Final Task
**The `final_task` package is the main project in this repository. This README and all execution instructions below apply to it.**

Other packages such as `learning1` and `first_code` contain earlier practice code and drafts created during the learning process.
## Final Task Description
**End-to-end flow**  
**Focus:**  User completes full flow from login to checkout  
**Launch URL:** https://www.saucedemo.com/  

**UC-1 Checkout Flow (one item)**
* Login with standard_user.
* Add a specific product to the cart
  (parametrize product name, e.g., "Sauce
  Labs Backpack").
* Go to Cart and validate the item is present.
* Proceed to Checkout.
* Fill in Information form (First Name, Last
  Name, Zip).
* Complete checkout and validate success
  message: "Thank you for your order!"

**UC-2 Checkout Flow (several items)**  
* Login with standard_user.
* Add a specific product to the cart
  (parametrize product name, e.g., "Sauce
  Labs Backpack").
* Add another product to the cart,
* Go to Cart and validate both items are
  present.
* Proceed to Checkout.
  Fill in Information form (First Name, Last
  Name, Zip).
* Validate final price equals the sum of both
  product prices.
* Complete checkout and validate success
  message: "Thank you for your order!"

**Technical Requirements:**  
**Tool:** Selenium WebDriver  
**Browsers:** Chrome, Edge (Run in Parallel)  
**Pattern:** Page Object Model (POM)  
**Locators:** CSS Selectors, Xpath  
**Reporting:** Allure (or similar HTML report)  
**Documentation:** README.md with execution and report instructions  
## Final Task Structure 
The Final Task contains tests for two checkout flows in the Saucedemo store, organized using the Page Object Model (POM) and BDD patterns.

**Page Object & Setup (`src/main/java/com/epam/training/student_anna_pienkowska/final_task/`)**
* `drivers/` - contains the thread-safe `DriverManager` configured for parallel execution
* `pages/` - contains the POM classes for UI interactions

**Test Code (`src/test/java/com/epam/training/student_anna_pienkowska/final_task/`)**
* `runners/` - contains the `TestRunner` class
* `steps/` - contains Cucumber step definitions and Hooks

**Test Resources (`src/test/resources/final_task/features/`)**
* `checkout.feature` - contains test scenarios written in Gherkin

## Execution instructions
The tests are configured to run in parallel (two scenarios execute at the same time). You can run them in Chrome or Edge. If no browser is specified in the command, Chrome is used by default.

Run without specifying a browser:

```bash
mvn clean test
```
Run in Chrome:
```bash
mvn clean test -Dbrowser=chrome
```
Run in Edge:
```bash
mvn clean test -Dbrowser=edge
```

## Report instructions
The project is integrated with Allure for HTML test reporting. After the tests finish, you can generate and view the report by running:
```bash
mvn allure:serve
```