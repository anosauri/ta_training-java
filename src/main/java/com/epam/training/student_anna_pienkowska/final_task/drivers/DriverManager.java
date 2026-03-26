package com.epam.training.student_anna_pienkowska.final_task.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverManager {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private DriverManager(){};

    public static WebDriver getDriver(){
        if(driver.get() == null){
            String browser = System.getProperty("browser");
            if (browser == null) {
                browser = "chrome";
            }
            switch (browser){
                case "chrome": {
                    WebDriverManager.chromedriver().setup();
                    driver.set(new ChromeDriver());
                    break;
                }
                case "edge": {
                    WebDriverManager.edgedriver().setup();
                    driver.set(new EdgeDriver());
                    break;
                }
                default: {
                    throw new IllegalArgumentException(
                            "This browser is not supported. Please use chrome or edge.");
                }
            }
            driver.get().manage().window().maximize();
        }
        return driver.get();
    }

    public static void closeDriver(){
        driver.get().quit();
        driver.remove();
    }
}