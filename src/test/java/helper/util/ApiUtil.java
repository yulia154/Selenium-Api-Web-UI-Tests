package helper.util;

import helper.errorMessages.APIErrorMessages;
import helper.jsonSchema.request.UserRequest;
import io.restassured.response.Response;
import org.joda.time.format.DateTimeFormat;
import org.junit.Assert;

import java.io.File;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ApiUtil {
    static UserRequest userRequest = new UserRequest();

    public static File jsonSchema(String filename){
        return  new File("src/test/java/helper/jsonSchema/"+filename);
    }

    public static void validateUserBodyResponse(Response response){
        //verify the mandatory fields should not be null and have the correct value
        Assert.assertNotNull(response.getBody().path("id"));
        assertThat(response.getBody().path("title").toString(), isOneOf("mr", "ms", "mrs", "miss", "dr", ""));
        Assert.assertNotNull(response.getBody().path("firstName"));
        Assert.assertNotNull(response.getBody().path("gender"));
        assertThat(response.getBody().path("gender"), isOneOf("male", "female","other"));
        Assert.assertTrue(emailValidation(response.getBody().path("email").toString()));
        Assert.assertNotNull(response.getBody().path("dateOfBirth"));
        Assert.assertTrue(dateValidation(response.getBody().path("dateOfBirth")));
        Assert.assertNotNull(response.getBody().path("phone"));
        Assert.assertTrue(dateValidation(response.getBody().path("registerDate")));
        Assert.assertTrue(dateValidation(response.getBody().path("updatedDate")));
        Assert.assertNotNull(response.getBody().path("location.street"));
        Assert.assertNotNull(response.getBody().path("location.city"));
        Assert.assertNotNull(response.getBody().path("location.state"));
        Assert.assertNotNull(response.getBody().path("location.country"));
        Assert.assertNotNull(response.getBody().path("location.timezone"));
    }

    public static void validateBodyResponseAfterUpdate(Response response){
        Assert.assertTrue(response.getBody().path("firstName").toString().contains("new"));
        Assert.assertTrue(response.getBody().path("lastName").toString().contains("new"));
        Assert.assertTrue(response.getBody().path("location.street").toString().contains("new"));
        Assert.assertTrue(response.getBody().path("location.city").toString().contains("new"));
        Assert.assertTrue(response.getBody().path("location.state").toString().contains("new"));
        Assert.assertTrue(response.getBody().path("location.country").toString().contains("new"));
    }

    public static void validateCreateErrorMessages(Response response){
        Assert.assertEquals(APIErrorMessages.invalidBodyRequest.getMessage(), response.getBody().path("error"));
        Assert.assertTrue(response.getBody().path("data.title").toString().contains(APIErrorMessages.invalidTitle.getMessage()));
        Assert.assertTrue(response.getBody().path("data.firstName").toString().contains(APIErrorMessages.invalidFirstName.getMessage()));
        Assert.assertTrue(response.getBody().path("data.lastName").toString().contains(APIErrorMessages.invalidLastName.getMessage()));
        Assert.assertTrue(response.getBody().path("data.email").toString().contains(APIErrorMessages.invalidEmail.getMessage()));
        Assert.assertTrue(response.getBody().path("data.dateOfBirth").toString().contains(APIErrorMessages.invalidDateOfBirth.getMessage()));
        Assert.assertTrue(response.getBody().path("data.gender").toString().contains(APIErrorMessages.invalidGender.getMessage()));

    }

    public static boolean emailValidation(String email){
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";
        return Pattern.compile(emailRegex).matcher(email).matches();
    }

    public static boolean dateValidation(String date){
        String dateRegex = "^(-?(?:[1-9][0-9]*)?[0-9]{4})-(1[0-2]|0[1-9])-(3[01]|0[1-9]|[12][0-9])" +
                "T(2[0-3]|[01][0-9]):([0-5][0-9]):([0-5][0-9])(.[0-9]+)?" +
                "(Z|[+-](?:2[0-3]|[01][0-9]):[0-5][0-9])?$";
        return date.matches(dateRegex);
//

    }

}
