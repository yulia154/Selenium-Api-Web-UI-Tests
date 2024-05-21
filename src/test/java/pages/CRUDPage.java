package pages;


import helper.Endpoint;
import helper.Models;
import helper.util.ApiUtil;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.junit.Assert;

import java.io.File;

public class CRUDPage {
//    public static Models models = new Models();
    static String url;
    static Response response;
    String deleteUserId;

    public void setCreateAndTagURL(String endpoint){
        if(endpoint.equals("post")){
            url = Endpoint.CREATE_NEW_USER;
        }else if(endpoint.equals("tag")){
            url = Endpoint.GET_LIST_OF_TAGS;
        }

    }

    public void setDeleteURL(){
        deleteUserId = response.getBody().path("id").toString();
        url = Endpoint.DELETE_USER_DATA + deleteUserId;
    }

    public void setGetAndUpdateURL(String endpoint, String userId){
        Assert.assertNotNull("user id is needed and should not ne null", userId);
        if(endpoint.equals("get")){
            url = Endpoint.GET_USER_DATA+userId;
        } else if (endpoint.equals("update")){
            url = Endpoint.UPDATE_USER_DATA+userId;
        }
    }
    public void getUserData(){
        Assert.assertNotNull("url is null", url);
        response = Models.getData(url);
        response.print();
    }

    public void createUser(){
        response = Models.createUserData(url);
        response.print();
    }

    public void updateUser(){
       response = Models.updateUserData(url);
       response.print();
    }
    public void deleteUser(){
        response = Models.deleteUserData(url);
        response.print();
    }

    public void createUserWithInvalidValues(){
        response = Models.createWithInvalidValue(url);
        response.print();
    }

    public void validateUserCreateErrorMessages(){
        ApiUtil.validateCreateErrorMessages(response);
    }

    public void verifyStatusCode(int statusCode){
        Assert.assertEquals(response.getStatusCode(), statusCode);
    }

    public void verifyUserDataResponse(String fileName){

        File userData = ApiUtil.jsonSchema(fileName);
        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(userData));
    }

    public void validateCreateUserResponseBody(){
        ApiUtil.validateUserBodyResponse(response);
    }

    public void verifyUserDataAfterUpdate(){
        ApiUtil.validateUserBodyResponse(response);
        ApiUtil.validateBodyResponseAfterUpdate(response);
    }

    public void verifyUserDeleted(){
        Assert.assertEquals(response.getBody().path("id"), deleteUserId);
    }

    public void validateErrorMessage(String message){
        Assert.assertEquals(message, response.getBody().path("error"));
    }

}
