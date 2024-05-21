package stepdefs;

import helper.jsonSchema.request.UserRequest;
import helper.util.ApiUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CRUDPage;

import java.io.File;

public class CRUDStepDefs {
    CRUDPage crudPage = new CRUDPage();
    static UserRequest userRequest = new UserRequest();

    @Given("user set endpoint with {string} and {string}")
    public void userSetEndpointWithUserId(String endpoint, String userId) {
        crudPage.setGetAndUpdateURL(endpoint, userId);
    }

    @When("user hit get API")
    public void userHitGetAPI() {
        crudPage.getUserData();
    }

    @Then("user should get status code {int}")
    public void userShouldGetStatusCode(int statusCode) {
        crudPage.verifyStatusCode(statusCode);
    }

    @And("user should get the correct response as {string}")
    public void userShouldGetTheCorrectResponseAsJsonSchemaGetUserInfo(String filename) {
       crudPage.verifyUserDataResponse(filename);

    }

    @Given("user set {string} endpoint")
    public void userSetCreateUserAndTagEndpoint(String endpoint) {
        crudPage.setCreateAndTagURL(endpoint);
    }

    @When("user hit post API")
    public void userHitPostAPI() {
        crudPage.createUser();
    }

    @And("user set first name with {string}")
    public void userSetFirstNameWithNewName(String firstname) {
        userRequest.firstName = firstname;

    }

    @When("user hit PUT API")
    public void userHitPUTAPI() {
        crudPage.updateUser();
    }

    @And("user data should be updated")
    public void userDataShouldBeUpdated() {
        crudPage.verifyUserDataAfterUpdate();
    }

    @And("User set delete endpoint")
    public void userSetDeleteEndpoint() {
        crudPage.setDeleteURL();
    }

    @Then("user hit DELETE API")
    public void userHitDELETEAPI() {
        crudPage.deleteUser();
    }

    @And("the correct user should be deleted")
    public void theCorrectUserShouldBeDeleted() {
        crudPage.verifyUserDeleted();
    }

    @And("user should get error message {string}")
    public void userShouldGetErrorMessage(String message) {
        crudPage.validateErrorMessage(message);
    }

    @And("the response should have the correct value")
    public void theResponseShouldHaveTheCorrectValue() {
        crudPage.validateCreateUserResponseBody();
    }

    @When("user hit post API with invalid values")
    public void userHitPostAPIWithInvalidValues() {
        crudPage.createUserWithInvalidValues();
    }

    @And("user should get create error messages")
    public void userShouldGetCreateErrorMessages() {
        crudPage.validateUserCreateErrorMessages();
    }

}
