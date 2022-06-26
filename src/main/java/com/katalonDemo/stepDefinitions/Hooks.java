package com.katalonDemo.stepDefinitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;

import static com.katalonDemo.utils.DriverUtils.getDriver;
import static com.katalonDemo.utils.DriverUtils.tearDown;

public class Hooks {

    @Before
    public void setUp(){
        getDriver();
    }

    @After
    public void teardown(){

        tearDown();
    }
}
