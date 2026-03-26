package com.epam.training.student_anna_pienkowska.final_task.runners;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/final_task/features",
        glue = "",
        monochrome = true
)

public class TestRunner extends AbstractTestNGCucumberTests {

}
