package com.epam.training.student_anna_pienkowska.final_task.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPage extends BasePage {

    @FindBy(xpath = "//span[text()='Products']")
    private WebElement productsHeader;

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public boolean productsPageIsDisplayed() {
        return productsHeader.isDisplayed();
    }
}
