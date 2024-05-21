package helper.jsonSchema.request;

public class Location {
    public String street;
    public String city ;
    public String state;
    public String country;
    public String timezone ;

    public Location(String street, String city, String state, String country, String timezone){
        this.city = city;
        this.state = state;
        this.street = street;
        this.country = country;
        this.timezone = timezone;
    }
}
