package com.epam.training.student_anna_pienkowska.final_task.steps;

import com.epam.training.student_anna_pienkowska.final_task.drivers.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void setup() {
        //TODO What's the point of this method? It doesn't do anything.
    }

    @After
    public void tearDown() {
        DriverManager.closeDriver();
    }
}