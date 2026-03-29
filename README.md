# Test Automation Course - Final Task
**The `final_task` package is the main project in this repository. This README and all execution instructions below apply to it.**

Other packages such as `learning1` and `first_code` contain earlier practice code and drafts created during the learning process.

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
mvn clean test -Dtest=TestRunner
```
Run in Chrome:
```bash
mvn clean test -Dtest=TestRunner -Dbrowser=chrome
```
Run in Edge:
```bash
mvn clean test -Dtest=TestRunner -Dbrowser=edge
```

## Report instructions
The project is integrated with Allure for HTML test reporting. After the tests finish, you can generate and view the report by running:
```bash
mvn allure:serve
```