package com.epam.training.student_anna_pienkowska.learining1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class LogInShouldFailTest {

    WebDriver driver;

    @BeforeClass  // run code before class
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize(); // maximize window
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @AfterClass // post condition
    public void tearDown() {
        driver.quit(); // closes every window and close driver
        // driver.close(); // only closes window
    }

    @Test
    public void testLoggingIntoApplication() throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement username = driver.findElement(By.name("username"));

        //object reference
        username.sendKeys("Admin"); // sends information to en element

        // java keyword that inferes datatype based on driver.findElement
        var password = driver.findElement(By.name("password"));
        password.sendKeys("admin123");

        // click the login button, here don't do object reference
        driver.findElement(By.tagName("button")).click();


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        String actualResult = driver.findElement(By.tagName("h6")).getText();
        // .getText() WebElement object to String
        String expectedResult = "Dashboard";

        Assert.assertNotEquals(actualResult, expectedResult);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        




    }
}
