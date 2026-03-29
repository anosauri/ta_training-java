package com.epam.training.student_anna_pienkowska.final_task.runners;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/resources/final_task/features",
        glue = "com.epam.training.student_anna_pienkowska.final_task.steps",
        monochrome = true,
        plugin = "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
)

public class TestRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
