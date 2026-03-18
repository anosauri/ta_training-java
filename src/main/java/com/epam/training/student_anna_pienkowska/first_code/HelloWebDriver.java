package com.epam.training.student_anna_pienkowska.first_code;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HelloWebDriver {
    public static void main(String[] args) throws InterruptedException {

        // Initialize
        WebDriver driver = new ChromeDriver();
        // Navigation
        driver.get("http://seleniumhq.org");

//        Other drivers
//        driver = new FirefoxDriver();
//        driver.get("http://seleniumhq.org");
//        Thread.sleep(2000);
//
//        driver = new EdgeDriver();
//        driver.get("http://seleniumhq.org");
//        Thread.sleep(2000);

        // Close
        driver.quit();
    }
}
