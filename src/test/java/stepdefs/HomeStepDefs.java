package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;

public class HomeStepDefs extends UIBaseTest{
    HomePage homePage = new HomePage(driver);
    @Given("user is on home page")
    public void userIsOnHomePage() {
        homePage.goToHomePage();
    }

    @Then("title {string} should be shown")
    public void titleShouldBeShown(String title) throws InterruptedException {
        homePage.validateTitle(title);
    }

    @When("user click {string}")
    public void userClickMenu(String menu) throws InterruptedException {
        homePage.clickMenu(menu);

    }

    @And("button {string} should be shown")
    public void buttonShouldBeShown(String button) throws Exception{
        homePage.checkButton(button);
    }

    @Then("alert {string} should present")
    public void alertProductAddedShouldPresent(String message) throws InterruptedException {
        homePage.validateAlert(message);    }
}
