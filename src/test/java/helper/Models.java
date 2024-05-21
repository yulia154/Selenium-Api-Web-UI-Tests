package helper;

import helper.jsonSchema.request.Location;
import helper.jsonSchema.request.UserRequest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Random;

public class Models extends Endpoint{
    public static String appID = "6644e3694963517752f0460d";
    public static String contentType = "application/json";
    public static String accept = "application/json";
    public static RequestSpecification httpRequest;
    static UserRequest userRequest = new UserRequest();
    static Random rand = new Random();

    public static void setUpHeaders(){
        httpRequest = RestAssured.given()
                .header("app-id",appID)
                .header("Content-type",contentType)
                .header("Accept",accept);
        System.out.println("set up header called");
    }

    public static Response getData(String endpoint){
        setUpHeaders();
//        return "get user data";
        return httpRequest.when().get(endpoint);
    }

    public static Response createUserData(String endpoint){
        setUpHeaders();
        return httpRequest.body(userRequest).post(endpoint);
    }

    public static Response updateUserData(String endpoint){

        userRequest.firstName = "new name";
        userRequest.lastName = "new last name";
        userRequest.email = "new.automatedEmail"+rand.nextInt(10000)+"@mail.com";
        userRequest.phone = "0000071621532";
        userRequest.location = new Location("new 9614, SÃ¸ndermarksvej","new Kongsvinger","new Nordjylland","new Denmark", "-9:00");
        System.out.println(userRequest);
        setUpHeaders();
        return httpRequest.body(userRequest).put(endpoint);
    }

    public static Response deleteUserData(String endpoint){
        setUpHeaders();
        return httpRequest.when().delete(endpoint);
    }
    public static Response createWithInvalidValue(String endpoint){

        userRequest.title = "anything";
        userRequest.firstName = "name "+generateLongName();
        userRequest.lastName = "name "+ generateLongName();
        userRequest.email = "new.automatedEmail";
        userRequest.dateOfBirth = "anything";
        userRequest.gender = "anything";
        setUpHeaders();
        return httpRequest.body(userRequest).post(endpoint);
    }

    public static String generateLongName(){
        String name = null;
        for(int i=0;i<10;i++){
            name = name + rand.nextInt();
        }
        return name;
    }
}
