package helper.errorMessages;

public enum APIErrorMessages {
    invalidEmail("Path `email` is invalid"),
    invalidFirstName(" is longer than the maximum allowed length (30)."),
    invalidLastName("is longer than the maximum allowed length (30)."),
    invalidDateOfBirth("Cast to date failed for value "),
    invalidTitle(" is not a valid enum value for path `title`."),
    invalidGender(" is not a valid enum value for path `gender`."),
    invalidBodyRequest("BODY_NOT_VALID");
    final String message;
    APIErrorMessages(String message){
        this.message = message;
    }
    public String getMessage(){
        return this.message;
    }
}
