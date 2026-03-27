package com.epam.training.student_anna_pienkowska.final_task.steps;

import com.epam.training.student_anna_pienkowska.final_task.drivers.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void setup() {
    }

    @After
    public void tearDown() {
        DriverManager.closeDriver();
    }
}