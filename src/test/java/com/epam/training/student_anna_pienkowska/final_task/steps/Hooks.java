package com.epam.training.student_anna_pienkowska.final_task.steps;

import com.epam.training.student_anna_pienkowska.final_task.drivers.DriverManager;
import io.cucumber.java.After;

public class Hooks {
    @After
    public void tearDown() {
        DriverManager.closeDriver();
    }
}