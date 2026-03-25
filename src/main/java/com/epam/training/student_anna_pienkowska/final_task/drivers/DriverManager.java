package com.epam.training.student_anna_pienkowska.final_task.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private DriverManager(){};

    public static WebDriver getDriver(){
        if(driver.get() == null){
            switch (System.getProperty("browser")){
                case "chrome": {
                    WebDriverManager.chromedriver().setup();
                    driver.set(new ChromeDriver());
                    break;
                }
                case "firefox": {
                    WebDriverManager.firefoxdriver().setup();
                    driver.set(new FirefoxDriver());
                    break;
                }
                default: {
                    // todo: maybe add exception
                    WebDriverManager.chromedriver().setup();
                    driver.set(new ChromeDriver());
                    break;
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