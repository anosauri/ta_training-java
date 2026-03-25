package com.epam.training.student_anna_pienkowska.final_task.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected void set(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }

    protected void click(WebElement element) {
        element.click();
    }
}
