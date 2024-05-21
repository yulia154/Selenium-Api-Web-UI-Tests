package helper.jsonSchema.request;


import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class UserRequest {
    static RequestValue req = new RequestValue();
    public String title = req.pickValueOfTitle();
    public  String firstName= "name";
    public  String lastName ="automated";
    public  String picture= "https://randomuser.me/api/portraits/women/58.jpg";
    public  String gender  = req.pickValueOfGender();
    public  String email ="automated.email"+req.pickRandomNumber()+"@mail.com";
    public  String dateOfBirth= "1996-04-30T19:26:49.610Z";
    public  String phone="836723526";
    public  Location location= new Location("9614, SÃ¸ndermarksvej","Kongsvinger","Nordjylland","Denmark", "-9:00");

}
