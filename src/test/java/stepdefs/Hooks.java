package stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends UIBaseTest{


    @Before
    public void beforeClass(){
        getDriver();
    }

    @After
    public void afterClass(){
        driver.close();
    }
}
